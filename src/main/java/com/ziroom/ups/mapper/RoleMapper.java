package com.ziroom.ups.mapper;

import com.ziroom.ups.model.dto.RoleListDto;
import com.ziroom.ups.model.entity.RoleEntity;
import com.ziroom.ups.model.vo.RoleResListVo;
import com.ziroom.ups.model.vo.RoleSimListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * RoleMapper继承基类
 */
@Mapper
@Component
public interface RoleMapper {

    int insert(RoleEntity roleEntity);

    RoleEntity selectByFid(@Param("fid") String fid);

    int updateByFid(RoleEntity roleEntity);

    List<RoleResListVo> listPage(RoleListDto roleListDto);

    List<RoleSimListVo> listSimPage(RoleListDto roleListDto);
}