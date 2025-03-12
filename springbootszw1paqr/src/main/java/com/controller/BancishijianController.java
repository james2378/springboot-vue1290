package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.BancishijianEntity;
import com.entity.view.BancishijianView;

import com.service.BancishijianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 班次时间
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
@RestController
@RequestMapping("/bancishijian")
public class BancishijianController {
    @Autowired
    private BancishijianService bancishijianService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BancishijianEntity bancishijian,
		HttpServletRequest request){
        EntityWrapper<BancishijianEntity> ew = new EntityWrapper<BancishijianEntity>();

		PageUtils page = bancishijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bancishijian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BancishijianEntity bancishijian, 
		HttpServletRequest request){
        EntityWrapper<BancishijianEntity> ew = new EntityWrapper<BancishijianEntity>();

		PageUtils page = bancishijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bancishijian), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BancishijianEntity bancishijian){
       	EntityWrapper<BancishijianEntity> ew = new EntityWrapper<BancishijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bancishijian, "bancishijian")); 
        return R.ok().put("data", bancishijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BancishijianEntity bancishijian){
        EntityWrapper< BancishijianEntity> ew = new EntityWrapper< BancishijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bancishijian, "bancishijian")); 
		BancishijianView bancishijianView =  bancishijianService.selectView(ew);
		return R.ok("查询班次时间成功").put("data", bancishijianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BancishijianEntity bancishijian = bancishijianService.selectById(id);
        return R.ok().put("data", bancishijian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BancishijianEntity bancishijian = bancishijianService.selectById(id);
        return R.ok().put("data", bancishijian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BancishijianEntity bancishijian, HttpServletRequest request){
        if(bancishijianService.selectCount(new EntityWrapper<BancishijianEntity>().eq("bancishijian", bancishijian.getBancishijian()))>0) {
            return R.error("班次时间已存在");
        }
    	//ValidatorUtils.validateEntity(bancishijian);
        bancishijianService.insert(bancishijian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BancishijianEntity bancishijian, HttpServletRequest request){
        if(bancishijianService.selectCount(new EntityWrapper<BancishijianEntity>().eq("bancishijian", bancishijian.getBancishijian()))>0) {
            return R.error("班次时间已存在");
        }
    	//ValidatorUtils.validateEntity(bancishijian);
        bancishijianService.insert(bancishijian);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BancishijianEntity bancishijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bancishijian);
        if(bancishijianService.selectCount(new EntityWrapper<BancishijianEntity>().ne("id", bancishijian.getId()).eq("bancishijian", bancishijian.getBancishijian()))>0) {
            return R.error("班次时间已存在");
        }
        bancishijianService.updateById(bancishijian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bancishijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
