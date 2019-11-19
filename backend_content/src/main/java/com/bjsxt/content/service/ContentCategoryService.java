package com.bjsxt.content.service;

import com.bjsxt.pojo.TbContentCategory;
import com.bjsxt.utils.Result;

public interface ContentCategoryService {
    Result selectContentCategoryByParentId(Long parentId);

    Result insertContentCategory(TbContentCategory contentCategory);
}
