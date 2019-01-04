package com.ziroom.ups.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author renhy
 * @version 1.0
 * @Date Created in 2019年01月04日 14:49
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeVo implements Serializable {
    private static final long serialVersionUID = -821880858855268613L;
    
    /**
     * 逻辑id
     */
    private String resFid;

    /**
     * 父级fid
     */
    private String parentFid;

    /**
     * 序号
     */
    private Integer orderNo;

    /**
     * 子级资源列表
     */
    private List<TreeVo> childrenList;
}
