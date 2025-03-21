package com.entity.view;

import com.entity.BancishijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 班次时间
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-08 20:23:45
 */
@TableName("bancishijian")
public class BancishijianView  extends BancishijianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BancishijianView(){
	}
 
 	public BancishijianView(BancishijianEntity bancishijianEntity){
 	try {
			BeanUtils.copyProperties(this, bancishijianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
