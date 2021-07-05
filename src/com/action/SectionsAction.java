package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Sections;
import com.service.SectionsService;
import com.entity.Books;
import com.service.BooksService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/sections", produces = "text/plain;charset=utf-8")
public class SectionsAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private SectionsService sectionsService;
	@Autowired
	@Resource
	private BooksService booksService;

	// 准备添加数据
	@RequestMapping("createSections.action")
	public String createSections() {
		List<Books> booksList = this.booksService.getAllBooks();
		this.getRequest().setAttribute("booksList", booksList);
		return "admin/addsections";
	}

	// 添加数据
	@RequestMapping("addSections.action")
	public String addSections(Sections sections) {
		this.sectionsService.insertSections(sections);
		return "redirect:/sections/createSections.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSections.action")
	public String deleteSections(String id) {
		this.sectionsService.deleteSections(id);
		return "redirect:/sections/getAllSections.action";
	}

	// 批量删除数据
	@RequestMapping("deleteSectionsByIds.action")
	public String deleteSectionsByIds() {
		String[] ids = this.getRequest().getParameterValues("sectionsid");
		for (String sectionsid : ids) {
			this.sectionsService.deleteSections(sectionsid);
		}
		return "redirect:/sections/getAllSections.action";
	}

	// 更新数据
	@RequestMapping("updateSections.action")
	public String updateSections(Sections sections) {
		this.sectionsService.updateSections(sections);
		return "redirect:/sections/getAllSections.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSections.action")
	public String getAllSections(String number) {
		List<Sections> sectionsList = this.sectionsService.getAllSections();
		PageHelper.getPage(sectionsList, "sections", null, null, 10, number, this.getRequest(), null);
		return "admin/listsections";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("querySectionsByCond.action")
	public String querySectionsByCond(String cond, String name, String number) {
		Sections sections = new Sections();
		if (cond != null) {
			if ("booksid".equals(cond)) {
				sections.setBooksid(name);
			}
			if ("title".equals(cond)) {
				sections.setTitle(name);
			}
			if ("contents".equals(cond)) {
				sections.setContents(name);
			}
			if ("addtime".equals(cond)) {
				sections.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				sections.setHits(name);
			}
			if ("cate".equals(cond)) {
				sections.setCate(name);
			}
			if ("thepre".equals(cond)) {
				sections.setThepre(name);
			}
			if ("thenxt".equals(cond)) {
				sections.setThenxt(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.sectionsService.getSectionsByLike(sections), "sections", nameList, valueList, 10, number, this.getRequest(),
				"query");
		name = null;
		cond = null;
		return "admin/querysections";
	}

	// 按主键查询数据
	@RequestMapping("getSectionsById.action")
	public String getSectionsById(String id) {
		Sections sections = this.sectionsService.getSectionsById(id);
		this.getRequest().setAttribute("sections", sections);
		List<Books> booksList = this.booksService.getAllBooks();
		this.getRequest().setAttribute("booksList", booksList);
		return "admin/editsections";
	}

	public SectionsService getSectionsService() {
		return sectionsService;
	}

	public void setSectionsService(SectionsService sectionsService) {
		this.sectionsService = sectionsService;
	}

}
