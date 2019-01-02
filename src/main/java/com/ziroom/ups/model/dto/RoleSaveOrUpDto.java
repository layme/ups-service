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
 * @create 2019-01-01 00:36
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleSaveOrUpDto implements Serializable {
    private static final long serialVersionUID = 2092183272074359398L;

    private String fid;

    @NotBlank(message = "应用代码不能为空")
    private String appCode;

    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    private String roleDesc;

    private List<String> resList;
}
