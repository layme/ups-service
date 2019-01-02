package com.ziroom.ups.controller;

import com.google.common.collect.Lists;
import com.ziroom.ups.model.dto.*;
import com.ziroom.ups.model.entity.UserEntity;
import com.ziroom.ups.model.entity.UserRoleEntity;
import com.ziroom.ups.model.enums.IsUseStatusEnum;
import com.ziroom.ups.model.response.RestResult;
import com.ziroom.ups.model.response.RestResultGenerator;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.vo.UserRoleListVo;
import com.ziroom.ups.service.UserRoleService;
import com.ziroom.ups.service.UserService;
import com.ziroom.ups.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author
 * @create 2018-12-15 19:17
 * Description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 查询用户列表
     * @param userListDto
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RestResult<PageRespVo<UserRoleListVo>> listRes(UserListDto userListDto) {
        return RestResultGenerator.genSuccessResult(this.userService.listRole(userListDto));
    }

    /**
     * 保存或更新用户
     * @param userSaveOrUpDto
     * @return
     */
    @RequestMapping(value = "/saveOrUp", method = RequestMethod.POST)
    public RestResult saveOrUpRole(@Valid @RequestBody UserSaveOrUpDto userSaveOrUpDto) {
        UserEntity userEntity = UserEntity
                .builder()
                .account(userSaveOrUpDto.getAccount())
                .employeeFid(userSaveOrUpDto.getEmployeeFid())
                .createFid("001")
                .modifyFid("001")
                .build();

        int count;
        String message;
        if (StringUtils.isEmpty(userSaveOrUpDto.getFid())) {
            userEntity.setFid(Utils.genUUID());
            count = this.userService.saveUser(userEntity);
            message = "保存失败";
        } else {
            userEntity.setFid(userSaveOrUpDto.getFid());
            count = this.userService.updateUser(userEntity);
            message = "更新失败";
        }

        if (count == 1) {
            // 更新用户的角色
            this.updateUserRole(userEntity.getFid(), userSaveOrUpDto.getRoleList());
            return RestResultGenerator.genSuccessResult(null);
        } else {
            return RestResultGenerator.genErrorResult(message);
        }
    }

    /**
     * 更新用户的角色
     * @param userFid
     * @param roleList
     */
    private void updateUserRole(String userFid, List<UserRoleDto> roleList) {
        List<UserRoleEntity> userRoleList = Lists.newArrayList();
        roleList.forEach(x ->
                userRoleList.add(
                        UserRoleEntity
                        .builder()
                        .fid(Utils.genUUID())
                        .userFid(userFid)
                        .roleFid(x.getRoleFid())
                        .createFid("001")
                        .modifyFid("001")
                        .build()
                )
        );
        this.userRoleService.updateRoleRes(UserRoleDelDto.builder().userFid(userFid).operator("001").build(), userRoleList);
    }

    /**
     * 停用或启用用户
     * @param userStopOrStartDto
     * @return
     */
    @RequestMapping(value = "/stopOrStart", method = RequestMethod.POST)
    public RestResult stopOrStartRes(@Valid @RequestBody UserStopOrStartDto userStopOrStartDto) {
        UserEntity userEntity = UserEntity
                .builder()
                .fid(userStopOrStartDto.getUserFid())
                .modifyFid("001")
                .build();

        String message;
        if (IsUseStatusEnum.STOP.getCode().equals(userStopOrStartDto.getUserStatus())) {
            userEntity.setUserStatus(IsUseStatusEnum.START.getCode());
            message = "启用失败";
        } else {
            userEntity.setUserStatus(IsUseStatusEnum.STOP.getCode());
            message = "停用失败";
        }
        int count = this.userService.stopOrStartUser(userEntity);

        if (count > 0) {
            return RestResultGenerator.genSuccessResult(null);
        } else {
            return RestResultGenerator.genErrorResult(message);
        }
    }
}
