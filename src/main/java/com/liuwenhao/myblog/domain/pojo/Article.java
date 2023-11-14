package com.liuwenhao.myblog.domain.pojo;

import lombok.Data;

@Data
public class Article {

    private Long id;

    private Integer commentCounts;

    private Long createDate;

    private String summary;

    private String title;

    private Integer viewCounts;

    private Integer weight;

    private Long AuthorId;

    private Long bodyId;

    private Long categoryId;
}
