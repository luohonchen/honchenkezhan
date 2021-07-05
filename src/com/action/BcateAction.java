package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Bcate;
import com.service.BcateService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/bcate", produces = "text/plain;charset=utf-8")
public class BcateAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private BcateService bcateService;

	// 准备添加数据
	@RequestMapping("createBcate.action")
	public String createBcate() {
		return "admin/addbcate";
	}

	// 添加数据
	@RequestMapping("addBcate.action")
	public String addBcate(Bcate bcate) {
		this.bcateService.insertBcate(bcate);
		return "redirect:/bcate/createBcate.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBcate.action")
	public String deleteBcate(String id) {
		this.bcateService.deleteBcate(id);
		return "redirect:/bcate/getAllBcate.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBcateByIds.action")
	public String deleteBcateByIds() {
		String[] ids = this.getRequest().getParameterValues("bcateid");
		for (String bcateid : ids) {
			this.bcateService.deleteBcate(bcateid);
		}
		return "redirect:/bcate/getAllBcate.action";
	}

	// 更新数据
	@RequestMapping("updateBcate.action")
	public String updateBcate(Bcate bcate) {
		this.bcateService.updateBcate(bcate);
		return "redirect:/bcate/getAllBcate.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBcate.action")
	public String getAllBcate(String number) {
		List<Bcate> bcateList = this.bcateService.getAllBcate();
		PageHelper.getPage(bcateList, "bcate", null, null, 10, number, this.getRequest(), null);
		return "admin/listbcate";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBcateByCond.action")
	public String queryBcateByCond(String cond, String name, String number) {
		Bcate bcate = new Bcate();
		if (cond != null) {
			if ("bcatename".equals(cond)) {
				bcate.setBcatename(name);
			}
			if ("memo".equals(cond)) {
				bcate.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.bcateService.getBcateByLike(bcate), "bcate", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querybcate";
	}

	// 按主键查询数据
	@RequestMapping("getBcateById.action")
	public String getBcateById(String id) {
		Bcate bcate = this.bcateService.getBcateById(id);
		this.getRequest().setAttribute("bcate", bcate);
		return "admin/editbcate";
	}

	public BcateService getBcateService() {
		return bcateService;
	}

	public void setBcateService(BcateService bcateService) {
		this.bcateService = bcateService;
	}

}
