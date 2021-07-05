package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ScateDAO;
import com.entity.Scate;
import com.service.ScateService;

@Service("scateService")
public class ScateServiceImpl implements ScateService {
	@Autowired
	@Resource
	private ScateDAO scateDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertScate(Scate scate) {
		return this.scateDAO.insertScate(scate);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateScate(Scate scate) {
		return this.scateDAO.updateScate(scate);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteScate(String scateid) {
		return this.scateDAO.deleteScate(scateid);
	}

	@Override // 继承接口的查询全部
	public List<Scate> getAllScate() {
		return this.scateDAO.getAllScate();
	}

	@Override // 继承接口的按条件精确查询
	public List<Scate> getScateByCond(Scate scate) {
		return this.scateDAO.getScateByCond(scate);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Scate> getScateByLike(Scate scate) {
		return this.scateDAO.getScateByLike(scate);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Scate getScateById(String scateid) {
		return this.scateDAO.getScateById(scateid);
	}

}
