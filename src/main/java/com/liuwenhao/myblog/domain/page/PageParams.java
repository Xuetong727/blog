package com.liuwenhao.myblog.domain.page;

import lombok.Data;

@Data
public class PageParams {

    private int pageNumber = 1;

    private int pageSize = 10;


}
