package com.ziroom.ups.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 * @create 2018-12-15 19:26
 * Description:
 */
@Data
public class PageDto implements Serializable {
    private static final long serialVersionUID = 6470572144133991051L;

    private Integer page = 1;

    private Integer limit = 10;
}
