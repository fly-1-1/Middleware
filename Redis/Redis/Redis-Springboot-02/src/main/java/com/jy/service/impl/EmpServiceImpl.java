package com.jy.service.impl;

import com.jy.entity.Emp;
import com.jy.mapper.EmpMapper;
import com.jy.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jy
 * @since 2024-06-10
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

}
