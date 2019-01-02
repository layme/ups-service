package com.ziroom.ups.service;

import com.ziroom.ups.model.dto.ResListDto;
import com.ziroom.ups.model.dto.ResTreeDto;
import com.ziroom.ups.model.entity.ResourceEntity;
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

    PageRespVo<ResourceEntity> listRes(ResListDto resListDto);

    int saveRes(ResourceEntity resourceEntity);

    int updateRes(ResourceEntity resourceEntity);

    int stopOrStartRes(ResourceEntity resourceEntity);
}
