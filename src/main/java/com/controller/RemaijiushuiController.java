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
import com.entity.OrdersEntity;
import com.service.OrdersService;

import com.entity.RemaijiushuiEntity;
import com.entity.view.RemaijiushuiView;

import com.service.RemaijiushuiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 热卖酒水
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-16 16:33:34
 */
@RestController
@RequestMapping("/remaijiushui")
public class RemaijiushuiController {
    @Autowired
    private RemaijiushuiService remaijiushuiService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RemaijiushuiEntity remaijiushui,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<RemaijiushuiEntity> ew = new EntityWrapper<RemaijiushuiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = remaijiushuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remaijiushui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RemaijiushuiEntity remaijiushui, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<RemaijiushuiEntity> ew = new EntityWrapper<RemaijiushuiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = remaijiushuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remaijiushui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RemaijiushuiEntity remaijiushui){
       	EntityWrapper<RemaijiushuiEntity> ew = new EntityWrapper<RemaijiushuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( remaijiushui, "remaijiushui")); 
        return R.ok().put("data", remaijiushuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RemaijiushuiEntity remaijiushui){
        EntityWrapper< RemaijiushuiEntity> ew = new EntityWrapper< RemaijiushuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( remaijiushui, "remaijiushui")); 
		RemaijiushuiView remaijiushuiView =  remaijiushuiService.selectView(ew);
		return R.ok("查询热卖酒水成功").put("data", remaijiushuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RemaijiushuiEntity remaijiushui = remaijiushuiService.selectById(id);
		remaijiushui.setClicknum(remaijiushui.getClicknum()+1);
		remaijiushui.setClicktime(new Date());
		remaijiushuiService.updateById(remaijiushui);
        return R.ok().put("data", remaijiushui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RemaijiushuiEntity remaijiushui = remaijiushuiService.selectById(id);
		remaijiushui.setClicknum(remaijiushui.getClicknum()+1);
		remaijiushui.setClicktime(new Date());
		remaijiushuiService.updateById(remaijiushui);
        return R.ok().put("data", remaijiushui);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        RemaijiushuiEntity remaijiushui = remaijiushuiService.selectById(id);
        if(type.equals("1")) {
        	remaijiushui.setThumbsupnum(remaijiushui.getThumbsupnum()+1);
        } else {
        	remaijiushui.setCrazilynum(remaijiushui.getCrazilynum()+1);
        }
        remaijiushuiService.updateById(remaijiushui);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RemaijiushuiEntity remaijiushui, HttpServletRequest request){
    	remaijiushui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(remaijiushui);
        remaijiushuiService.insert(remaijiushui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RemaijiushuiEntity remaijiushui, HttpServletRequest request){
    	remaijiushui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(remaijiushui);
        remaijiushuiService.insert(remaijiushui);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RemaijiushuiEntity remaijiushui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(remaijiushui);
        remaijiushuiService.updateById(remaijiushui);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        remaijiushuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<RemaijiushuiEntity> wrapper = new EntityWrapper<RemaijiushuiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = remaijiushuiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,RemaijiushuiEntity remaijiushui, HttpServletRequest request,String pre){
        EntityWrapper<RemaijiushuiEntity> ew = new EntityWrapper<RemaijiushuiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = remaijiushuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remaijiushui), params), params));
        return R.ok().put("data", page);
    }


        /**
     * 协同算法（按用户购买推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,RemaijiushuiEntity remaijiushui, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "jiushuileixing";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "remaijiushui").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<RemaijiushuiEntity> remaijiushuiList = new ArrayList<RemaijiushuiEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        remaijiushuiList.addAll(remaijiushuiService.selectList(new EntityWrapper<RemaijiushuiEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<RemaijiushuiEntity> ew = new EntityWrapper<RemaijiushuiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = remaijiushuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remaijiushui), params), params));
        List<RemaijiushuiEntity> pageList = (List<RemaijiushuiEntity>)page.getList();
        if(remaijiushuiList.size()<limit) {
                int toAddNum = (limit-remaijiushuiList.size())<=pageList.size()?(limit-remaijiushuiList.size()):pageList.size();
                for(RemaijiushuiEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(RemaijiushuiEntity o2 : remaijiushuiList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        remaijiushuiList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(remaijiushuiList.size()>limit) {
            remaijiushuiList = remaijiushuiList.subList(0, limit);
        }
        page.setList(remaijiushuiList);
        return R.ok().put("data", page);
    }







}
