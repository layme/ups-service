package com.ziroom.ups.service;

import com.ziroom.ups.model.vo.AppOptionsVo;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.dto.AppListDto;
import com.ziroom.ups.model.entity.ApplicationEntity;

import java.util.List;

/**
 * @author
 * @create 2018-12-15 20:06
 * Description:
 */
public interface ApplicationService {
    /**
     * 分页查询应用
     * @param appListDto
     * @return
     */
    PageRespVo<ApplicationEntity> listApp(AppListDto appListDto);

    /**
     * 保存应用
     * @param applicationEntity
     * @return
     */
    int saveApp(ApplicationEntity applicationEntity);

    /**
     * 更新应用
     * @param applicationEntity
     * @return
     */
    Integer updateApp(ApplicationEntity applicationEntity);

    List<AppOptionsVo> listOptions();
}
