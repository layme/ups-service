package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @create 2019-01-01 00:17
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleListDto extends PageDto {
    private static final long serialVersionUID = 9167462003134999695L;

    private String roleName;

    private String appCode;
}
