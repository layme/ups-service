package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
public class AppSaveOrUpDto implements Serializable {
    private static final long serialVersionUID = 22108274140987349L;

    private String fid;

    @NotBlank(message = "应用名称不能为空")
    private String appName;

    @NotBlank(message = "应用代码不能为空")
    private String appCode;

    @NotBlank(message = "应用访问域名不能为空")
    private String appUrl;
}
