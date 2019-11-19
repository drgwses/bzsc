package com.bjsxt.item.service.impl;

import com.bjsxt.item.service.ItemParamItemService;
import com.bjsxt.mapper.TbItemParamItemMapper;
import com.bjsxt.mapper.TbItemParamMapper;
import com.bjsxt.pojo.TbItemParamItem;
import com.bjsxt.pojo.TbItemParamItemExample;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;
    /*
       更新商品规格参数
     */
    @Override
    public Integer insertTbItemParamItem(TbItemParamItem tbItemParamItem) {
        return tbItemParamItemMapper.insert(tbItemParamItem);
    }
      /*
         更新商品规格参数
       */
    @Override
    @LcnTransaction
    public Integer updateTbItemParamItem(TbItemParamItem tbItemParamItem) {
        tbItemParamItem.setUpdated(new Date());
        TbItemParamItemExample example=new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(tbItemParamItem.getItemId());
        return this.tbItemParamItemMapper.updateByExampleSelective(tbItemParamItem,example);
    }
}
