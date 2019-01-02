package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author
 * @create 2019-01-02 09:27
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDelDto implements Serializable {
    private static final long serialVersionUID = 6429533018350087930L;

    private String userFid;

    private String operator;
}
