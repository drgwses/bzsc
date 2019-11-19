package com.bjsxt.content.feign;

import com.bjsxt.pojo.TbContentCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "common-content")
public interface CommonContentFeignClient {
   //------------------------------/service/contentCategory
    @PostMapping("service/contentCategory/selectContentCategoryByParentId")
    List<TbContentCategory> selectContentCategoryByParentId(@RequestParam Long parentId);
    @PostMapping("/service/contentCategory/insertContentCategory")
    Integer  insertContentCategory(@RequestBody TbContentCategory contentCategory);
}
