package com.ziroom.ups.mapper;

import com.ziroom.ups.model.dto.UserListDto;
import com.ziroom.ups.model.entity.UserEntity;
import com.ziroom.ups.model.vo.UserRoleListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * UserMapper继承基类
 */
@Mapper
@Component
public interface UserMapper {

    int insert(UserEntity userEntity);

    UserEntity selectByFid(@Param("fid") String fid);

    int updateByFid(UserEntity record);

    List<UserRoleListVo> listPage(UserListDto userListDto);
}