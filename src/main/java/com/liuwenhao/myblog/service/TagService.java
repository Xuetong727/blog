package com.liuwenhao.myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuwenhao.myblog.domain.pojo.Tag;
import com.liuwenhao.myblog.domain.vo.TagVo;

import java.util.ArrayList;
import java.util.List;

public interface TagService extends IService<Tag> {
    List<TagVo> getHotTags(int limit);
}
