package com.jk.feign.service;

import com.jk.entity.BookBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceFallBack  implements BookServiceFeign {

    @Override
    public List<BookBean> queyBookList() {
        return null;
    }
}
