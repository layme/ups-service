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
public class UserSaveOrUpDto implements Serializable {
    private static final long serialVersionUID = 4684666162745505504L;

    private String fid;

    @NotBlank(message = "邮箱前缀不能为空")
    private String account;

    private String employeeFid;

    private List<UserRoleDto> roleList;
}
