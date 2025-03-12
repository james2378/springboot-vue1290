package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbanchexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbanchexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbanchexinxiView;


/**
 * 班车信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
public interface DiscussbanchexinxiService extends IService<DiscussbanchexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbanchexinxiVO> selectListVO(Wrapper<DiscussbanchexinxiEntity> wrapper);
   	
   	DiscussbanchexinxiVO selectVO(@Param("ew") Wrapper<DiscussbanchexinxiEntity> wrapper);
   	
   	List<DiscussbanchexinxiView> selectListView(Wrapper<DiscussbanchexinxiEntity> wrapper);
   	
   	DiscussbanchexinxiView selectView(@Param("ew") Wrapper<DiscussbanchexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbanchexinxiEntity> wrapper);

   	

}

