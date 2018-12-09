package com.ziroom.ups.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_role_resource
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleResourceEntity implements Serializable {
    private static final long serialVersionUID = -8885652286960684136L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色逻辑id
     */
    private String roleFid;

    /**
     * 功能资源逻辑id
     */
    private String resourceFid;

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