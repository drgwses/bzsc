package com.bjsxt.backend.item.feign;

import com.bjsxt.pojo.*;
import com.bjsxt.utils.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "common-item")
public interface CommonItemFeignClient{
    // 商品
    @GetMapping("/service/item/selectTbItemAllByPage")
    PageResult selectTbItemAllByPage(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows);
    @PostMapping("/service/item/insertTbItem")
    Integer insertTbItem(@RequestBody TbItem tbItem);
    @PostMapping("/service/item/deleteItemById")
     Integer deleteItemById(@RequestBody TbItem tbItem);
    @PostMapping("/service/item/preUpdateItem")
    Map<String,Object> preUpdateItem(@RequestParam Long itemId);
    @PostMapping("/service/item/updateTbitem")
    Integer updateTbitem(@RequestBody TbItem tbItem);
    //商品描述
    @RequestMapping("/service/itemDesc/insertItemDesc")
    Integer insertItemDesc(@RequestBody TbItemDesc tbItemDesc);
    @PostMapping("/service/itemDesc/updateItemDesc")
    Integer updateItemDesc(@RequestBody TbItemDesc tbItemDesc);
    // 商品规格参数
    @RequestMapping("/service/itemParamItem/insertTbItemParamItem")
     Integer insertTbItemParamItem(@RequestBody TbItemParamItem tbItemParamItem);
    // 商品类目
    @PostMapping("/service/itemCategory/selectItemCategoryByParentId")
    List<TbItemCat> selectItemCategoryByParentId(@RequestParam("id") long id);
    // 商品规格参数模板
    @PostMapping("/service/itemParam/selectItemParamByItemCatId")
    TbItemParam selectItemParamByItemCatId(@RequestParam("itemCatId") Long itemCatId);
    @PostMapping("/service/itemParam/updateTbItemParamItem")
     Integer updateTbItemParamItem(@RequestBody TbItemParamItem tbItemParamItem);
    @PostMapping("/service/itemParam/selectItemParamAll")
     PageResult selectItemParamAll();
    @PostMapping("/service/itemParam/insertItemParam")
    Integer insertItemParam(@RequestBody TbItemParam tbItemParam);
    @PostMapping("/service/itemParam/deleteItemParamById")
    Integer deleteItemParamById(@RequestParam Long id);
}
