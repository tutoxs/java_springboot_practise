package com.example.dao.impl;

import com.example.dao.EmpDao;
import com.example.pojo.Emp;
import com.example.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component //将当前类交给IOC容器管理，成为IOC容器中的bean
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //        1.加载并解析emp.xml
        String file =this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
