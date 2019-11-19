package com.bjsxt.content.controller;

import com.bjsxt.content.service.ContentCategoryService;
import com.bjsxt.pojo.TbContentCategory;
import com.bjsxt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;
    @RequestMapping("/selectContentCategoryByParentId")
    public Result selectContentCategoryByParentId(Long parentId){
        try{
            return contentCategoryService.selectContentCategoryByParentId(parentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("error");
    }
    /*
      添加内容分类
     */
    @RequestMapping("/insertContentCategory")
    public Result insertContentCategory(TbContentCategory contentCategory){
        try{
              return contentCategoryService.insertContentCategory(contentCategory);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("error");
    }
}
