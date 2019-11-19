package com.bjsxt.backend.item.controller;

import com.bjsxt.backend.item.service.ItemParamService;
import com.bjsxt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

@RestController
@RequestMapping("/backend/itemParam")
public class ItemParamController {
     @Autowired
     private ItemParamService itemParamService;
    /*
       根据商品类型id查询商品参数模板
     */
    @RequestMapping("/selectItemParamByItemCatId/{itemCatId}")
    public Result selectItemParamByItemCatId(@PathVariable("itemCatId")Long itemCatId){
          try {
               return itemParamService.selectItemParamByItemCatId(itemCatId);
          }catch (Exception e){
               e.printStackTrace();
          }
          return Result.error("error");
    }
    /*
       查询全部的商品参数模板
     */
    @RequestMapping("/selectItemParamAll")
    public Result selectItemParamAll(){
        try {
            return itemParamService.selectItemParamAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("error");
    }
    /*
      添加商品规格参数模板
     */
    @RequestMapping("/insertItemParam")
    public Result insertItemParam(Long itemCatId,String paramData){
        try {
            return itemParamService.insertItemParam(itemCatId,paramData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("error");
    }
    /*
      删除商品规格参数模板
     */
    @RequestMapping("/deleteItemParamById")
    public Result deleteItemParamById(Long id){
        try {
            return itemParamService.deleteItemParamById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("error");
    }
}
