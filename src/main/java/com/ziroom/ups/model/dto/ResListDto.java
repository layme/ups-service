package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author
 * @create 2018-12-15 19:25
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResListDto extends PageDto {
    private static final long serialVersionUID = -8362507777867374185L;

    /**
     * 父级资源标识
     */
    @NotBlank(message = "父级FID不能为空")
    private String parentFid;
}
