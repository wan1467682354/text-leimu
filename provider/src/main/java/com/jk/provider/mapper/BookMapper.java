package com.jk.provider.mapper;

import com.jk.entity.BookBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select(" select * from t_book_wjy ")
    List<BookBean> queryBookList();
}
