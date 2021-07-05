package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Scate;
import com.service.ScateService;
import com.entity.Bcate;
import com.service.BcateService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/scate", produces = "text/plain;charset=utf-8")
public class ScateAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private ScateService scateService;
	@Autowired
	@Resource
	private BcateService bcateService;

	// 准备添加数据
	@RequestMapping("createScate.action")
	public String createScate() {
		List<Bcate> bcateList = this.bcateService.getAllBcate();
		this.getRequest().setAttribute("bcateList", bcateList);
		return "admin/addscate";
	}

	// 添加数据
	@RequestMapping("addScate.action")
	public String addScate(Scate scate) {
		this.scateService.insertScate(scate);
		return "redirect:/scate/createScate.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteScate.action")
	public String deleteScate(String id) {
		this.scateService.deleteScate(id);
		return "redirect:/scate/getAllScate.action";
	}

	// 批量删除数据
	@RequestMapping("deleteScateByIds.action")
	public String deleteScateByIds() {
		String[] ids = this.getRequest().getParameterValues("scateid");
		for (String scateid : ids) {
			this.scateService.deleteScate(scateid);
		}
		return "redirect:/scate/getAllScate.action";
	}

	// 更新数据
	@RequestMapping("updateScate.action")
	public String updateScate(Scate scate) {
		this.scateService.updateScate(scate);
		return "redirect:/scate/getAllScate.action";
	}

	// 显示全部数据
	@RequestMapping("getAllScate.action")
	public String getAllScate(String number) {
		List<Scate> scateList = this.scateService.getAllScate();
		PageHelper.getPage(scateList, "scate", null, null, 10, number, this.getRequest(), null);
		return "admin/listscate";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryScateByCond.action")
	public String queryScateByCond(String cond, String name, String number) {
		Scate scate = new Scate();
		if (cond != null) {
			if ("scatename".equals(cond)) {
				scate.setScatename(name);
			}
			if ("bcateid".equals(cond)) {
				scate.setBcateid(name);
			}
			if ("memo".equals(cond)) {
				scate.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.scateService.getScateByLike(scate), "scate", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryscate";
	}

	// 按主键查询数据
	@RequestMapping("getScateById.action")
	public String getScateById(String id) {
		Scate scate = this.scateService.getScateById(id);
		this.getRequest().setAttribute("scate", scate);
		List<Bcate> bcateList = this.bcateService.getAllBcate();
		this.getRequest().setAttribute("bcateList", bcateList);
		return "admin/editscate";
	}

	public ScateService getScateService() {
		return scateService;
	}

	public void setScateService(ScateService scateService) {
		this.scateService = scateService;
	}

}
