package com.dao;

import com.entity.BancishijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BancishijianVO;
import com.entity.view.BancishijianView;


/**
 * 班次时间
 * 
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
public interface BancishijianDao extends BaseMapper<BancishijianEntity> {
	
	List<BancishijianVO> selectListVO(@Param("ew") Wrapper<BancishijianEntity> wrapper);
	
	BancishijianVO selectVO(@Param("ew") Wrapper<BancishijianEntity> wrapper);
	
	List<BancishijianView> selectListView(@Param("ew") Wrapper<BancishijianEntity> wrapper);

	List<BancishijianView> selectListView(Pagination page,@Param("ew") Wrapper<BancishijianEntity> wrapper);

	
	BancishijianView selectView(@Param("ew") Wrapper<BancishijianEntity> wrapper);
	

}
