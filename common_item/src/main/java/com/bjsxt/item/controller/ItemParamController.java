package com.bjsxt.item.controller;

import com.bjsxt.item.service.ItemParamService;
import com.bjsxt.pojo.TbItemParam;
import com.bjsxt.utils.PageResult;
import com.bjsxt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/itemParam")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;
    /*
       根据商品类目id查询商品类目所对应的模板
     */
    @RequestMapping("/selectItemParamByItemCatId")
    public TbItemParam selectItemParamByItemCatId(@RequestParam Long itemCatId){
     return itemParamService.selectItemParamByItemCatId(itemCatId);
    }
    /*
      查询所有规格参数模板
     */
    @RequestMapping("/selectItemParamAll")
    public PageResult selectItemParamAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer rows){
        return itemParamService.selectItemParamAll(page,rows);
    }

    /*
       商品规格参数模板的添加
     */
    @RequestMapping("/insertItemParam")
    public Integer insertItemParam(@RequestBody TbItemParam tbItemParam){
         return itemParamService.insertItemParam(tbItemParam);
    }
    /*
      根据商品规格参数模板的id删除数据
     */
    @RequestMapping()
    public Integer deleteItemParamById(@RequestParam Long id){
            return itemParamService.deleteItemParamById(id);
    }
}
