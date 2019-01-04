package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author
 * @create 2019-01-01 14:52
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuResDto implements Serializable {
    private static final long serialVersionUID = -7907831221503829766L;
    @NotBlank(message = "应用代码不能为空")
    private String appCode;

    @NotBlank(message = "工号不能为空")
    private String account;
}
