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
public class ResStopOrStartDto implements Serializable {
    private static final long serialVersionUID = 5687868920366261143L;

    @NotBlank(message = "资源FID不能为空")
    private String resFid;

    @NotNull(message = "资源状态不能为空")
    private Byte resStatus;
}
