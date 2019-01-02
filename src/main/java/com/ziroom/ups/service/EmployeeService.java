package com.ziroom.ups.service;

import com.ziroom.ups.model.dto.EmpListDto;
import com.ziroom.ups.model.entity.EmployeeEntity;
import com.ziroom.ups.model.vo.PageRespVo;

/**
 * @author
 * @create 2019-01-01 17:54
 * Description:
 */
public interface EmployeeService {
    PageRespVo<EmployeeEntity> listEmp(EmpListDto empListDto);
}
