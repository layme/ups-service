package com.ziroom.ups.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 * @create 2018-12-23 01:27
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResTreeVo implements Serializable {
    private static final long serialVersionUID = -8218808588552686132L;
    /**
     * 逻辑id
     */
    private String resFid;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * 父级fid
     */
    private String parentFid;

    /**
     * 序号
     */
    private Integer orderNo;

    /**
     * 资源图标
     */
    private String resIcon;

    /**
     * 是否启用 0：否，1：是
     */
    private Byte resStatus;

    /**
     * 资源类型 1：菜单，2：操作
     */
    private Byte resType;

    /**
     * 子级资源列表
     */
    private List<ResTreeVo> childrenList;
}
