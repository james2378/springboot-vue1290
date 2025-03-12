package com.entity.vo;

import com.entity.BanchexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 班车信息
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
public class BanchexinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 车牌号码
	 */
	
	private String chepaihaoma;
		
	/**
	 * 班次时间
	 */
	
	private String bancishijian;
		
	/**
	 * 车辆照片
	 */
	
	private String cheliangzhaopian;
		
	/**
	 * 始发班次
	 */
	
	private String shifabanci;
		
	/**
	 * 末发班次
	 */
	
	private String mofabanci;
		
	/**
	 * 始发站点
	 */
	
	private String shifazhandian;
		
	/**
	 * 终点站点
	 */
	
	private String zhongdianzhandian;
		
	/**
	 * 司机姓名
	 */
	
	private String sijixingming;
		
	/**
	 * 交通路线
	 */
	
	private String jiaotongluxian;
		
	/**
	 * 购票规则
	 */
	
	private String goupiaoguize;
		
	/**
	 * 班次状态
	 */
	
	private String bancizhuangtai;
		
	/**
	 * 倒计结束时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date reversetime;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 价格
	 */
	
	private Double price;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
		
	/**
	 * 座位总数
	 */
	
	private Integer number;
		
	/**
	 * 已选座位[用,号隔开]
	 */
	
	private String selected;
				
	
	/**
	 * 设置：车牌号码
	 */
	 
	public void setChepaihaoma(String chepaihaoma) {
		this.chepaihaoma = chepaihaoma;
	}
	
	/**
	 * 获取：车牌号码
	 */
	public String getChepaihaoma() {
		return chepaihaoma;
	}
				
	
	/**
	 * 设置：班次时间
	 */
	 
	public void setBancishijian(String bancishijian) {
		this.bancishijian = bancishijian;
	}
	
	/**
	 * 获取：班次时间
	 */
	public String getBancishijian() {
		return bancishijian;
	}
				
	
	/**
	 * 设置：车辆照片
	 */
	 
	public void setCheliangzhaopian(String cheliangzhaopian) {
		this.cheliangzhaopian = cheliangzhaopian;
	}
	
	/**
	 * 获取：车辆照片
	 */
	public String getCheliangzhaopian() {
		return cheliangzhaopian;
	}
				
	
	/**
	 * 设置：始发班次
	 */
	 
	public void setShifabanci(String shifabanci) {
		this.shifabanci = shifabanci;
	}
	
	/**
	 * 获取：始发班次
	 */
	public String getShifabanci() {
		return shifabanci;
	}
				
	
	/**
	 * 设置：末发班次
	 */
	 
	public void setMofabanci(String mofabanci) {
		this.mofabanci = mofabanci;
	}
	
	/**
	 * 获取：末发班次
	 */
	public String getMofabanci() {
		return mofabanci;
	}
				
	
	/**
	 * 设置：始发站点
	 */
	 
	public void setShifazhandian(String shifazhandian) {
		this.shifazhandian = shifazhandian;
	}
	
	/**
	 * 获取：始发站点
	 */
	public String getShifazhandian() {
		return shifazhandian;
	}
				
	
	/**
	 * 设置：终点站点
	 */
	 
	public void setZhongdianzhandian(String zhongdianzhandian) {
		this.zhongdianzhandian = zhongdianzhandian;
	}
	
	/**
	 * 获取：终点站点
	 */
	public String getZhongdianzhandian() {
		return zhongdianzhandian;
	}
				
	
	/**
	 * 设置：司机姓名
	 */
	 
	public void setSijixingming(String sijixingming) {
		this.sijixingming = sijixingming;
	}
	
	/**
	 * 获取：司机姓名
	 */
	public String getSijixingming() {
		return sijixingming;
	}
				
	
	/**
	 * 设置：交通路线
	 */
	 
	public void setJiaotongluxian(String jiaotongluxian) {
		this.jiaotongluxian = jiaotongluxian;
	}
	
	/**
	 * 获取：交通路线
	 */
	public String getJiaotongluxian() {
		return jiaotongluxian;
	}
				
	
	/**
	 * 设置：购票规则
	 */
	 
	public void setGoupiaoguize(String goupiaoguize) {
		this.goupiaoguize = goupiaoguize;
	}
	
	/**
	 * 获取：购票规则
	 */
	public String getGoupiaoguize() {
		return goupiaoguize;
	}
				
	
	/**
	 * 设置：班次状态
	 */
	 
	public void setBancizhuangtai(String bancizhuangtai) {
		this.bancizhuangtai = bancizhuangtai;
	}
	
	/**
	 * 获取：班次状态
	 */
	public String getBancizhuangtai() {
		return bancizhuangtai;
	}
				
	
	/**
	 * 设置：倒计结束时间
	 */
	 
	public void setReversetime(Date reversetime) {
		this.reversetime = reversetime;
	}
	
	/**
	 * 获取：倒计结束时间
	 */
	public Date getReversetime() {
		return reversetime;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
				
	
	/**
	 * 设置：座位总数
	 */
	 
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	/**
	 * 获取：座位总数
	 */
	public Integer getNumber() {
		return number;
	}
				
	
	/**
	 * 设置：已选座位[用,号隔开]
	 */
	 
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	/**
	 * 获取：已选座位[用,号隔开]
	 */
	public String getSelected() {
		return selected;
	}
			
}
