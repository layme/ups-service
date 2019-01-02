package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author
 * @create 2019-01-01 12:24
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleResDelDto implements Serializable {
    private static final long serialVersionUID = 5510661749328188478L;

    private String roleFid;

    private String operator;
}
