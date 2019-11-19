package com.bjsxt.backend.item.controller;

import com.bjsxt.backend.item.service.ItemService;
import com.bjsxt.pojo.TbItem;
import com.bjsxt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend/item")
public class ItemController{
    @Autowired
    private ItemService itemService;
    /*
      查询商品
     */
    @RequestMapping("/selectTbItemAllByPage")
    public Result selectTbItemAllByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam( defaultValue = "2") Integer rows){
      try {
         return  itemService.selectTbItemAllByPage(page,rows);
      }catch (Exception e){
           e.printStackTrace();
      }
      return Result.build(500,"查无结果");
    }
    /*
     添加商品
     */
    @RequestMapping("/insertTbItem")
    public Result insertTbItem(TbItem tbItem,String desc,String itemParams){
        try {
            return  this.itemService.insertTbItem(tbItem,desc,itemParams);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"添加失败");
    }
    /*
      删除商品
     */
    @RequestMapping("/deleteItemById")
    public Result deleteItemById(Long itemId){
        try {
            return  itemService.deleteItemById(itemId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"删除失败");
    }
    /*
      预更新商品查询
     */
    @RequestMapping("/preUpdateItem")
    public Result preUpdateItem(Long itemId){
        try {
            return  itemService.preUpdateItem(itemId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"查询失败");
    }
    /*
      更新商品
     */
    @RequestMapping("/updateTbItem")
    public Result updateTbItem(TbItem tbItem,String desc,String itemParams){
        try {
            return  itemService.updateTbItem(tbItem,desc,itemParams);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"error");
    }

}
