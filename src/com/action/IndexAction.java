package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Bcate;
import com.entity.Books;
import com.entity.Charge;
import com.entity.Fav;
import com.entity.Pays;
import com.entity.Scate;
import com.entity.Sections;
import com.entity.Users;
import com.service.ArticleService;
import com.service.BcateService;
import com.service.BooksService;
import com.service.ChargeService;
import com.service.FavService;
import com.service.PaysService;
import com.service.RecommendService;
import com.service.ScateService;
import com.service.SectionsService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexAction extends BaseAction {

	@Autowired
	@Resource
	private UsersService usersService;
	@Autowired
	@Resource
	private ArticleService articleService;
	@Autowired
	@Resource
	private BcateService bcateService;
	@Autowired
	@Resource
	private ScateService scateService;
	@Autowired
	@Resource
	private BooksService booksService;
	@Autowired
	@Resource
	private SectionsService sectionsService;
	@Autowired
	@Resource
	private FavService favService;
	@Autowired
	@Resource
	private ChargeService chargeService;
	@Autowired
	@Resource
	private PaysService paysService;
	@Autowired
	@Resource
	private RecommendService recommendService;

	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "基于大数据的小说阅读网站");
		List<Bcate> cateList = this.bcateService.getAllBcate();
		List<Bcate> frontList = new ArrayList<Bcate>();
		for (Bcate bcate : cateList) {
			Scate scate = new Scate();
			scate.setBcateid(bcate.getBcateid());
			List<Scate> scateList = this.scateService.getScateByCond(scate);
			bcate.setScateList(scateList);
			frontList.add(bcate);
		}
		this.getRequest().setAttribute("cateList", frontList);
		// 推荐图书的算法 1 用户未登录 直接调用BooksService的getBooksByHot方法
		// 2 用户登录 但是没有收藏图书 则调用1
		// 3 用户登录 且有收藏的图书 调用recommendService 通过协同过滤算法 自动推荐图书
		if (this.getSession().getAttribute("userid") == null) {
			List<Books> hotList = this.booksService.getHotBooks();
			this.getRequest().setAttribute("hotList", hotList);
		} else {
			String userid = (String) this.getSession().getAttribute("userid");
			Fav hist = new Fav();
			hist.setUsersid(userid);
			List<Fav> histList = this.favService.getFavByCond(hist);
			if (histList.size() == 0) {
				List<Books> hotList = this.booksService.getHotBooks();
				this.getRequest().setAttribute("hotList", hotList);
			} else {
				List<Books> hotList = this.recommendService.getRecommend(userid);
				this.getRequest().setAttribute("hotList", hotList);
			}
		}

	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Bcate> bcateList = this.bcateService.getFrontBcate();
		List<Bcate> frontList = new ArrayList<Bcate>();
		for (Bcate bcate : bcateList) {
			Scate scate = new Scate();
			scate.setBcateid(bcate.getBcateid());
			List<Scate> scateList = this.scateService.getScateByCond(scate);
			List<Books> booksList = this.booksService.getBooksCate(bcate.getBcateid());
			bcate.setBooksList(booksList);
			bcate.setScateList(scateList);
			frontList.add(bcate);
		}
		this.getRequest().setAttribute("frontList", frontList);
		List<Books> booksList = this.booksService.getNewBooks();
		this.getRequest().setAttribute("newsList", booksList);
		List<Article> articleList = this.articleService.getFrontArticle();
		this.getRequest().setAttribute("articleList", articleList);
		return "users/index";
	}

	@RequestMapping("bcate.action")
	public String bcate(String number, String id) {
		this.front();
		Books books = new Books();
		books.setBcateid(id);
		books.setStatus("连载中");
		List<Books> booksList = this.booksService.getBooksByCond(books);
		PageHelper.getIndexPage(booksList, "books", "bcate", 12, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("scate.action")
	public String scate(String number, String id) {
		this.front();
		Books books = new Books();
		books.setScateid(id);
		books.setStatus("连载中");
		List<Books> booksList = this.booksService.getBooksByCond(books);
		PageHelper.getIndexPage(booksList, "books", "scate", 12, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("all.action")
	public String all(String number) {
		this.front();
		Books books = new Books();
		books.setStatus("连载中");
		List<Books> booksList = this.booksService.getBooksByCond(books);
		PageHelper.getIndexPage(booksList, "books", "all", 12, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("allOver.action")
	public String allOver(String number) {
		this.front();
		Books books = new Books();
		books.setStatus("完本");
		List<Books> booksList = this.booksService.getBooksByCond(books);
		PageHelper.getIndexPage(booksList, "books", "allOver", 12, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("recommend.action")
	public String recommend(String number) {
		this.front();
		List<Books> booksList = this.booksService.getRecommendBooks();
		PageHelper.getIndexPage(booksList, "books", "recommend", 12, number, this.getRequest());
		return "users/list";
	}

	@RequestMapping("query.action")
	public String query(String number) {
		this.front();
		String booksname = this.getRequest().getParameter("name");
		Books books = new Books();
		books.setBooksname(booksname);
		List<Books> booksList = this.booksService.getBooksByLike(books);
		this.getRequest().setAttribute("booksList", booksList);
		return "users/list";
	}

	@RequestMapping("detail.action")
	public String detail(String id) {
		this.front();
		Books books = this.booksService.getBooksById(id);
		books.setHits("" + (Integer.parseInt(books.getHits()) + 1));
		this.booksService.updateBooks(books);
		this.getRequest().setAttribute("books", books);
		Sections sections = new Sections();
		sections.setBooksid(id);
		List<Sections> sectionsList = this.sectionsService.getSectionsByCond(sections);
		this.getRequest().setAttribute("sectionsList", sectionsList);
		return "users/detail";
	}

	// 公告
	@RequestMapping("article.action")
	public String article(String number) {
		this.front();
		List<Article> tempList = this.articleService.getAllArticle();
		PageHelper.getIndexPage(tempList, "article", "article", 10, number, this.getRequest());
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if (password.equals(users.getPassword())) {
				if ("锁定".equals(users.getStatus())) {
					this.getSession().setAttribute("message", "账户被锁定,请等待管理员解锁");
					return "redirect:/index/preLogin.action";
				} else {
					this.getSession().setAttribute("userid", users.getUsersid());
					this.getSession().setAttribute("username", users.getUsername());
					this.getSession().setAttribute("users", users);
					this.getSession().setAttribute("role", users.getRole());
					return "redirect:/index/index.action";
				}
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		u.setPassword(users.getPassword());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			String status = "锁定";
			if ("作者".equals(users.getRole())) {
				status = "锁定";
			} else {
				status = "-";
			}
			users.setMoney("10");
			users.setStatus(status);
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		this.getSession().removeAttribute("role");
		return "index";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		return "redirect:/index/userinfo.action";
	}

	@RequestMapping("preBooks.action")
	public String preBooks() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addbooks";
	}

	@RequestMapping("addBooks.action")
	public String addBooks(Books books) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		books.setAddtime(VeDate.getStringDateShort());
		books.setHits("0");
		books.setStatus("待审核");
		books.setUsersid(userid);
		this.booksService.insertBooks(books);
		return "redirect:/index/preBooks.action";
	}

	@RequestMapping("myBooks.action")
	public String myBooks() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Books books = new Books();
		books.setUsersid(userid);
		List<Books> booksList = this.booksService.getBooksByCond(books);
		this.getRequest().setAttribute("booksList", booksList);
		return "users/mybooks";
	}

	@RequestMapping("over.action")
	public String over(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Books books = this.booksService.getBooksById(id);
		books.setStatus("完本");
		this.booksService.updateBooks(books);
		return "redirect:/index/myBooks.action";
	}

	@RequestMapping("preSections.action")
	public String preSections() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Books books = new Books();
		books.setUsersid(userid);
		books.setStatus("连载中");
		List<Books> booksList = this.booksService.getBooksByCond(books);
		this.getRequest().setAttribute("booksList", booksList);
		return "users/addsection";
	}

	@RequestMapping("addSections.action")
	public String addSections(Sections sections) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String booksid = sections.getBooksid();
		Sections s = new Sections();
		s.setBooksid(booksid);
		s.setThenxt("-");
		sections.setAddtime(VeDate.getStringDateShort());
		sections.setHits("0");
		sections.setThenxt("-");
		List<Sections> sList = this.sectionsService.getSectionsByCond(s);
		if (sList.size() == 0) {
			sections.setThepre("-");
		} else {
			Sections x = sList.get(0);
			x.setThenxt(sections.getSectionsid());
			this.sectionsService.updateSections(x);
			sections.setThepre(x.getSectionsid());
		}
		this.sectionsService.insertSections(sections);
		return "redirect:/index/preSections.action";
	}

	@RequestMapping("addFav.action")
	public String addFav(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Fav fav = new Fav();
		fav.setUsersid(userid);
		fav.setBooksid(id);
		fav.setAddtime(VeDate.getStringDateShort());
		this.favService.insertFav(fav);
		return "redirect:/index/myFav.action";
	}

	@RequestMapping("myFav.action")
	public String myFav(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Fav fav = new Fav();
		fav.setUsersid(userid);
		List<Fav> favList = this.favService.getFavByCond(fav);
		PageHelper.getIndexPage(favList, "fav", "myFav", 10, number, this.getRequest());
		return "users/myfav";
	}

	@RequestMapping("deleteFav.action")
	public String deleteFav(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.favService.deleteFav(id);
		return "redirect:/index/myFav.action";
	}

	@RequestMapping("myPays.action")
	public String myPays(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Pays pays = new Pays();
		pays.setUsersid(userid);
		List<Pays> paysList = this.paysService.getPaysByCond(pays);
		PageHelper.getIndexPage(paysList, "pays", "myPays", 10, number, this.getRequest());
		return "users/mypays";
	}

	@RequestMapping("preCharge.action")
	public String preCharge() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addcharge";
	}

	@RequestMapping("addCharge.action")
	public String addCharge() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Charge charge = new Charge();
		charge.setAddtime(VeDate.getStringDateShort());
		charge.setMoney(this.getRequest().getParameter("money"));
		charge.setUsersid(userid);
		this.chargeService.insertCharge(charge);
		Users users = this.usersService.getUsersById(userid);
		users.setMoney("" + VeDate.getDouble((Double.parseDouble(users.getMoney()) + Double.parseDouble(charge.getMoney()))));
		this.usersService.updateUsers(users);
		this.getSession().setAttribute("users", users);
		return "redirect:/index/myCharge.action";
	}

	@RequestMapping("myCharge.action")
	public String myCharge(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Charge charge = new Charge();
		charge.setUsersid(userid);
		List<Charge> chargeList = this.chargeService.getChargeByCond(charge);
		PageHelper.getIndexPage(chargeList, "charge", "myCharge", 10, number, this.getRequest());
		return "users/mycharge";
	}

	@RequestMapping("readsections.action")
	public String readsections(String id) {
		this.front();
		Sections sections = this.sectionsService.getSectionsById(id);
		if ("免费".equals(sections.getCate())) {
			this.getRequest().setAttribute("sections", sections);
		} else {
			if (this.getSession().getAttribute("userid") == null) {
				return "redirect:/index/preLogin.action";
			}
			String userid = (String) this.getSession().getAttribute("userid");
			Users users = this.usersService.getUsersById(userid);
			if (Double.parseDouble(users.getMoney()) >= 0.15) {
				users.setMoney("" + VeDate.getDouble((Double.parseDouble(users.getMoney()) - 0.15)));
				this.usersService.updateUsers(users);
				this.getSession().setAttribute("users", users);
				Pays pays = new Pays();
				pays.setAddtime(VeDate.getStringDateShort());
				pays.setBooksid(sections.getBooksid());
				pays.setMoney("0.15");
				pays.setSectionsid(id);
				pays.setUsersid(userid);
				this.paysService.insertPays(pays);
				Books books = this.booksService.getBooksById(pays.getBooksid());
				Users x = this.usersService.getUsersById(books.getUsersid());
				x.setMoney("" + VeDate.getDouble((Double.parseDouble(x.getMoney()) + 0.1)));
				this.usersService.updateUsers(x);
				this.getRequest().setAttribute("sections", sections);
			} else {
				return "redirect:/index/preCharge.action";
			}
		}
		return "users/readsections";
	}

}
