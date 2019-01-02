package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author
 * @create 2019-01-01 18:26
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto implements Serializable {
    private static final long serialVersionUID = 9100570449122024178L;

    private String roleFid;

    private String roleName;
}
