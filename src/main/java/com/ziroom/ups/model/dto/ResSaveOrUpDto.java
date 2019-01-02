package com.ziroom.ups.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author
 * @create 2018-12-29 10:15
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResSaveOrUpDto implements Serializable {
    private static final long serialVersionUID = 6864185646755383450L;

    /**
     * 逻辑id
     */
    private String fid;

    /**
     * 应用fid
     */
    @NotBlank(message = "应用代码不能为空")
    private String appCode;

    /**
     * 资源名称
     */
    @NotBlank(message = "资源名称不能为空")
    private String resName;

    /**
     * 资源路径
     */
    @NotBlank(message = "资源路径不能为空")
    private String resPath;

    /**
     * 父级fid
     */
    private String parentFid;

    /**
     * 序号
     */
    @NotNull(message = "资源排序不能为空")
    private Integer orderNo;

    /**
     * 资源图标
     */
    private String resIcon;

    /**
     * 资源类型 1：菜单，2：操作
     */
    @NotNull(message = "资源类型不能为空")
    private Byte resType;

    /**
     * 操作人
     */
    private String operator;
}
