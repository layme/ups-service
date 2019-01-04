package com.ziroom.ups.service;

import com.ziroom.ups.model.dto.MenuResDto;
import com.ziroom.ups.model.dto.ResListDto;
import com.ziroom.ups.model.dto.ResTreeDto;
import com.ziroom.ups.model.entity.ResourceEntity;
import com.ziroom.ups.model.vo.MenuTreeVo;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.vo.ResTreeVo;

import java.util.List;

/**
 * @author
 * @create 2018-12-23 01:09
 * Description:
 */
public interface ResourceService {
    /**
     * 获取系统的资源列表
     * @param resTreeDto
     * @return
     */
    List<ResTreeVo> queryResTree(ResTreeDto resTreeDto);

    /**
     * 查询每级菜单明细
     * @param resListDto
     * @return
     */
    PageRespVo<ResourceEntity> listRes(ResListDto resListDto);

    /**
     * 保存资源
     * @param resourceEntity
     * @return
     */
    int saveRes(ResourceEntity resourceEntity);

    /**
     * 更新资源
     * @param resourceEntity
     * @return
     */
    int updateRes(ResourceEntity resourceEntity);

    /**
     * 禁用或启用资源
     * @param resourceEntity
     * @return
     */
    int stopOrStartRes(ResourceEntity resourceEntity);

    /**
     * 对外提供资源列表
     * @param menuResDto
     * @return
     */
    List<MenuTreeVo> queryMenuTree(MenuResDto menuResDto);
}
