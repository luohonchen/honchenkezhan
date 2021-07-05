package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Bcate;

@Service("bcateService")
public interface BcateService {
	// 插入数据 调用bcateDAO里的insertBcate配置
	public int insertBcate(Bcate bcate);

	// 更新数据 调用bcateDAO里的updateBcate配置
	public int updateBcate(Bcate bcate);

	// 删除数据 调用bcateDAO里的deleteBcate配置
	public int deleteBcate(String bcateid);

	// 查询全部数据 调用bcateDAO里的getAllBcate配置
	public List<Bcate> getAllBcate();

	public List<Bcate> getFrontBcate();

	// 按照Bcate类里面的字段名称精确查询 调用bcateDAO里的getBcateByCond配置
	public List<Bcate> getBcateByCond(Bcate bcate);

	// 按照Bcate类里面的字段名称模糊查询 调用bcateDAO里的getBcateByLike配置
	public List<Bcate> getBcateByLike(Bcate bcate);

	// 按主键查询表返回单一的Bcate实例 调用bcateDAO里的getBcateById配置
	public Bcate getBcateById(String bcateid);

}
