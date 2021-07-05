package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Scate;
import com.service.ScateService;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/ajax", produces = "text/plain;charset=utf-8")
public class AjaxAction extends BaseAction {
	@Autowired
	@Resource
	private ScateService scateService;

	@RequestMapping("getScate.action")
	@ResponseBody
	public String getScate() throws JSONException {
		String id = this.getRequest().getParameter("id");
		Scate scate = new Scate();
		scate.setBcateid(id);
		JSONArray scateid = new JSONArray();
		JSONArray scatename = new JSONArray();// 定义count存放数值
		List<Scate> scateList = this.scateService.getScateByCond(scate);
		for (Scate x : scateList) {
			scateid.put(x.getScateid());
			scatename.put(x.getScatename());
		}
		JSONObject json = new JSONObject();
		json.put("scateid", scateid.toString().replaceAll("\"", ""));
		json.put("scatename", scatename.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}
}
