package com.jk.feign.controller;

import com.jk.entity.BookBean;
import com.jk.feign.service.BookServiceFeign;
import com.jk.utils.Constant;
import com.jk.utils.RedisUtil;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("book")
public class BookController {

    @Resource
    private BookServiceFeign bookServiceFeign;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("queryBookList")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "save")
    public List<BookBean> queryBookList(){
        List<BookBean> bookBeans = (List<BookBean>) redisUtil.get(Constant.SELECT_USER_LIST);
        if (bookBeans == null || bookBeans.size()<= 0 || bookBeans.isEmpty()){
            bookBeans = bookServiceFeign.queyBookList();
            redisUtil.set(Constant.SELECT_USER_LIST,bookBeans,30);
        }
        return bookBeans;
    }

    private Object save(){
        Map map = new HashMap();
        map.put("code",1);
        map.put("msg","人多被挤出来了");
        return map;
    }
}
