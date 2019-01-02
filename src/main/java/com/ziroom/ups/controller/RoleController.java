package com.ziroom.ups.controller;

import com.google.common.collect.Lists;
import com.ziroom.ups.model.dto.RoleListDto;
import com.ziroom.ups.model.dto.RoleResDelDto;
import com.ziroom.ups.model.dto.RoleSaveOrUpDto;
import com.ziroom.ups.model.dto.RoleStopOrStartDto;
import com.ziroom.ups.model.entity.ResourceEntity;
import com.ziroom.ups.model.entity.RoleEntity;
import com.ziroom.ups.model.entity.RoleResourceEntity;
import com.ziroom.ups.model.enums.IsUseStatusEnum;
import com.ziroom.ups.model.response.RestResult;
import com.ziroom.ups.model.response.RestResultGenerator;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.vo.RoleResListVo;
import com.ziroom.ups.model.vo.RoleSimListVo;
import com.ziroom.ups.service.RoleResourceService;
import com.ziroom.ups.service.RoleService;
import com.ziroom.ups.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @create 2018-12-15 19:17
 * Description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleResourceService roleResourceService;

    /**
     * @param roleListDto
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RestResult<PageRespVo<RoleResListVo>> listRoleRes(RoleListDto roleListDto) {
        return RestResultGenerator.genSuccessResult(this.roleService.listRole(roleListDto));
    }

    /**
     *
     * @param roleListDto
     * @return
     */
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    public RestResult<PageRespVo<RoleSimListVo>> listRole(RoleListDto roleListDto) {
        return RestResultGenerator.genSuccessResult(this.roleService.listSimpleRole(roleListDto));
    }

    /**
     * 保存或更新资源
     *
     * @param roleSaveOrUpDto
     * @return
     */
    @RequestMapping(value = "/saveOrUp", method = RequestMethod.POST)
    public RestResult saveOrUpRole(@Valid @RequestBody RoleSaveOrUpDto roleSaveOrUpDto) {
        RoleEntity roleEntity = RoleEntity
                .builder()
                .appCode(roleSaveOrUpDto.getAppCode())
                .roleName(roleSaveOrUpDto.getRoleName())
                .roleDesc(roleSaveOrUpDto.getRoleDesc())
                .createFid("001")
                .modifyFid("001")
                .build();

        int count;
        String message;
        if (StringUtils.isEmpty(roleSaveOrUpDto.getFid())) {
            roleEntity.setFid(Utils.genUUID());
            count = this.roleService.saveRole(roleEntity);
            message = "保存失败";
        } else {
            roleEntity.setFid(roleSaveOrUpDto.getFid());
            count = this.roleService.updateRole(roleEntity);
            message = "更新失败";
        }

        if (count == 1) {
            // 更新角色的资源
            this.updateRoleRes(roleEntity.getFid(), roleSaveOrUpDto.getResList());
            return RestResultGenerator.genSuccessResult(null);
        } else {
            return RestResultGenerator.genErrorResult(message);
        }
    }

    /**
     * 更新角色资源
     * @param roleFid
     * @param resList
     */
    private void updateRoleRes(String roleFid, List<String> resList) {
        List<RoleResourceEntity> roleResList = Lists.newArrayList();
        resList.forEach(x ->
                roleResList.add(
                        RoleResourceEntity.builder()
                                .fid(Utils.genUUID())
                                .roleFid(roleFid)
                                .resourceFid(x)
                                .createFid("001")
                                .modifyFid("001")
                                .build()
                )
        );
        this.roleResourceService.updateRoleRes(RoleResDelDto.builder().roleFid(roleFid).operator("001").build(), roleResList);
    }

    /**
     * 停用或启用资源
     * @param roleStopOrStartDto
     * @return
     */
    @RequestMapping(value = "/stopOrStart", method = RequestMethod.POST)
    public RestResult stopOrStartRes(@Valid @RequestBody RoleStopOrStartDto roleStopOrStartDto) {
        RoleEntity roleEntity = RoleEntity
                .builder()
                .fid(roleStopOrStartDto.getRoleFid())
                .modifyFid("001")
                .build();

        String message;
        if (IsUseStatusEnum.STOP.getCode().equals(roleStopOrStartDto.getRoleStatus())) {
            roleEntity.setRoleStatus(IsUseStatusEnum.START.getCode());
            message = "启用失败";
        } else {
            roleEntity.setRoleStatus(IsUseStatusEnum.STOP.getCode());
            message = "停用失败";
        }
        int count = this.roleService.stopOrStartRole(roleEntity);

        if (count > 0) {
            return RestResultGenerator.genSuccessResult(null);
        } else {
            return RestResultGenerator.genErrorResult(message);
        }
    }

}
