package com.ziroom.ups.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_application
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationEntity implements Serializable {
    private static final long serialVersionUID = 3894172370302215674L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 逻辑id
     */
    private String fid;

    /**
     * 应用编码
     */
    private String appCode;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用url
     */
    private String appUrl;

    /**
     * 应用描述
     */
    private String appDesc;

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