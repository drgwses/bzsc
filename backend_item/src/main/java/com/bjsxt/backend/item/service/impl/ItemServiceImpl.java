package com.bjsxt.backend.item.service.impl;

import com.bjsxt.backend.item.feign.CommonItemFeignClient;
import com.bjsxt.backend.item.service.ItemService;
import com.bjsxt.pojo.TbItem;
import com.bjsxt.pojo.TbItemDesc;
import com.bjsxt.pojo.TbItemParamItem;
import com.bjsxt.utils.IDUtils;
import com.bjsxt.utils.PageResult;
import com.bjsxt.utils.Result;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private CommonItemFeignClient commonItemFeignClient;
    @Override
    public Result selectTbItemAllByPage(Integer page, Integer rows) {
        PageResult pageResult = this.commonItemFeignClient.selectTbItemAllByPage(page, rows);
        if (pageResult !=null && pageResult.getResult() !=null && pageResult.getResult().size()> 0){
            return  Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }

    /**
     * 添加商品
     * @param tbItem
     * @param desc
     * @param itemParams
     * @return
     */
    @Override
    @LcnTransaction
    public Result insertTbItem(TbItem tbItem, String desc, String itemParams) {
        // 补齐TbItem表的数据
        Long itemid= IDUtils.genItemId();
        Date  date=new Date();
        tbItem.setId(itemid);
        tbItem.setStatus((byte)1);
        tbItem.setUpdated(date);
        tbItem.setCreated(date);
        Integer integer = commonItemFeignClient.insertTbItem(tbItem);
        // 补齐商品描述对象
        TbItemDesc tbItemDesc=new TbItemDesc();
        tbItemDesc.setItemId(itemid);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        Integer integer1 = commonItemFeignClient.insertItemDesc(tbItemDesc);
        // 补齐商品规格参数对象
        TbItemParamItem tbItemParamItem=new TbItemParamItem();
        tbItemParamItem.setItemId(itemid);
        tbItemParamItem.setParamData(itemParams);
        tbItemParamItem.setCreated(date);
        tbItemParamItem.setUpdated(date);
        Integer integer2 = commonItemFeignClient.insertTbItemParamItem(tbItemParamItem);
        System.out.println("添加成功了");
        return Result.ok();
    }

    /**
     * 删除商品
     * @param itemId
     * @return
     */
    @Override
    @LcnTransaction
    public Result deleteItemById(Long itemId) {
        TbItem item=new TbItem();
        item.setId(itemId);
        item.setStatus((byte)3);
        Integer integer = commonItemFeignClient.deleteItemById(item);
        if (integer!=null){
            return Result.ok();
        }
        return Result.error("删除失败");
    }

    /**
     * 预更新商品查询
     * @param itemId
     * @return
     */
    @Override
    public Result preUpdateItem(Long itemId) {
        Map<String, Object> map = commonItemFeignClient.preUpdateItem(itemId);
        if (map !=null && map.size()>0){
            return Result.ok(map);
        }
        return Result.error("查询失败");
    }
    /*
      更新商品
     */
    @Override
    public Result updateTbItem(TbItem tbItem, String desc, String itemParams) {
        // 更新商品
        Integer itemNum=commonItemFeignClient.updateTbitem(tbItem);
        // 更新商品描述
        TbItemDesc itemDesc=new TbItemDesc();
        itemDesc.setItemId(tbItem.getId());
        itemDesc.setItemDesc(desc);
        Integer itemDescNum=commonItemFeignClient.updateItemDesc(itemDesc);
        // 更新商品规格参数
        TbItemParamItem tbItemParamItem=new TbItemParamItem();
        tbItemParamItem.setParamData(itemParams);
        tbItemParamItem.setItemId(tbItem.getId());
        Integer itemParamItemNum=commonItemFeignClient.updateTbItemParamItem(tbItemParamItem);
        return Result.ok();
    }
}
