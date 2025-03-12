package com.dao;

import com.entity.BanchexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BanchexinxiVO;
import com.entity.view.BanchexinxiView;


/**
 * 班车信息
 * 
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
public interface BanchexinxiDao extends BaseMapper<BanchexinxiEntity> {
	
	List<BanchexinxiVO> selectListVO(@Param("ew") Wrapper<BanchexinxiEntity> wrapper);
	
	BanchexinxiVO selectVO(@Param("ew") Wrapper<BanchexinxiEntity> wrapper);
	
	List<BanchexinxiView> selectListView(@Param("ew") Wrapper<BanchexinxiEntity> wrapper);

	List<BanchexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BanchexinxiEntity> wrapper);

	
	BanchexinxiView selectView(@Param("ew") Wrapper<BanchexinxiEntity> wrapper);
	

}
