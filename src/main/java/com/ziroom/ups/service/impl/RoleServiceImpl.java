package com.ziroom.ups.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ziroom.ups.mapper.RoleMapper;
import com.ziroom.ups.model.dto.RoleListDto;
import com.ziroom.ups.model.entity.RoleEntity;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.vo.RoleResListVo;
import com.ziroom.ups.model.vo.RoleSimListVo;
import com.ziroom.ups.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author
 * @create 2019-01-01 00:13
 * Description:
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     *
     * @param roleListDto
     * @return
     */
    @Override
    public PageRespVo<RoleResListVo> listRole(RoleListDto roleListDto) {
        // 分页设置
        PageHelper.startPage(roleListDto.getPage(), roleListDto.getLimit());
        List<RoleResListVo> roleResListVoList = this.roleMapper.listPage(roleListDto);

        // 获取分页结果
        PageInfo<RoleResListVo> pageInfo = new PageInfo<>(roleResListVoList);

        // 填充结果信息
        PageRespVo<RoleResListVo> pageRespVo = new PageRespVo<>();
        pageRespVo.setRows(pageInfo.getList());
        pageRespVo.setTotal(pageInfo.getTotal());

        return pageRespVo;
    }

    @Override
    public int saveRole(RoleEntity roleEntity) {
        return this.roleMapper.insert(roleEntity);
    }

    @Override
    public int updateRole(RoleEntity roleEntity) {
        return this.roleMapper.updateByFid(roleEntity);
    }

    @Override
    public int stopOrStartRole(RoleEntity roleEntity) {
        return this.roleMapper.updateByFid(roleEntity);
    }

    @Override
    public PageRespVo<RoleSimListVo> listSimpleRole(RoleListDto roleListDto) {
        // 分页设置
        PageHelper.startPage(roleListDto.getPage(), roleListDto.getLimit());
        List<RoleSimListVo> roleResListVoList = this.roleMapper.listSimPage(roleListDto);

        // 获取分页结果
        PageInfo<RoleSimListVo> pageInfo = new PageInfo<>(roleResListVoList);

        // 填充结果信息
        PageRespVo<RoleSimListVo> pageRespVo = new PageRespVo<>();
        pageRespVo.setRows(pageInfo.getList());
        pageRespVo.setTotal(pageInfo.getTotal());

        return pageRespVo;
    }
}
