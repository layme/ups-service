package com.ziroom.ups.service;

import com.ziroom.ups.model.dto.RoleListDto;
import com.ziroom.ups.model.entity.RoleEntity;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.vo.RoleResListVo;
import com.ziroom.ups.model.vo.RoleSimListVo;

import javax.validation.constraints.NotBlank;

/**
 * @author
 * @create 2019-01-01 00:13
 * Description:
 */
public interface RoleService {
    /**
     *
     * @param roleListDto
     * @return
     */
    PageRespVo<RoleResListVo> listRole(RoleListDto roleListDto);

    int saveRole(RoleEntity roleEntity);

    int updateRole(RoleEntity roleEntity);

    int stopOrStartRole(RoleEntity roleEntity);

    PageRespVo<RoleSimListVo> listSimpleRole(RoleListDto roleListDto);
}
