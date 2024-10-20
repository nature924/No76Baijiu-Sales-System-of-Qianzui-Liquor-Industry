package com.entity.model;

import com.entity.RemaijiushuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 热卖酒水
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-16 16:33:34
 */
public class RemaijiushuiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 酒水类型
	 */
	
	private String jiushuileixing;
		
	/**
	 * 包装形式
	 */
	
	private String baozhuangxingshi;
		
	/**
	 * 品牌
	 */
	
	private String pinpai;
		
	/**
	 * 度数
	 */
	
	private String dushu;
		
	/**
	 * 储藏方法
	 */
	
	private String chuzangfangfa;
		
	/**
	 * 生产年份
	 */
	
	private String shengchannianfen;
		
	/**
	 * 产地
	 */
	
	private String chandi;
		
	/**
	 * 厂名
	 */
	
	private String changming;
		
	/**
	 * 适用场景
	 */
	
	private String shiyongchangjing;
		
	/**
	 * 生产许可证
	 */
	
	private String shengchanxukezheng;
		
	/**
	 * 酒水详情
	 */
	
	private String jiushuixiangqing;
		
	/**
	 * 单限
	 */
	
	private Integer onelimittimes;
		
	/**
	 * 库存
	 */
	
	private Integer alllimittimes;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 价格
	 */
	
	private Float price;
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：酒水类型
	 */
	 
	public void setJiushuileixing(String jiushuileixing) {
		this.jiushuileixing = jiushuileixing;
	}
	
	/**
	 * 获取：酒水类型
	 */
	public String getJiushuileixing() {
		return jiushuileixing;
	}
				
	
	/**
	 * 设置：包装形式
	 */
	 
	public void setBaozhuangxingshi(String baozhuangxingshi) {
		this.baozhuangxingshi = baozhuangxingshi;
	}
	
	/**
	 * 获取：包装形式
	 */
	public String getBaozhuangxingshi() {
		return baozhuangxingshi;
	}
				
	
	/**
	 * 设置：品牌
	 */
	 
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
				
	
	/**
	 * 设置：度数
	 */
	 
	public void setDushu(String dushu) {
		this.dushu = dushu;
	}
	
	/**
	 * 获取：度数
	 */
	public String getDushu() {
		return dushu;
	}
				
	
	/**
	 * 设置：储藏方法
	 */
	 
	public void setChuzangfangfa(String chuzangfangfa) {
		this.chuzangfangfa = chuzangfangfa;
	}
	
	/**
	 * 获取：储藏方法
	 */
	public String getChuzangfangfa() {
		return chuzangfangfa;
	}
				
	
	/**
	 * 设置：生产年份
	 */
	 
	public void setShengchannianfen(String shengchannianfen) {
		this.shengchannianfen = shengchannianfen;
	}
	
	/**
	 * 获取：生产年份
	 */
	public String getShengchannianfen() {
		return shengchannianfen;
	}
				
	
	/**
	 * 设置：产地
	 */
	 
	public void setChandi(String chandi) {
		this.chandi = chandi;
	}
	
	/**
	 * 获取：产地
	 */
	public String getChandi() {
		return chandi;
	}
				
	
	/**
	 * 设置：厂名
	 */
	 
	public void setChangming(String changming) {
		this.changming = changming;
	}
	
	/**
	 * 获取：厂名
	 */
	public String getChangming() {
		return changming;
	}
				
	
	/**
	 * 设置：适用场景
	 */
	 
	public void setShiyongchangjing(String shiyongchangjing) {
		this.shiyongchangjing = shiyongchangjing;
	}
	
	/**
	 * 获取：适用场景
	 */
	public String getShiyongchangjing() {
		return shiyongchangjing;
	}
				
	
	/**
	 * 设置：生产许可证
	 */
	 
	public void setShengchanxukezheng(String shengchanxukezheng) {
		this.shengchanxukezheng = shengchanxukezheng;
	}
	
	/**
	 * 获取：生产许可证
	 */
	public String getShengchanxukezheng() {
		return shengchanxukezheng;
	}
				
	
	/**
	 * 设置：酒水详情
	 */
	 
	public void setJiushuixiangqing(String jiushuixiangqing) {
		this.jiushuixiangqing = jiushuixiangqing;
	}
	
	/**
	 * 获取：酒水详情
	 */
	public String getJiushuixiangqing() {
		return jiushuixiangqing;
	}
				
	
	/**
	 * 设置：单限
	 */
	 
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	
	/**
	 * 获取：单限
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
				
	
	/**
	 * 设置：库存
	 */
	 
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	
	/**
	 * 获取：库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Float getPrice() {
		return price;
	}
			
}
