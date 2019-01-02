package com.ziroom.ups.service;

import com.ziroom.ups.model.dto.UserRoleDelDto;
import com.ziroom.ups.model.entity.UserRoleEntity;

import java.util.List;

/**
 * @author
 * @create 2019-01-02 09:29
 * Description:
 */
public interface UserRoleService {
    /**
     *
     * @param userRoleDelDto
     * @param userRoleList
     * @return
     */
    int updateRoleRes(UserRoleDelDto userRoleDelDto, List<UserRoleEntity> userRoleList);

}
