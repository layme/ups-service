package com.ziroom.ups.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @create 2018-12-23 01:27
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResTreeVo extends TreeVo {
    private static final long serialVersionUID = -8218808588552686132L;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * 是否启用 0：否，1：是
     */
    private Byte resStatus;

    /**
     * 资源类型 1：菜单，2：操作
     */
    private Byte resType;
}
