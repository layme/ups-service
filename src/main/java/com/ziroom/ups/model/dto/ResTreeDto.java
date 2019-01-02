package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author
 * @create 2018-12-15 19:25
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResTreeDto implements Serializable {
    private static final long serialVersionUID = 4793257934755848135L;

    @NotBlank(message = "应用代码不能为空")
    private String appCode;

    private Byte resStatus;

    private String empCode;
}
