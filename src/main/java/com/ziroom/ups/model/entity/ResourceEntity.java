package com.ziroom.ups.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_resource
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceEntity implements Serializable {
    private static final long serialVersionUID = 7770481791558261534L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 逻辑id
     */
    private String fid;

    /**
     * 应用fid
     */
    private String applicationFid;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * 资源图标
     */
    private String resIcon;

    /**
     * 资源路径
     */
    private String resPath;

    /**
     * 是否叶子节点 0：否，1：是
     */
    private Byte isLeaf;

    /**
     * 序号
     */
    private Integer orderNo;

    /**
     * 是否启用 0：否，1：是
     */
    private Byte resState;

    /**
     * 父级fid
     */
    private String parentFid;

    /**
     * 资源类型 1：菜单，2：操作
     */
    private Byte resType;

    /**
     * 是否删除 0：否，1：是
     */
    private Byte isDel;

    /**
     * 添加时间
     */
    private LocalDateTime createDate;

    /**
     * 创建人fid
     */
    private String createFid;

    /**
     * 修改时间
     */
    private LocalDateTime modifyDate;

    /**
     * 修改人fid
     */
    private String modifyFid;
}