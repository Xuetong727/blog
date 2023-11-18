package com.liuwenhao.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuwenhao.myblog.domain.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
}
