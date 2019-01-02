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
public class RoleSimListVo implements Serializable {
    private static final long serialVersionUID = -5041745412400580248L;

    /**
     * 角色FID
     */
    private String roleFid;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 应用名称
     */
    private String appName;
}
