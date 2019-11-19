package com.bjsxt.backend.item.service.impl;

import com.bjsxt.backend.item.feign.CommonItemFeignClient;
import com.bjsxt.backend.item.service.ItemParamService;
import com.bjsxt.pojo.TbItem;
import com.bjsxt.pojo.TbItemParam;
import com.bjsxt.utils.PageResult;
import com.bjsxt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
   private CommonItemFeignClient commonItemFeignClient;

    @Override
    public Result selectItemParamByItemCatId(Long itemCatId) {
        TbItemParam tbItemParam = commonItemFeignClient.selectItemParamByItemCatId(itemCatId);
        if(tbItemParam !=null){
            return Result.ok(tbItemParam);
        }
        return Result.error("error");
    }
    /*
      查询全部的规格参数
     */
    @Override
    public Result selectItemParamAll() {
        PageResult pageResult = commonItemFeignClient.selectItemParamAll();
        if (pageResult !=null && pageResult.getTotalPage()>0){
            return Result.ok(pageResult);
        }
        return Result.error("查询失败");
    }
    /*
       增加商品规格参数模板
     */
    @Override
    public Result insertItemParam(Long itemCatId, String paramData) {
        TbItemParam itemParam=new TbItemParam();
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        itemParam.setItemCatId(itemCatId);
        itemParam.setParamData(paramData);
        commonItemFeignClient.insertItemParam(itemParam);
        return Result.ok();
    }
    /*
      根据商品规格模板参数删除商品规格参数模板
     */
    @Override
    public Result deleteItemParamById(Long id) {
        Integer integer = commonItemFeignClient.deleteItemParamById(id);
        if (integer != null && integer>0){
            return Result.ok();
        }
        return Result.error("error");
    }
}
