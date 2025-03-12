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

import com.entity.BanchexinxiEntity;
import com.entity.view.BanchexinxiView;

import com.service.BanchexinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 班车信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
@RestController
@RequestMapping("/banchexinxi")
public class BanchexinxiController {
    @Autowired
    private BanchexinxiService banchexinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BanchexinxiEntity banchexinxi,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<BanchexinxiEntity> ew = new EntityWrapper<BanchexinxiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = banchexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banchexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BanchexinxiEntity banchexinxi, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<BanchexinxiEntity> ew = new EntityWrapper<BanchexinxiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = banchexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banchexinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BanchexinxiEntity banchexinxi){
       	EntityWrapper<BanchexinxiEntity> ew = new EntityWrapper<BanchexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( banchexinxi, "banchexinxi")); 
        return R.ok().put("data", banchexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BanchexinxiEntity banchexinxi){
        EntityWrapper< BanchexinxiEntity> ew = new EntityWrapper< BanchexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( banchexinxi, "banchexinxi")); 
		BanchexinxiView banchexinxiView =  banchexinxiService.selectView(ew);
		return R.ok("查询班车信息成功").put("data", banchexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BanchexinxiEntity banchexinxi = banchexinxiService.selectById(id);
        return R.ok().put("data", banchexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BanchexinxiEntity banchexinxi = banchexinxiService.selectById(id);
        return R.ok().put("data", banchexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BanchexinxiEntity banchexinxi, HttpServletRequest request){
        if(banchexinxiService.selectCount(new EntityWrapper<BanchexinxiEntity>().eq("banchechehao", banchexinxi.getBanchechehao()))>0) {
            return R.error("班车车号已存在");
        }
    	//ValidatorUtils.validateEntity(banchexinxi);
        banchexinxiService.insert(banchexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BanchexinxiEntity banchexinxi, HttpServletRequest request){
        if(banchexinxiService.selectCount(new EntityWrapper<BanchexinxiEntity>().eq("banchechehao", banchexinxi.getBanchechehao()))>0) {
            return R.error("班车车号已存在");
        }
    	//ValidatorUtils.validateEntity(banchexinxi);
        banchexinxiService.insert(banchexinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BanchexinxiEntity banchexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(banchexinxi);
        if(banchexinxiService.selectCount(new EntityWrapper<BanchexinxiEntity>().ne("id", banchexinxi.getId()).eq("banchechehao", banchexinxi.getBanchechehao()))>0) {
            return R.error("班车车号已存在");
        }
        banchexinxiService.updateById(banchexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        banchexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
