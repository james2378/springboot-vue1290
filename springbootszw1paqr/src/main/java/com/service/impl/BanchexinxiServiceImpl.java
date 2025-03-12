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


import com.dao.BanchexinxiDao;
import com.entity.BanchexinxiEntity;
import com.service.BanchexinxiService;
import com.entity.vo.BanchexinxiVO;
import com.entity.view.BanchexinxiView;

@Service("banchexinxiService")
public class BanchexinxiServiceImpl extends ServiceImpl<BanchexinxiDao, BanchexinxiEntity> implements BanchexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BanchexinxiEntity> page = this.selectPage(
                new Query<BanchexinxiEntity>(params).getPage(),
                new EntityWrapper<BanchexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BanchexinxiEntity> wrapper) {
		  Page<BanchexinxiView> page =new Query<BanchexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<BanchexinxiVO> selectListVO(Wrapper<BanchexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BanchexinxiVO selectVO(Wrapper<BanchexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BanchexinxiView> selectListView(Wrapper<BanchexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BanchexinxiView selectView(Wrapper<BanchexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
