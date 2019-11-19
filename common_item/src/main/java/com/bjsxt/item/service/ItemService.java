package com.bjsxt.item.service;

import com.bjsxt.pojo.TbItem;
import com.bjsxt.utils.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ItemService {
    PageResult selectTbItemAllByPage(Integer page,Integer rows);
    Integer insertTbItem(TbItem tbItem);
    Integer updateItemById(@RequestParam TbItem tbItem);

    Map<String, Object> preUpdateItem(Long itemId);
    Integer updateTbitem(@RequestBody TbItem tbItem);
}
