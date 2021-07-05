package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Books;
import com.service.BooksService;
import com.entity.Users;
import com.entity.Bcate;
import com.entity.Scate;
import com.service.UsersService;
import com.service.BcateService;
import com.service.ScateService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/books", produces = "text/plain;charset=utf-8")
public class BooksAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private BooksService booksService;
	@Autowired
	@Resource
	private UsersService usersService;
	@Autowired
	@Resource
	private BcateService bcateService;
	@Autowired
	@Resource
	private ScateService scateService;

	// 准备添加数据
	@RequestMapping("createBooks.action")
	public String createBooks() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Bcate> bcateList = this.bcateService.getAllBcate();
		this.getRequest().setAttribute("bcateList", bcateList);
		List<Scate> scateList = this.scateService.getAllScate();
		this.getRequest().setAttribute("scateList", scateList);
		return "admin/addbooks";
	}

	// 添加数据
	@RequestMapping("addBooks.action")
	public String addBooks(Books books) {
		books.setAddtime(VeDate.getStringDateShort());
		books.setStatus("");
		books.setHits("0");
		this.booksService.insertBooks(books);
		return "redirect:/books/createBooks.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBooks.action")
	public String deleteBooks(String id) {
		this.booksService.deleteBooks(id);
		return "redirect:/books/getAllBooks.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBooksByIds.action")
	public String deleteBooksByIds() {
		String[] ids = this.getRequest().getParameterValues("booksid");
		for (String booksid : ids) {
			this.booksService.deleteBooks(booksid);
		}
		return "redirect:/books/getAllBooks.action";
	}

	// 更新数据
	@RequestMapping("updateBooks.action")
	public String updateBooks(Books books) {
		this.booksService.updateBooks(books);
		return "redirect:/books/getAllBooks.action";
	}

	@RequestMapping("status.action")
	public String status(String id) {
		Books books = this.booksService.getBooksById(id);
		books.setStatus("连载中");
		this.booksService.updateBooks(books);
		return "redirect:/books/getAllBooks.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBooks.action")
	public String getAllBooks(String number) {
		List<Books> booksList = this.booksService.getAllBooks();
		PageHelper.getPage(booksList, "books", null, null, 10, number, this.getRequest(), null);
		return "admin/listbooks";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBooksByCond.action")
	public String queryBooksByCond(String cond, String name, String number) {
		Books books = new Books();
		if (cond != null) {
			if ("usesid".equals(cond)) {
				books.setUsersid(name);
			}
			if ("booksname".equals(cond)) {
				books.setBooksname(name);
			}
			if ("image".equals(cond)) {
				books.setImage(name);
			}
			if ("bcateid".equals(cond)) {
				books.setBcateid(name);
			}
			if ("scateid".equals(cond)) {
				books.setScateid(name);
			}
			if ("addtime".equals(cond)) {
				books.setAddtime(name);
			}
			if ("status".equals(cond)) {
				books.setStatus(name);
			}
			if ("hits".equals(cond)) {
				books.setHits(name);
			}
			if ("contents".equals(cond)) {
				books.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.booksService.getBooksByLike(books), "books", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querybooks";
	}

	// 按主键查询数据
	@RequestMapping("getBooksById.action")
	public String getBooksById(String id) {
		Books books = this.booksService.getBooksById(id);
		this.getRequest().setAttribute("books", books);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Bcate> bcateList = this.bcateService.getAllBcate();
		this.getRequest().setAttribute("bcateList", bcateList);
		List<Scate> scateList = this.scateService.getAllScate();
		this.getRequest().setAttribute("scateList", scateList);
		return "admin/editbooks";
	}

	public BooksService getBooksService() {
		return booksService;
	}

	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

}
