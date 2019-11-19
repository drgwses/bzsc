package com.bjsxt.item.service.impl;

import com.bjsxt.item.service.ItemParamService;
import com.bjsxt.mapper.TbItemParamMapper;
import com.bjsxt.pojo.TbItemExample;
import com.bjsxt.pojo.TbItemParam;
import com.bjsxt.pojo.TbItemParamExample;
import com.bjsxt.utils.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private TbItemParamMapper  tbItemParamMapper;
    @Override
    public TbItemParam selectItemParamByItemCatId(Long itemCatId){
        TbItemParamExample example=new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(itemCatId);
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExampleWithBLOBs(example);
        if (tbItemParams!=null && tbItemParams.size()>0){
           return tbItemParams.get(0);
        }
        return null;
    }
    /*
      查询全部规格参数
     */
    @Override
    public PageResult selectItemParamAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
        PageInfo<TbItemParam> tbItemParamPageInfo = new PageInfo<>(list);
        PageResult pageResult=new PageResult();
        pageResult.setPageIndex(page);
        pageResult.setResult(list);
        pageResult.setTotalPage(tbItemParamPageInfo.getTotal());
        return pageResult;
    }
    /*
       增加商品规格参数模板
     */
    @Override
    public Integer insertItemParam(TbItemParam tbItemParam) {
        return tbItemParamMapper.insertSelective(tbItemParam);
    }
    /*
      删除商品规格参数
     */
    @Override
    public Integer deleteItemParamById(@RequestParam Long id) {
        return tbItemParamMapper.deleteByPrimaryKey(id);
    }
}
