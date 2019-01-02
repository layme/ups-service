package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @create 2018-12-15 19:25
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppListDto extends PageDto {
    private static final long serialVersionUID = -1843062103518003070L;

    /**
     * 应用编码
     */
    private String appCode;
}
