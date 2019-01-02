package com.ziroom.ups.service;

import com.ziroom.ups.model.dto.UserListDto;
import com.ziroom.ups.model.entity.UserEntity;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.vo.UserRoleListVo;

/**
 * @author
 * @create 2019-01-01 17:54
 * Description:
 */
public interface UserService {
    PageRespVo<UserRoleListVo> listRole(UserListDto userListDto);

    int saveUser(UserEntity userEntity);

    int updateUser(UserEntity userEntity);

    int stopOrStartUser(UserEntity userEntity);
}
