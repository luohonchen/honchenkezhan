package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SectionsDAO;
import com.entity.Sections;
import com.service.SectionsService;

@Service("sectionsService")
public class SectionsServiceImpl implements SectionsService {
	@Autowired
	@Resource
	private SectionsDAO sectionsDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSections(Sections sections) {
		return this.sectionsDAO.insertSections(sections);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSections(Sections sections) {
		return this.sectionsDAO.updateSections(sections);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSections(String sectionsid) {
		return this.sectionsDAO.deleteSections(sectionsid);
	}

	@Override // 继承接口的查询全部
	public List<Sections> getAllSections() {
		return this.sectionsDAO.getAllSections();
	}

	@Override // 继承接口的按条件精确查询
	public List<Sections> getSectionsByCond(Sections sections) {
		return this.sectionsDAO.getSectionsByCond(sections);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Sections> getSectionsByLike(Sections sections) {
		return this.sectionsDAO.getSectionsByLike(sections);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Sections getSectionsById(String sectionsid) {
		return this.sectionsDAO.getSectionsById(sectionsid);
	}

}
