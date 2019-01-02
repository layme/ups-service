package com.ziroom.ups.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 * @create 2019-01-02 09:43
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleListVo implements Serializable {
    private static final long serialVersionUID = 4511424102326004951L;

    /**
     * 逻辑id
     */
    private String fid;

    /**
     * 关联员工id
     */
    private String employeeFid;

    /**
     * 用户名
     */
    private String account;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 角色列表
     */
    private List<RoleSimListVo> roleList;

    /**
     * 员工岗位名称
     */
    private String postName;

    /**
     * 部门名称
     */
    private String departName;

    /**
     * 用户状态 1：正常，0：停用
     */
    private Byte userStatus;

    /**
     * 是否有效 0有效 1无效
     */
    private Byte empValid;
}
