package com.bjsxt.item.service.impl;

import com.bjsxt.item.service.ItemCategoryService;
import com.bjsxt.mapper.TbItemCatMapper;
import com.bjsxt.pojo.TbItemCat;
import com.bjsxt.pojo.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TbItemCat> selectItemCategoryByParentId(Long id) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        criteria.andStatusEqualTo(1);
        List<TbItemCat> tbItemCats = this.itemCatMapper.selectByExample(example);
        return tbItemCats;
    }
}
