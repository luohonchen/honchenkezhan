package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Sections;

@Repository("sectionsDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface SectionsDAO {

	/**
	 * SectionsDAO 接口 可以按名称直接调用sections.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包sections.xml里的insertSections配置 返回值0(失败),1(成功)
	public int insertSections(Sections sections);

	// 更新数据 调用entity包sections.xml里的updateSections配置 返回值0(失败),1(成功)
	public int updateSections(Sections sections);

	// 删除数据 调用entity包sections.xml里的deleteSections配置 返回值0(失败),1(成功)
	public int deleteSections(String sectionsid);

	// 查询全部数据 调用entity包sections.xml里的getAllSections配置 返回List类型的数据
	public List<Sections> getAllSections();

	// 按照Sections类里面的值精确查询 调用entity包sections.xml里的getSectionsByCond配置
	// 返回List类型的数据
	public List<Sections> getSectionsByCond(Sections sections);

	// 按照Sections类里面的值模糊查询 调用entity包sections.xml里的getSectionsByLike配置
	// 返回List类型的数据
	public List<Sections> getSectionsByLike(Sections sections);

	// 按主键查询表返回单一的Sections实例 调用entity包sections.xml里的getSectionsById配置
	public Sections getSectionsById(String sectionsid);

}
