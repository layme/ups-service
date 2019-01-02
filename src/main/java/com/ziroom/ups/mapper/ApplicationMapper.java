package com.ziroom.ups.mapper;

import com.ziroom.ups.model.dto.AppListDto;
import com.ziroom.ups.model.entity.ApplicationEntity;
import com.ziroom.ups.model.vo.AppOptionsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ApplicationDao继承基类
 */
@Mapper
@Component
public interface ApplicationMapper {

    /**
     *
     * @param applicationEntity
     * @return
     */
    int insert(ApplicationEntity applicationEntity);

    /**
     *
     * @param fid
     * @return
     */
    ApplicationEntity selectByFid(@Param("fid") String fid);

    /**
     *
     * @param applicationEntity
     * @return
     */
    int updateByFid(ApplicationEntity applicationEntity);

    /**
     *
     * @param appListDto
     * @return
     */
    List<ApplicationEntity> listPage(AppListDto appListDto);

    /**
     * 应用下拉框
     * @return
     */
    List<AppOptionsVo> listOptions();

    /**
     *
     * @param appCode
     * @return
     */
    int isExistsByAppCode(@Param("appCode") String appCode);
}