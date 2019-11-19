package com.bjsxt.item.service.impl;

import com.bjsxt.item.service.ItemDescService;
import com.bjsxt.mapper.TbItemDescMapper;
import com.bjsxt.pojo.TbItemDesc;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItemDescServiceImpl implements ItemDescService {
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    /**
     * 添加商品描述
     * @param tbItemDesc
     * @return
     */
    @Override
    public Integer insertItemDesc(TbItemDesc tbItemDesc) {
        return tbItemDescMapper.insert(tbItemDesc);
    }

    /**
     * 更新商品描述
     * @param tbItemDesc
     * @return
     */
    @Override
    @LcnTransaction
    public Integer updateItemDesc(TbItemDesc tbItemDesc) {
        tbItemDesc.setUpdated(new Date());
        return tbItemDescMapper.updateByPrimaryKeySelective(tbItemDesc);
    }
}
