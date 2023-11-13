package com.liuwenhao.myblog.domain;

import lombok.Data;

@Data
public class Article {

    private Integer id;

    private Integer commentCounts;

    private Integer createDate;

    private String summary;

    private String title;

    private Integer viewCounts;

    private Integer weight;

    private Integer AuthorId;

    private Integer bodyId;

    private Integer categoryId;
}
