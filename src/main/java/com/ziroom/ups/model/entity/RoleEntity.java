package com.ziroom.ups.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_role
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = -2497330427416627260L;

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
     * 角色名称
     */
    private String roleName;

    /**
     * 角色类型，0:普通角色，1：数据区域角色，2：区域角色，3：数据角色
     */
    private Byte roleType;

    /**
     * 角色描述
     */
    private String roleDesc;

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