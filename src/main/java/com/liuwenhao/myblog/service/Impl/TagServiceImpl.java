package com.liuwenhao.myblog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwenhao.myblog.domain.pojo.Tag;
import com.liuwenhao.myblog.mapper.TagMapper;
import com.liuwenhao.myblog.service.TagService;
import org.springframework.stereotype.Service;


@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
}
