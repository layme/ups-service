package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author
 * @create 2018-12-15 20:13
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStopOrStartDto implements Serializable {
    private static final long serialVersionUID = -8441332370945336122L;

    @NotBlank(message = "角色FID不能为空")
    private String userFid;

    @NotNull(message = "角色状态不能为空")
    private Byte userStatus;
}
