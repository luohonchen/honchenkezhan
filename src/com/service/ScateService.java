package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Scate;

@Service("scateService")
public interface ScateService {
	// 插入数据 调用scateDAO里的insertScate配置
	public int insertScate(Scate scate);

	// 更新数据 调用scateDAO里的updateScate配置
	public int updateScate(Scate scate);

	// 删除数据 调用scateDAO里的deleteScate配置
	public int deleteScate(String scateid);

	// 查询全部数据 调用scateDAO里的getAllScate配置
	public List<Scate> getAllScate();

	// 按照Scate类里面的字段名称精确查询 调用scateDAO里的getScateByCond配置
	public List<Scate> getScateByCond(Scate scate);

	// 按照Scate类里面的字段名称模糊查询 调用scateDAO里的getScateByLike配置
	public List<Scate> getScateByLike(Scate scate);

	// 按主键查询表返回单一的Scate实例 调用scateDAO里的getScateById配置
	public Scate getScateById(String scateid);

}
