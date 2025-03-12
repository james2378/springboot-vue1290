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


import com.dao.BancishijianDao;
import com.entity.BancishijianEntity;
import com.service.BancishijianService;
import com.entity.vo.BancishijianVO;
import com.entity.view.BancishijianView;

@Service("bancishijianService")
public class BancishijianServiceImpl extends ServiceImpl<BancishijianDao, BancishijianEntity> implements BancishijianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BancishijianEntity> page = this.selectPage(
                new Query<BancishijianEntity>(params).getPage(),
                new EntityWrapper<BancishijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BancishijianEntity> wrapper) {
		  Page<BancishijianView> page =new Query<BancishijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<BancishijianVO> selectListVO(Wrapper<BancishijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BancishijianVO selectVO(Wrapper<BancishijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BancishijianView> selectListView(Wrapper<BancishijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BancishijianView selectView(Wrapper<BancishijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
