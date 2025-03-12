package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussbanchexinxiDao;
import com.entity.DiscussbanchexinxiEntity;
import com.service.DiscussbanchexinxiService;
import com.entity.vo.DiscussbanchexinxiVO;
import com.entity.view.DiscussbanchexinxiView;

@Service("discussbanchexinxiService")
public class DiscussbanchexinxiServiceImpl extends ServiceImpl<DiscussbanchexinxiDao, DiscussbanchexinxiEntity> implements DiscussbanchexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbanchexinxiEntity> page = this.selectPage(
                new Query<DiscussbanchexinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussbanchexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbanchexinxiEntity> wrapper) {
		  Page<DiscussbanchexinxiView> page =new Query<DiscussbanchexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussbanchexinxiVO> selectListVO(Wrapper<DiscussbanchexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussbanchexinxiVO selectVO(Wrapper<DiscussbanchexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussbanchexinxiView> selectListView(Wrapper<DiscussbanchexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbanchexinxiView selectView(Wrapper<DiscussbanchexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
