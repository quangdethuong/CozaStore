package com.example.CozaStore.service;


import com.example.CozaStore.entity.BlogEntity;
import com.example.CozaStore.payload.BlogMonthDTO;
import com.example.CozaStore.payload.PagingDTO;
import com.example.CozaStore.repository.BlogRepository;
import com.example.CozaStore.service.imp.BlogServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;



@Service
public class BlogService implements BlogServiceImp {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public PagingDTO getAllBlog(int page,int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<BlogEntity> blogEntities = blogRepository.getBlogPaging(pageable);
        List<?> blogList = blogEntities.toList();
        return new PagingDTO(blogList,
                blogEntities.isLast(), blogEntities.getTotalPages(), blogEntities.getNumber());
    }

    @Override
    public BlogEntity getBlogById() {
        return null;
    }

    @Override
    public PagingDTO getAllBlogByTagId(int id, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<BlogEntity> blogEntities = blogRepository.getAllBlogByTagId(pageable,id);
        List<?> blogList = blogEntities.toList();
        return new PagingDTO(blogList,
                blogEntities.isLast(), blogEntities.getTotalPages(), blogEntities.getNumber());
    }

    @Override
    public BlogMonthDTO getNumberBlogByMonth() {
        List<BlogEntity> list = blogRepository.getAll();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (BlogEntity blogEntity : list) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(blogEntity.getCreateDate());
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR) ;
            String key = month + " " + year;
            hashMap.merge(key, 1, Integer::sum);
        }
        return new BlogMonthDTO(hashMap);
    }
}
