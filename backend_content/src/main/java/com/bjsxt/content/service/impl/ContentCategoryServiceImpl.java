package com.bjsxt.content.service.impl;

import com.bjsxt.content.feign.CommonContentFeignClient;
import com.bjsxt.content.service.ContentCategoryService;
import com.bjsxt.pojo.TbContentCategory;
import com.bjsxt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private CommonContentFeignClient commonContentFeignClient;
    /*
       查询内容分类
     */
    @Override
    public Result selectContentCategoryByParentId(Long parentId) {
        List<TbContentCategory> list = commonContentFeignClient.selectContentCategoryByParentId(parentId);
              if (list!=null && list.size()>0){
                  return Result.ok(list);
              }
        return Result.error("error");
    }
    /*
        添加内容分类
     */
    @Override
    public Result insertContentCategory(TbContentCategory contentCategory) {
        Integer integer = commonContentFeignClient.insertContentCategory(contentCategory);
        if (integer !=null & integer>0){
             return Result.ok();
        }
        return Result.error("error");
    }
}
