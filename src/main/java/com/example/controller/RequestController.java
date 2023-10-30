package com.example.controller;
import com.example.pojo.User;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {
    //原始方式
//    @RequestMapping("/requestDemos")
//    public String requestDemos(HttpServletRequest request) {
//        String name=request.getParameter("name");
//        int age=Integer.parseInt(request.getParameter("age"));
//        System.out.println("他叫"+name+"今年"+age+"岁了");
//        return "他叫"+name+"今年"+age+"岁了";
//    }

//    springboot方式
    @RequestMapping("/requestDemos")
    public String requestDemos(@RequestParam(name="name",required = false) String username, Number age) {
        System.out.println("他叫" + username + "今年" + age + "岁了");
        return "他叫" + username + "今年" + age + "岁了";
    }

//    实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo (User user){
       System.out.println(user);
        return "ok";
    }
//  复杂实体参数
    @RequestMapping("/complexPojo")
    public int complexPojo (User user){
        System.out.println(user);
        return 1;
    }
    //  数组集合参数
    @RequestMapping("/arrayParam")
    public String arrayParam (String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }

    //  数组集合参数
    @RequestMapping("/listParam")
    public String listParam (@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "ok";
    }

    //  日期参数
    @RequestMapping("/dateParam")
    public String dateParam (@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "ok";
    }

    //    JSON格式参数
    @RequestMapping("/jsonParams")
    public String jsonParams(@RequestBody User user){
        System.out.println(user);
        return "ok";
    }

    //    路径参数
    @RequestMapping("/pathParam/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "ok"+id;
    }

    //    多个路径参数
    @RequestMapping("/pathParams/{id}/{name}")
    public String pathParams(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "ok"+id+name;
    }
}
