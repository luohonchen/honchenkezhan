package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Charge;
import com.service.ChargeService;
import com.entity.Users;
import com.service.UsersService;
import com.util.PageHelper;


@Controller

@RequestMapping(value = "/charge", produces = "text/plain;charset=utf-8")
public class ChargeAction extends BaseAction {
	
	@Autowired
	@Resource
	private ChargeService chargeService;
	@Autowired
	@Resource
	private UsersService usersService;

	
	@RequestMapping("createCharge.action")
	public String createCharge() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addcharge";
	}

	
	@RequestMapping("addCharge.action")
	public String addCharge(Charge charge) {
		this.chargeService.insertCharge(charge);
		return "redirect:/charge/createCharge.action";
	}

	
	@RequestMapping("deleteCharge.action")
	public String deleteCharge(String id) {
		this.chargeService.deleteCharge(id);
		return "redirect:/charge/getAllCharge.action";
	}

	
	@RequestMapping("deleteChargeByIds.action")
	public String deleteChargeByIds() {
		String[] ids = this.getRequest().getParameterValues("chargeid");
		for (String chargeid : ids) {
			this.chargeService.deleteCharge(chargeid);
		}
		return "redirect:/charge/getAllCharge.action";
	}

	
	@RequestMapping("updateCharge.action")
	public String updateCharge(Charge charge) {
		this.chargeService.updateCharge(charge);
		return "redirect:/charge/getAllCharge.action";
	}

	
	@RequestMapping("getAllCharge.action")
	public String getAllCharge(String number) {
		List<Charge> chargeList = this.chargeService.getAllCharge();
		PageHelper.getPage(chargeList, "charge", null, null, 10, number, this.getRequest(), null);
		return "admin/listcharge";
	}

	
	@RequestMapping("queryChargeByCond.action")
	public String queryChargeByCond(String cond, String name, String number) {
		Charge charge = new Charge();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				charge.setUsersid(name);
			}
			if ("money".equals(cond)) {
				charge.setMoney(name);
			}
			if ("addtime".equals(cond)) {
				charge.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.chargeService.getChargeByLike(charge), "charge", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycharge";
	}

	
	@RequestMapping("getChargeById.action")
	public String getChargeById(String id) {
		Charge charge = this.chargeService.getChargeById(id);
		this.getRequest().setAttribute("charge", charge);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editcharge";
	}

	public ChargeService getChargeService() {
		return chargeService;
	}

	public void setChargeService(ChargeService chargeService) {
		this.chargeService = chargeService;
	}

}
