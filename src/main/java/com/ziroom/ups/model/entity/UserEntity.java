package com.ziroom.ups.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_user
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 95664230102874102L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 逻辑id
     */
    private String fid;

    /**
     * 用户名
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 关联员工id
     */
    private String employeeFid;

    /**
     * 是否管理员 0：否，1：是
     */
    private Byte isAdmin;

    /**
     * 用户状态 1：正常，0：停用
     */
    private Byte userStatus;

    /**
     * 国家code
     */
    private String nationCode;

    /**
     * 省份code
     */
    private String provinceCode;

    /**
     * 城市code
     */
    private String cityCode;

    /**
     * 区域code
     */
    private String areaCode;

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