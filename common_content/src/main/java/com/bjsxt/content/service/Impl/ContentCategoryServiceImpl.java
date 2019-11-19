package com.bjsxt.content.service.Impl;

import com.bjsxt.content.service.ContentCategoryService;
import com.bjsxt.mapper.TbContentCategoryMapper;
import com.bjsxt.pojo.TbContentCategory;
import com.bjsxt.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    /**
     *  根据父节点id查询子节点
     * @param parentId
     * @return
     */
    @Override
    public List<TbContentCategory> selectContentCategoryByParentId(Long parentId){
        TbContentCategoryExample example=new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        return list;
    }

    /**
     * 增加前台内容
     * @param contentCategory
     * @return
     */
    @Override
    public Integer insertContentCategory(TbContentCategory contentCategory) {
        // 补齐数据
        contentCategory.setUpdated(new Date());
        contentCategory.setCreated(new Date());
        contentCategory.setIsParent(false);
        contentCategory.setSortOrder(1);
        contentCategory.setStatus(1);
        // 插入数据
        Integer insert = contentCategoryMapper.insert(contentCategory);
        // 查询当前新节点的父节点
        TbContentCategory tbContentCategory = contentCategoryMapper.selectByPrimaryKey(contentCategory.getParentId());
        if (!tbContentCategory.getIsParent()){
            tbContentCategory.setIsParent(true);
            contentCategory.setCreated(new Date());
            contentCategoryMapper.updateByPrimaryKey(tbContentCategory);
        }
       return insert;
    }
}
