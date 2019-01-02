package com.ziroom.ups.mapper;

import com.ziroom.ups.model.dto.RoleResDelDto;
import com.ziroom.ups.model.entity.RoleEntity;
import com.ziroom.ups.model.entity.RoleResourceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * RoleResourceMapper继承基类
 */
@Mapper
@Component
public interface RoleResourceMapper {

    int insert(RoleEntity roleEntity);

    int batchInsert(@Param("roleResList") List<RoleResourceEntity> roleResList);

    RoleEntity selectByFid(@Param("fid") String fid);

    int updateByFid(RoleEntity roleEntity);

    int delByRoleFid(RoleResDelDto roleResDelDto);

    List<String> listResFid(@Param("fid") String roleFid);
}