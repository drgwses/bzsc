package com.bjsxt.item.controller;

import com.bjsxt.item.service.ItemParamItemService;
import com.bjsxt.pojo.TbItemParamItem;
import com.sun.corba.se.spi.ior.IORTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/itemParamItem")
public class ItemParaItemController {
    @Autowired
    private ItemParamItemService itemParamItemService;
    /*
      添加商品规格参数
     */
    @RequestMapping("/insertTbItemParamItem")
    public Integer insertTbItemParamItem(@RequestBody TbItemParamItem tbItemParamItem) {
            return  null;
    }
    /*
      更新商品规格参数
     */
    @RequestMapping("/updateTbItemParamItem")
    public Integer updateTbItemParamItem(@RequestBody TbItemParamItem tbItemParamItem){
        return itemParamItemService.updateTbItemParamItem(tbItemParamItem);
    }
}
