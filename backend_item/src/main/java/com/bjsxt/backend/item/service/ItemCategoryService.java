package com.bjsxt.backend.item.service;


import com.bjsxt.utils.Result;

import java.util.List;

public interface ItemCategoryService {
    Result selectItemCategoryByParentId(Long id);
}
