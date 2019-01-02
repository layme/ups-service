package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @create 2019-01-01 00:17
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpListDto extends PageDto {
    private static final long serialVersionUID = -229857641239712456L;

    private String empCode;

    private String empName;

    /**
     * 是否有效 0有效 1无效
     */
    private Byte empValid;
}
