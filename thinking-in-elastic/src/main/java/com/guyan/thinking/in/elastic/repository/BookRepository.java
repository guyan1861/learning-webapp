package com.guyan.thinking.in.elastic.repository;


import com.guyan.thinking.in.elastic.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: GuYan
 * @Time: 2022/7/10 13:53
 * @Description: 查询ES的持久层
 **/
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    /**
     * 按照特定的规律写接口才能够被识别，findModelByProperty,否则会报错！
     *
     * @param authorName
     * @param pageable
     * @return
     */
    Page<Book> findBookByAuthorName(String authorName, Pageable pageable);

    public List<Book> findBookByName(String name);

}
