package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.service.impl.EmpServiceA;
import com.example.utils.XmlParserUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
//    @RequestMapping("/listEmp")
//    public Result list(){
////        1.加载并解析emp.xml
//        String file =this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//       List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//
////       2.对数据进行处理 gender，job
//        empList.stream().forEach(emp ->{
////       1: 男, 2: 女
//                String gender=emp.getGender();
//                if("1".equals(gender)){
//                    emp.setGender("男");
//                }else if("2".equals(gender)){
//                    emp.setGender("女");
//                }
////        1: 讲师, 2: 班主任 , 3: 就业指导
//                String job=emp.getJob();
//                if("1".equals(job)){
//                    emp.setJob("讲师");
//                }else if("2".equals(job)){
//                    emp.setJob("班主任");
//                }else if("3".equals(job)){
//                    emp.setJob("就业指导");
//                }
//        });
////        响应数据
//        return Result.success(empList);


    @Resource //运行时，IOC容器会提供该类型的bean对象，并赋值给该变量-依赖注入
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list(){
//      调用service获取数据
        List<Emp> empList = empService.listEmp();
//      响应数据
        return Result.success(empList);
    }
}
