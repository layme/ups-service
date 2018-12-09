package com.ziroom.ups.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_employee
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 2467318428691646553L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 逻辑id
     */
    private String fid;

    /**
     * 员工编号
     */
    private String empCode;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工性别
     */
    private Integer empSex;

    /**
     * 员工邮箱
     */
    private String empMail;

    /**
     * 手机号码
     */
    private String empMobile;

    /**
     * 是否有效 0有效 1无效
     */
    private Byte empValid;

    /**
     * 员工岗位code
     */
    private String postCode;

    /**
     * 员工岗位名称
     */
    private String postName;

    /**
     * 部门code
     */
    private String departCode;

    /**
     * 部门名称
     */
    private String departName;

    /**
     * 城市code
     */
    private String cityCode;

    /**
     * ehr系统城市代码
     */
    private String ehrCityCode;

    /**
     * 中心编码
     */
    private String centerCode;

    /**
     * 中心名称
     */
    private String center;

    /**
     * 组code
     */
    private String groupCode;

    /**
     * 组名称
     */
    private String groupName;

    /**
     * 分公司code
     */
    private String branceCompanyCode;

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