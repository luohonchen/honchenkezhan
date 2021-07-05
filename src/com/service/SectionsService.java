package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Sections;

@Service("sectionsService")
public interface SectionsService {
	// 插入数据 调用sectionsDAO里的insertSections配置
	public int insertSections(Sections sections);

	// 更新数据 调用sectionsDAO里的updateSections配置
	public int updateSections(Sections sections);

	// 删除数据 调用sectionsDAO里的deleteSections配置
	public int deleteSections(String sectionsid);

	// 查询全部数据 调用sectionsDAO里的getAllSections配置
	public List<Sections> getAllSections();

	// 按照Sections类里面的字段名称精确查询 调用sectionsDAO里的getSectionsByCond配置
	public List<Sections> getSectionsByCond(Sections sections);

	// 按照Sections类里面的字段名称模糊查询 调用sectionsDAO里的getSectionsByLike配置
	public List<Sections> getSectionsByLike(Sections sections);

	// 按主键查询表返回单一的Sections实例 调用sectionsDAO里的getSectionsById配置
	public Sections getSectionsById(String sectionsid);

}
