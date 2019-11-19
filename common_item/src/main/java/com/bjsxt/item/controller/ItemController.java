package com.bjsxt.item.controller;
import com.bjsxt.item.service.ItemService;
import com.bjsxt.pojo.TbItem;
import com.bjsxt.utils.PageResult;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/service/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
     /*
       查询商品数据
     */
     @RequestMapping("/selectTbItemAllByPage")
     public PageResult selectTbItemAllByPage(@RequestParam Integer page,@RequestParam  Integer rows){
        return  this.itemService.selectTbItemAllByPage(page,rows);
     }
     /*
       添加商品
      */
      @RequestMapping("/insertTbItem")
      @LcnTransaction
      public Integer insertTbItem(@RequestBody TbItem tbItem){
         return itemService.insertTbItem(tbItem);
     }
     /*
       删除商品
      */
     @RequestMapping("/deleteItemById")
    public Integer deleteItemById(@RequestBody TbItem tbItem){
         return  itemService.updateItemById(tbItem);
     }
     /*
     根据商品id查询商品,商品分类,商品描述,商品规格参数
      */
     @RequestMapping("/preUpdateItem")
    public Map<String,Object> preUpdateItem(@RequestParam Long itemId){
         return itemService.preUpdateItem(itemId);
     }
     /*
       更新商品信息
      */
     @RequestMapping("/updateTbitem")
     public Integer updateTbitem(@RequestBody TbItem tbItem){
        return itemService.updateItemById(tbItem);
     }
}
