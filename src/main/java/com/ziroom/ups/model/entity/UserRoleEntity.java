package com.ziroom.ups.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_user_role
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleEntity implements Serializable {
    private static final long serialVersionUID = -1174983981071435933L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 逻辑id
     */
    private String fid;

    /**
     * 系统用户逻辑id
     */
    private String userFid;

    /**
     * 角色逻辑id
     */
    private String roleFid;

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