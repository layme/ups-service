package com.ziroom.ups.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ziroom.ups.mapper.ResourceMapper;
import com.ziroom.ups.model.dto.ResListDto;
import com.ziroom.ups.model.dto.ResTreeDto;
import com.ziroom.ups.model.entity.ResourceEntity;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.vo.ResTreeVo;
import com.ziroom.ups.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @create 2018-12-23 01:10
 * Description:
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 查询菜单树
     * @param resTreeDto
     * @return
     */
    @Override
    public List<ResTreeVo> queryResTree(ResTreeDto resTreeDto) {
        return this.resourceMapper.queryResTree(resTreeDto);
    }

    /**
     * 查询每级菜单明细
     * @param resListDto
     * @return
     */
    @Override
    public PageRespVo<ResourceEntity> listRes(ResListDto resListDto) {
        // 分页设置
        PageHelper.startPage(resListDto.getPage(), resListDto.getLimit());
        List<ResourceEntity> resourceEntityList = this.resourceMapper.listPage(resListDto);

        // 获取分页结果
        PageInfo<ResourceEntity> pageInfo = new PageInfo<>(resourceEntityList);

        // 填充结果信息
        PageRespVo<ResourceEntity> pageRespVo = new PageRespVo<>();
        pageRespVo.setRows(pageInfo.getList());
        pageRespVo.setTotal(pageInfo.getTotal());

        return pageRespVo;
    }

    /**
     * 保存资源
     * @param resourceEntity
     * @return
     */
    @Override
    public int saveRes(ResourceEntity resourceEntity) {
        return this.resourceMapper.insert(resourceEntity);
    }

    /**
     * 更新资源
     * @param resourceEntity
     * @return
     */
    @Override
    public int updateRes(ResourceEntity resourceEntity) {
        return this.resourceMapper.updateByFid(resourceEntity);
    }

    /**
     * 禁用或启用资源
     * @param resourceEntity
     * @return
     */
    @Override
    public int stopOrStartRes(ResourceEntity resourceEntity) {
        int count = this.resourceMapper.updateByFid(resourceEntity);
        resourceEntity.setParentFid(resourceEntity.getFid());
        resourceEntity.setFid(null);
        count += this.resourceMapper.updateByParentFid(resourceEntity);
        return 0;
    }
}
