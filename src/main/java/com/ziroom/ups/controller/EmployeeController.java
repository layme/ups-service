package com.ziroom.ups.controller;

import com.ziroom.ups.model.dto.EmpListDto;
import com.ziroom.ups.model.entity.EmployeeEntity;
import com.ziroom.ups.model.response.RestResult;
import com.ziroom.ups.model.response.RestResultGenerator;
import com.ziroom.ups.model.vo.PageRespVo;
import com.ziroom.ups.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @create 2018-12-15 19:17
 * Description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询员工列表
     * @param userListDto
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RestResult<PageRespVo<EmployeeEntity>> listRes(EmpListDto userListDto) {
        return RestResultGenerator.genSuccessResult(this.employeeService.listEmp(userListDto));
    }
}
