package com.liuwenhao.myblog.domain.vo;

import lombok.Data;

@Data
public class ArticleBodyVo {

    private Long id;

    private String content;

    private String contentHtml;

    private Long articleId;

}
