package com.ziroom.ups.service;

import com.ziroom.ups.model.dto.RoleResDelDto;
import com.ziroom.ups.model.entity.ResourceEntity;
import com.ziroom.ups.model.entity.RoleResourceEntity;

import java.util.List;

/**
 * @author
 * @create 2019-01-01 10:27
 * Description:
 */
public interface RoleResourceService {
    /**
     *
     * @param roleResDelDto
     * @param roleResList
     * @return
     */
    int updateRoleRes(RoleResDelDto roleResDelDto, List<RoleResourceEntity> roleResList);
}
