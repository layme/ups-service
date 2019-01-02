package com.ziroom.ups.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ziroom.ups.exception.DataException;
import com.ziroom.ups.mapper.ApplicationMapper;
import com.ziroom.ups.model.vo.AppOptionsVo;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.dto.AppListDto;
import com.ziroom.ups.model.entity.ApplicationEntity;
import com.ziroom.ups.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @create 2018-12-15 20:15
 * Description:
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public PageRespVo<ApplicationEntity> listApp(AppListDto appListDto) {
        // 分页设置
        PageHelper.startPage(appListDto.getPage(), appListDto.getLimit());
        List<ApplicationEntity> applicationEntities = this.applicationMapper.listPage(appListDto);

        // 获取分页结果
        PageInfo<ApplicationEntity> pageInfo = new PageInfo<>(applicationEntities);

        // 填充结果信息
        PageRespVo<ApplicationEntity> pageRespVo = new PageRespVo<>();
        pageRespVo.setRows(pageInfo.getList());
        pageRespVo.setTotal(pageInfo.getTotal());

        return pageRespVo;
    }

    @Override
    public int saveApp(ApplicationEntity applicationEntity) {
        int count = this.applicationMapper.isExistsByAppCode(applicationEntity.getAppCode());
        if (count > 0) {
            throw new DataException("应用已存在");
        }
        return this.applicationMapper.insert(applicationEntity);
    }

    @Override
    public Integer updateApp(ApplicationEntity applicationEntity) {
        return this.applicationMapper.updateByFid(applicationEntity);
    }

    @Override
    public List<AppOptionsVo> listOptions() {
        return this.applicationMapper.listOptions();
    }
}
