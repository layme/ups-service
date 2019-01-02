package com.ziroom.ups.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author
 * @create 2019-01-01 10:52
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleResListVo implements Serializable {
    private static final long serialVersionUID = 8858871416064030893L;

    /**
     * 角色FID
     */
    private String roleFid;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 应用代码
     */
    private String appCode;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 资源列表
     */
    private List<String> resList;

    /**
     * 角色状态
     */
    private Byte roleStatus;

    /**
     * 修改时间
     */
    private LocalDateTime modifyDate;
}
