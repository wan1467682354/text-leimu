package com.jk.provider.service;

import com.jk.entity.BookBean;
import com.jk.feign.service.BookServiceFeign;
import com.jk.provider.mapper.BookMapper;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookServiceImpl implements BookServiceFeign {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<BookBean> queyBookList() {
        return bookMapper.queryBookList();
    }
}
