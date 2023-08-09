package com.example.CozaStore.service.imp;

import com.example.CozaStore.entity.BlogEntity;
import com.example.CozaStore.payload.BlogMonthDTO;
import com.example.CozaStore.payload.PagingDTO;

import java.util.List;

public interface BlogServiceImp {
    PagingDTO getAllBlog(int page, int size);
    BlogEntity getBlogById(int id);
    PagingDTO getAllBlogByTagId(int id, int page,int size);
    BlogMonthDTO getNumberBlogByMonth();
}
