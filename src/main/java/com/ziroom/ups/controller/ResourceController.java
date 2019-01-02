package com.ziroom.ups.controller;

import com.google.common.collect.Lists;
import com.ziroom.ups.model.cons.Const;
import com.ziroom.ups.model.dto.*;
import com.ziroom.ups.model.entity.ResourceEntity;
import com.ziroom.ups.model.enums.IsUseStatusEnum;
import com.ziroom.ups.model.enums.ResTypeEnum;
import com.ziroom.ups.model.response.RestResult;
import com.ziroom.ups.model.response.RestResultGenerator;
import com.ziroom.ups.model.vo.MenuResVo;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.model.vo.ResTreeVo;
import com.ziroom.ups.service.ResourceService;
import com.ziroom.ups.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author
 * @create 2018-12-15 19:17
 * Description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    /**
     * 获取菜单树
     *
     * @param resTreeDto
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public RestResult<List<ResTreeVo>> queryResTree(@Valid ResTreeDto resTreeDto) {
        List<ResTreeVo> resList = this.resourceService.queryResTree(resTreeDto);
        return RestResultGenerator.genSuccessResult(this.preBuildTree(resList));
    }

    /**
     * 准备生成树
     *
     * @param resList
     * @return
     */
    private List<ResTreeVo> preBuildTree(List<ResTreeVo> resList) {
        Map<String, List<ResTreeVo>> resMap = resList.stream().collect(Collectors.groupingBy(ResTreeVo::getParentFid));
        List<ResTreeVo> resTreeVoList = resMap.get(Const.ROOT_RES_PARENT_FID);
        if (resTreeVoList != null && resTreeVoList.size() > 0) {
            resTreeVoList.forEach(x -> this.menuTreeBuilder(x, resMap));
        }
        return resTreeVoList == null ? Lists.newArrayList() : resTreeVoList;
    }

    /**
     * 生成菜单树
     *
     * @param resTreeVo
     * @param resMap
     */
    private void menuTreeBuilder(ResTreeVo resTreeVo, Map<String, List<ResTreeVo>> resMap) {
        List<ResTreeVo> treeVos = resMap.get(resTreeVo.getResFid());
        if (treeVos != null && treeVos.size() > 0) {
            resTreeVo.setChildrenList(
                    treeVos.stream().sorted(Comparator.comparing(ResTreeVo::getOrderNo)).collect(Collectors.toList())
            );
            resTreeVo.getChildrenList().forEach(x -> this.menuTreeBuilder(x, resMap));
        }
    }

    /**
     * 查询每级菜单明细
     *
     * @param resListDto
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RestResult<PageRespVo<ResourceEntity>> listRes(@Valid ResListDto resListDto) {
        return RestResultGenerator.genSuccessResult(this.resourceService.listRes(resListDto));
    }

    /**
     * 保存或更新资源
     *
     * @param resSaveOrUpDto
     * @return
     */
    @RequestMapping(value = "/saveOrUp", method = RequestMethod.POST)
    public RestResult saveOrUpRes(@Valid @RequestBody ResSaveOrUpDto resSaveOrUpDto) {
        ResourceEntity resourceEntity = ResourceEntity
                .builder()
                .appCode(resSaveOrUpDto.getAppCode())
                .resName(resSaveOrUpDto.getResName())
                .resPath(resSaveOrUpDto.getResPath())
                .orderNo(resSaveOrUpDto.getOrderNo())
                .resType(resSaveOrUpDto.getResType())
                .createFid("001")
                .modifyFid("001")
                .build();
        // 前端传来非空串才会存储
        if (!StringUtils.isEmpty(resSaveOrUpDto.getResIcon())) {
            resourceEntity.setResIcon(resSaveOrUpDto.getResIcon());
        }
        if (!StringUtils.isEmpty(resSaveOrUpDto.getParentFid())) {
            resourceEntity.setParentFid(resSaveOrUpDto.getParentFid());
        }
        int count;
        String message;
        if (StringUtils.isEmpty(resSaveOrUpDto.getFid())) {
            resourceEntity.setFid(Utils.genUUID());
            count = this.resourceService.saveRes(resourceEntity);
            message = "保存失败";

        } else {
            resourceEntity.setFid(resSaveOrUpDto.getFid());
            count = this.resourceService.updateRes(resourceEntity);
            message = "更新失败";

        }

        if (count == 1) {
            return RestResultGenerator.genSuccessResult(null);
        } else {
            return RestResultGenerator.genErrorResult(message);
        }
    }

    /**
     * 停用或启用资源
     *
     * @param resStopOrStartDto
     * @return
     */
    @RequestMapping(value = "/stopOrStart", method = RequestMethod.POST)
    public RestResult stopOrStartRes(@Valid @RequestBody ResStopOrStartDto resStopOrStartDto) {
        ResourceEntity resourceEntity = ResourceEntity
                .builder()
                .fid(resStopOrStartDto.getResFid())
                .modifyFid("001")
                .build();

        String message;
        if (IsUseStatusEnum.STOP.getCode().equals(resStopOrStartDto.getResStatus())) {
            resourceEntity.setResStatus(IsUseStatusEnum.START.getCode());
            message = "启用失败";
        } else {
            resourceEntity.setResStatus(IsUseStatusEnum.STOP.getCode());
            message = "停用失败";
        }
        int count = this.resourceService.stopOrStartRes(resourceEntity);

        if (count > 0) {
            return RestResultGenerator.genSuccessResult(null);
        } else {
            return RestResultGenerator.genErrorResult(message);
        }
    }

    /**
     * 对外提供资源列表
     *
     * @return
     */
    @RequestMapping(value = "/menuRes", method = RequestMethod.GET)
    public RestResult<MenuResVo> getMenuRes(@Valid MenuResDto menuResDto) {
        ResTreeDto resTreeDto = ResTreeDto
                .builder()
                .appCode(menuResDto.getAppCode())
                .resStatus(IsUseStatusEnum.START.getCode())
                .empCode(menuResDto.getEmpCode())
                .build();
        // 获取资源列表
        List<ResTreeVo> resList = this.resourceService.queryResTree(resTreeDto);
        // 筛选菜单列表
        List<ResTreeVo> menuList = resList.stream().filter(x -> ResTypeEnum.MENU.getCode().equals(x.getResType())).collect(Collectors.toList());
        // 筛选操作列表
        List<ResTreeVo> actionList = resList.stream().filter(x -> ResTypeEnum.ACTION.getCode().equals(x.getResType())).collect(Collectors.toList());

        return RestResultGenerator.genSuccessResult(
                MenuResVo
                        .builder()
                        .menuTree(this.preBuildTree(menuList))
                        .actionList(actionList)
                        .build()
        );

    }
}
