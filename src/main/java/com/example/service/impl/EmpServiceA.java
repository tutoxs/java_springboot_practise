package com.example.service.impl;

import com.example.dao.EmpDao;
import com.example.dao.impl.EmpDaoA;
import com.example.pojo.Emp;
import com.example.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component //将当前类交给IOC容器管理，成为IOC容器中的bean
public class EmpServiceA implements EmpService {
    @Resource
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
        //       2.对数据进行处理 gender，job
        empList.stream().forEach(emp ->{
//       1: 男, 2: 女
            String gender=emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }
//        1: 讲师, 2: 班主任 , 3: 就业指导
            String job=emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
