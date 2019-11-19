package com.bjsxt.item.service.impl;

import com.bjsxt.item.service.ItemService;
import com.bjsxt.mapper.*;
import com.bjsxt.pojo.*;
import com.bjsxt.utils.PageResult;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    /**
     * 查询所有商品并分页
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult selectTbItemAllByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        TbItemExample tbItemExample=new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andStatusEqualTo((byte)1);
        List<TbItem> list=this.tbItemMapper.selectByExample(tbItemExample);
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        PageResult pageResult=new PageResult();
        pageResult.setPageIndex(page);
        pageResult.setTotalPage(pageInfo.getTotal());
        pageResult.setResult(list);
        return pageResult;
    }

    /**
     * 添加商品
     * @param tbItem
     * @return
     */
    @Override
    public Integer insertTbItem(TbItem tbItem) {
        return this.tbItemMapper.insert(tbItem);
    }
    /*
      更新和删除商品
       删除是更新status的值为3
     */
    @Override
    @LcnTransaction
    public Integer updateItemById(TbItem tbItem) {
        tbItem.setUpdated(new Date());
        return tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }

    /**
     * 根据商品id
     * 查询商品的分类,描述,参数.
     * @param itemId
     * @return
     */
    @Override
    public Map<String, Object> preUpdateItem(Long itemId) {
         Map<String,Object> map=new HashMap<>();
         // 商品
         TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
         map.put("item",item);
         // 商品描述
         TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(itemId);
         map.put("itemDesc",tbItemDesc.getItemDesc());
         // 商品类目
        TbItemCat tbItemCat = tbItemCatMapper.selectByPrimaryKey(item.getCid());
        map.put("itemCat",tbItemCat.getName());
        //规格参数
        TbItemParamItemExample example=new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> tbItemParamItems = tbItemParamItemMapper.selectByExample(example);
        if (tbItemParamItems !=null && tbItemParamItems.size()>0)
            map.put("itemParamItem",tbItemParamItems.get(0));
        return map;
    }
    /*
      更新商品
     */
    @Override
    @LcnTransaction
    public Integer updateTbitem(TbItem tbItem) {
        tbItem.setUpdated(new Date());
        return tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }
}
