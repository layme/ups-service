package com.ziroom.ups.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author
 * @create 2018-12-31 17:07
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppOptionsVo implements Serializable {
    private static final long serialVersionUID = 5639015680956033633L;

    private String appCode;

    private String appName;
}
