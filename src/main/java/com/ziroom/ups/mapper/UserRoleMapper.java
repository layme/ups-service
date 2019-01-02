package com.ziroom.ups.mapper;

import com.ziroom.ups.model.dto.UserRoleDelDto;
import com.ziroom.ups.model.entity.UserRoleEntity;
import com.ziroom.ups.model.vo.RoleSimListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * UserRoleMapper继承基类
 */
@Mapper
@Component
public interface UserRoleMapper {

    int insert(UserRoleEntity userRoleEntity);

    int batchInsert(@Param("userRoleList") List<UserRoleEntity> userRoleList);

    UserRoleEntity selectByFid(@Param("fid") String fid);

    int updateByFid(UserRoleEntity userRoleEntity);

    int delByUserFid(UserRoleDelDto userRoleDelDto);

    List<RoleSimListVo> listRoleFid(@Param("fid") String fid);
}