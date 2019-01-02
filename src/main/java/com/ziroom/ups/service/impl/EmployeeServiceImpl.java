package com.ziroom.ups.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ziroom.ups.mapper.EmployeeMapper;
import com.ziroom.ups.model.dto.EmpListDto;
import com.ziroom.ups.model.entity.EmployeeEntity;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @create 2019-01-01 18:11
 * Description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     *
     * @param empListDto
     * @return
     */
    @Override
    public PageRespVo<EmployeeEntity> listEmp(EmpListDto empListDto) {
        // 分页设置
        PageHelper.startPage(empListDto.getPage(), empListDto.getLimit());
        List<EmployeeEntity> employeeEntityList = this.employeeMapper.listPage(empListDto);

        // 获取分页结果
        PageInfo<EmployeeEntity> pageInfo = new PageInfo<>(employeeEntityList);

        // 填充结果信息
        PageRespVo<EmployeeEntity> pageRespVo = new PageRespVo<>();
        pageRespVo.setRows(pageInfo.getList());
        pageRespVo.setTotal(pageInfo.getTotal());

        return pageRespVo;
    }
}
