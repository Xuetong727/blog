package com.liuwenhao.myblog.domain.pojo;

import io.swagger.annotations.Api;
import lombok.Data;

@Api("文章-标签关系表")
@Data
public class ArticleTag {

    private Long id;

    private Long ArticleId;

    private Long TagId;

}
