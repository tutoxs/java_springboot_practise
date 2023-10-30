package com.example.controller;

/*
测试响应数据
 */

import com.example.pojo.Address;
import com.example.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseControl {
//    @RequestMapping("hello")
//    public String hello(){
//       System.out.println("hello");
//       return  "ok";
//    }

    @RequestMapping("hello")
    public Result hello(){
       System.out.println("hello");
//       return  new Result(1,"success","ok");
       return  Result.success("ok");
    }

//    @RequestMapping("/getAdd")
//    public Address getAddr (){
//        Address addr = new Address();
//        addr.setProvince("广州");
//        addr.setCity("深圳");
//        return addr;
//    }

    @RequestMapping("/getAdd")
    public Result getAddr (){
        Address addr=new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return Result.success(addr);
    }
//
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr() {
//        List<Address> list = new ArrayList<>();
//        Address addr = new Address();
//        addr.setProvince("广州");
//        addr.setCity("深圳");
//
//        Address addr2 = new Address();
//        addr2.setProvince("山西");
//        addr2.setCity("陕西");
//
//        list.add(addr);
//        list.add(addr2);
//
//        return list;
//    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> list =new ArrayList<>();
        Address addr=new Address();
        addr.setProvince("广州");
        addr.setCity("深圳");

        Address addr2 = new Address();
        addr2.setProvince("山西");
        addr2.setCity("陕西");

        list.add(addr);
        list.add(addr2);

        return Result.success(list);
    }

}
