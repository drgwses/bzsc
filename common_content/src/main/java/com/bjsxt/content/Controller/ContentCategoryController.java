package com.bjsxt.content.Controller;

import com.bjsxt.content.service.ContentCategoryService;
import com.bjsxt.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/service/contentCategory")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;
    /*
       根据父节点id查询子节点
     */
    @RequestMapping("/selectContentCategoryByParentId")
    public List<TbContentCategory> selectContentCategoryByParentId(@RequestParam Long parentId){
        return contentCategoryService.selectContentCategoryByParentId(parentId);
    }
    /*
      添加内容分类
     */
     @RequestMapping("/insertContentCategory")
     public Integer   insertContentCategory(@RequestBody TbContentCategory contentCategory){
         return contentCategoryService.insertContentCategory(contentCategory);
     }
}
