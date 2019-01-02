package com.ziroom.ups.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ziroom.ups.mapper.UserMapper;
import com.ziroom.ups.model.dto.UserListDto;
import com.ziroom.ups.model.entity.UserEntity;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.vo.UserRoleListVo;
import com.ziroom.ups.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @create 2019-01-01 17:55
 * Description:
 */
@Service
public class UserServiceIMpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageRespVo<UserRoleListVo> listRole(UserListDto userListDto) {
        // 分页设置
        PageHelper.startPage(userListDto.getPage(), userListDto.getLimit());
        List<UserRoleListVo> userRoleList = this.userMapper.listPage(userListDto);

        // 获取分页结果
        PageInfo<UserRoleListVo> pageInfo = new PageInfo<>(userRoleList);

        // 填充结果信息
        PageRespVo<UserRoleListVo> pageRespVo = new PageRespVo<>();
        pageRespVo.setRows(pageInfo.getList());
        pageRespVo.setTotal(pageInfo.getTotal());

        return pageRespVo;
    }

    @Override
    public int saveUser(UserEntity userEntity) {
        return this.userMapper.insert(userEntity);
    }

    @Override
    public int updateUser(UserEntity userEntity) {
        return this.userMapper.updateByFid(userEntity);
    }

    @Override
    public int stopOrStartUser(UserEntity userEntity) {
        return this.userMapper.updateByFid(userEntity);
    }
}
