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
public class MenuTreeVo extends TreeVo {
    private static final long serialVersionUID = -8218808588552686132L;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * 资源路径
     */
    private String resPath;

    /**
     * 资源图标
     */
    private String resIcon;

    /**
     * 资源类型 1：菜单，2：操作
     */
    private Byte resType;

}
