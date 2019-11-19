package com.bjsxt.backend.item.service.impl;

import com.bjsxt.backend.item.feign.CommonItemFeignClient;
import com.bjsxt.backend.item.service.ItemCategoryService;
import com.bjsxt.pojo.TbItemCat;
import com.bjsxt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{
    @Autowired
    private CommonItemFeignClient commonItemFeignClient;
    @Override
    public Result selectItemCategoryByParentId(Long id) {
        List<TbItemCat> tbItemCats = commonItemFeignClient.selectItemCategoryByParentId(id);
        if (tbItemCats !=null){
            return Result.ok(tbItemCats);
        }
        return Result.error("error");
    }
}
