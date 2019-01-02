package com.ziroom.ups.controller;

import com.ziroom.ups.model.dto.AppDelDto;
import com.ziroom.ups.model.dto.AppListDto;
import com.ziroom.ups.model.dto.AppSaveOrUpDto;
import com.ziroom.ups.model.entity.ApplicationEntity;
import com.ziroom.ups.model.enums.IsDelEnum;
import com.ziroom.ups.model.response.RestResult;
import com.ziroom.ups.model.response.RestResultGenerator;
import com.ziroom.ups.model.vo.AppOptionsVo;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.service.ApplicationService;
import com.ziroom.ups.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 应用控制器
 * @author
 * @create 2018-12-15 19:17
 * Description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/application")
public class AppController {
    @Autowired
    private ApplicationService applicationService;

    /**
     * 分页查询应用
     * @param appListDto
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RestResult<PageRespVo<ApplicationEntity>> listApp(AppListDto appListDto) {
        return RestResultGenerator.genSuccessResult(this.applicationService.listApp(appListDto));
    }

    @RequestMapping(value = "/options", method = RequestMethod.GET)
    public RestResult<List<AppOptionsVo>> appOptions() {
        return RestResultGenerator.genSuccessResult(this.applicationService.listOptions());
    }

    /**
     * 保存/更新应用
     * @param appSaveOrUpDto
     * @return
     */
    @RequestMapping(value = "/saveOrUp", method = RequestMethod.POST)
    public RestResult saveOrUpApp(@Valid @RequestBody AppSaveOrUpDto appSaveOrUpDto) {
        ApplicationEntity applicationEntity = ApplicationEntity
                .builder()
                .appCode(appSaveOrUpDto.getAppCode())
                .appName(appSaveOrUpDto.getAppName())
                .appUrl(appSaveOrUpDto.getAppUrl())
                .createFid("001")
                .modifyFid("001")
                .build();
        int count;
        String message;
        if (StringUtils.isEmpty(appSaveOrUpDto.getFid())) {
            applicationEntity.setFid(Utils.genUUID());
            count = this.applicationService.saveApp(applicationEntity);
            message = "保存失败";
        } else {
            applicationEntity.setFid(appSaveOrUpDto.getFid());
            count = this.applicationService.updateApp(applicationEntity);
            message = "更新失败";
        }
        if (count == 1) {
            return RestResultGenerator.genSuccessResult(null);
        } else {
            return RestResultGenerator.genErrorResult(message);
        }
    }

    /**
     * 删除应用
     * @param appDelDto
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public RestResult delApp(@Valid @RequestBody AppDelDto appDelDto) {
        ApplicationEntity applicationEntity = ApplicationEntity
                .builder()
                .fid(appDelDto.getAppFid())
                .modifyFid("001")
                .isDel(IsDelEnum.YES.getCode())
                .build();
        Integer count = this.applicationService.updateApp(applicationEntity);
        if (count == 1) {
            return RestResultGenerator.genSuccessResult(null);
        } else {
            return RestResultGenerator.genErrorResult("删除失败");
        }
    }

}
