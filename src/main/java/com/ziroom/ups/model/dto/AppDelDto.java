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
public class AppDelDto implements Serializable {
    private static final long serialVersionUID = -257829277273191103L;

    @NotBlank(message = "应用FID不能为空")
    private String appFid;
}
