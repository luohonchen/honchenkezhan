package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Bcate;

@Repository("bcateDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface BcateDAO {

	/**
	 * BcateDAO 接口 可以按名称直接调用bcate.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包bcate.xml里的insertBcate配置 返回值0(失败),1(成功)
	public int insertBcate(Bcate bcate);

	// 更新数据 调用entity包bcate.xml里的updateBcate配置 返回值0(失败),1(成功)
	public int updateBcate(Bcate bcate);

	// 删除数据 调用entity包bcate.xml里的deleteBcate配置 返回值0(失败),1(成功)
	public int deleteBcate(String bcateid);

	// 查询全部数据 调用entity包bcate.xml里的getAllBcate配置 返回List类型的数据
	public List<Bcate> getAllBcate();

	public List<Bcate> getFrontBcate();

	// 按照Bcate类里面的值精确查询 调用entity包bcate.xml里的getBcateByCond配置 返回List类型的数据
	public List<Bcate> getBcateByCond(Bcate bcate);

	// 按照Bcate类里面的值模糊查询 调用entity包bcate.xml里的getBcateByLike配置 返回List类型的数据
	public List<Bcate> getBcateByLike(Bcate bcate);

	// 按主键查询表返回单一的Bcate实例 调用entity包bcate.xml里的getBcateById配置
	public Bcate getBcateById(String bcateid);

}
