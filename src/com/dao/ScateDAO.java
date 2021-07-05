package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Scate;

@Repository("scateDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ScateDAO {

	/**
	 * ScateDAO 接口 可以按名称直接调用scate.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包scate.xml里的insertScate配置 返回值0(失败),1(成功)
	public int insertScate(Scate scate);

	// 更新数据 调用entity包scate.xml里的updateScate配置 返回值0(失败),1(成功)
	public int updateScate(Scate scate);

	// 删除数据 调用entity包scate.xml里的deleteScate配置 返回值0(失败),1(成功)
	public int deleteScate(String scateid);

	// 查询全部数据 调用entity包scate.xml里的getAllScate配置 返回List类型的数据
	public List<Scate> getAllScate();

	// 按照Scate类里面的值精确查询 调用entity包scate.xml里的getScateByCond配置 返回List类型的数据
	public List<Scate> getScateByCond(Scate scate);

	// 按照Scate类里面的值模糊查询 调用entity包scate.xml里的getScateByLike配置 返回List类型的数据
	public List<Scate> getScateByLike(Scate scate);

	// 按主键查询表返回单一的Scate实例 调用entity包scate.xml里的getScateById配置
	public Scate getScateById(String scateid);

}
