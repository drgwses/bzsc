package com.bjsxt.item.controller;

import com.bjsxt.item.service.ItemCategoryService;
import com.bjsxt.pojo.TbContent;
import com.bjsxt.pojo.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service/itemCategory")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;
     /*
       根据父节点类目查询子节点类目
      */
      @RequestMapping("/selectItemCategoryByParentId")
      public List<TbItemCat> selectItemCategoryByParentId(@RequestParam()Long id){
          return  itemCategoryService.selectItemCategoryByParentId(id);
      }
}
