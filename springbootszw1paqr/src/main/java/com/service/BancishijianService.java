package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BancishijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BancishijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BancishijianView;


/**
 * 班次时间
 *
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
public interface BancishijianService extends IService<BancishijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BancishijianVO> selectListVO(Wrapper<BancishijianEntity> wrapper);
   	
   	BancishijianVO selectVO(@Param("ew") Wrapper<BancishijianEntity> wrapper);
   	
   	List<BancishijianView> selectListView(Wrapper<BancishijianEntity> wrapper);
   	
   	BancishijianView selectView(@Param("ew") Wrapper<BancishijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BancishijianEntity> wrapper);

   	

}

