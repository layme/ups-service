package com.ziroom.ups.mapper;

import com.ziroom.ups.model.dto.MenuResDto;
import com.ziroom.ups.model.dto.ResListDto;
import com.ziroom.ups.model.dto.ResTreeDto;
import com.ziroom.ups.model.entity.ResourceEntity;
import com.ziroom.ups.model.vo.MenuTreeVo;
import com.ziroom.ups.model.vo.ResTreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ResourceMapper继承基类
 */
@Mapper
@Component
public interface ResourceMapper {

    int insert(ResourceEntity record);

    ResourceEntity selectByFid(@Param("fid") String fid);

    int updateByFid(ResourceEntity record);

    List<ResTreeVo> queryResTree(ResTreeDto resTreeDto);

    List<ResourceEntity> listPage(ResListDto resListDto);

    int updateByParentFid(ResourceEntity resourceEntity);

    List<MenuTreeVo> queryMenuTree(MenuResDto menuResDto);
}