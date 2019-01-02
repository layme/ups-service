package com.ziroom.ups.service.impl;

import com.ziroom.ups.mapper.RoleResourceMapper;
import com.ziroom.ups.model.dto.RoleResDelDto;
import com.ziroom.ups.model.entity.RoleResourceEntity;
import com.ziroom.ups.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 * @create 2019-01-01 10:28
 * Description:
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService {
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    /**
     * 批量覆盖更新角色资源关系
     * @param roleResDelDto
     * @param roleResList
     * @return
     */
    @Override
    @Transactional
    public int updateRoleRes(RoleResDelDto roleResDelDto, List<RoleResourceEntity> roleResList) {
        this.roleResourceMapper.delByRoleFid(roleResDelDto);
        int count = 0;
        if (roleResList.size() > 0) {
            count = this.roleResourceMapper.batchInsert(roleResList);
        }
        return count;
    }
}
