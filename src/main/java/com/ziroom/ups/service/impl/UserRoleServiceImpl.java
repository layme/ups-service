package com.ziroom.ups.service.impl;

import com.ziroom.ups.mapper.UserRoleMapper;
import com.ziroom.ups.model.dto.UserRoleDelDto;
import com.ziroom.ups.model.entity.UserRoleEntity;
import com.ziroom.ups.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 * @create 2019-01-02 09:30
 * Description:
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public int updateRoleRes(UserRoleDelDto userRoleDelDto, List<UserRoleEntity> userRoleList) {
        this.userRoleMapper.delByUserFid(userRoleDelDto);
        int count = 0;
        if (userRoleList.size() > 0) {
            count = this.userRoleMapper.batchInsert(userRoleList);
        }
        return count;
    }
}
