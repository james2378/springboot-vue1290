package com.dao;

import com.entity.DiscussbanchexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbanchexinxiVO;
import com.entity.view.DiscussbanchexinxiView;


/**
 * 班车信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
public interface DiscussbanchexinxiDao extends BaseMapper<DiscussbanchexinxiEntity> {
	
	List<DiscussbanchexinxiVO> selectListVO(@Param("ew") Wrapper<DiscussbanchexinxiEntity> wrapper);
	
	DiscussbanchexinxiVO selectVO(@Param("ew") Wrapper<DiscussbanchexinxiEntity> wrapper);
	
	List<DiscussbanchexinxiView> selectListView(@Param("ew") Wrapper<DiscussbanchexinxiEntity> wrapper);

	List<DiscussbanchexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbanchexinxiEntity> wrapper);

	
	DiscussbanchexinxiView selectView(@Param("ew") Wrapper<DiscussbanchexinxiEntity> wrapper);
	

}
