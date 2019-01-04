package com.ziroom.ups.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 * @create 2019-01-01 15:10
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuResVo implements Serializable {
    private static final long serialVersionUID = 549284953263086324L;

    /**
     * 菜单树
     */
    private List<TreeVo> menuTree;

    /**
     * 操作资源列表
     */
    private List<String> actionList;
}
