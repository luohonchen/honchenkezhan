package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BcateDAO;
import com.entity.Bcate;
import com.service.BcateService;

@Service("bcateService")
public class BcateServiceImpl implements BcateService {
	@Autowired
	@Resource
	private BcateDAO bcateDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertBcate(Bcate bcate) {
		return this.bcateDAO.insertBcate(bcate);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateBcate(Bcate bcate) {
		return this.bcateDAO.updateBcate(bcate);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteBcate(String bcateid) {
		return this.bcateDAO.deleteBcate(bcateid);
	}

	@Override // 继承接口的查询全部
	public List<Bcate> getAllBcate() {
		return this.bcateDAO.getAllBcate();
	}

	@Override // 继承接口的查询全部
	public List<Bcate> getFrontBcate() {
		return this.bcateDAO.getFrontBcate();
	}

	@Override // 继承接口的按条件精确查询
	public List<Bcate> getBcateByCond(Bcate bcate) {
		return this.bcateDAO.getBcateByCond(bcate);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Bcate> getBcateByLike(Bcate bcate) {
		return this.bcateDAO.getBcateByLike(bcate);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Bcate getBcateById(String bcateid) {
		return this.bcateDAO.getBcateById(bcateid);
	}

}
