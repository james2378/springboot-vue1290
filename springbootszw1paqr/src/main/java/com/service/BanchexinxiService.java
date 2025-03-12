package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BanchexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BanchexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BanchexinxiView;


/**
 * 班车信息
 *
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
public interface BanchexinxiService extends IService<BanchexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BanchexinxiVO> selectListVO(Wrapper<BanchexinxiEntity> wrapper);
   	
   	BanchexinxiVO selectVO(@Param("ew") Wrapper<BanchexinxiEntity> wrapper);
   	
   	List<BanchexinxiView> selectListView(Wrapper<BanchexinxiEntity> wrapper);
   	
   	BanchexinxiView selectView(@Param("ew") Wrapper<BanchexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BanchexinxiEntity> wrapper);

   	

}

