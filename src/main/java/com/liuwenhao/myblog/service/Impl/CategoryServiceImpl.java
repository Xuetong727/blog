package com.liuwenhao.myblog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwenhao.myblog.domain.pojo.Category;
import com.liuwenhao.myblog.mapper.CategoryMapper;
import com.liuwenhao.myblog.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
