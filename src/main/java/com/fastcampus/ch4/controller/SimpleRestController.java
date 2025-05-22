package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimpleRestController {
/*    @GetMapping("/ajax")
    public String ajax() {
        return "ajax";
    }  */

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/send")
    @ResponseBody
    public Person test(@RequestBody Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }
}

/*@RestController
public class SimpleRestController {
    @GetMapping("/ajax")
    public String ajax() {
        return "ajax";
    }

    @PostMapping("/send")
    //@ResponseBody
    public Person test(@RequestBody Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }
    @PostMapping("/send")
    //@ResponseBody
    public Person test2(@RequestBody Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }
}*/

