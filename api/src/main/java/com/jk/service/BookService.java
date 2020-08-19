package com.jk.service;

import com.jk.entity.BookBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public interface BookService {

    @RequestMapping("queryBookList")
    @ResponseBody
    List<BookBean> queyBookList();
}
