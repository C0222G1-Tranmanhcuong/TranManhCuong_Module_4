package com.codegym.ss11_blog_app.service.imp;


import com.codegym.ss11_blog_app.model.Blog;
import com.codegym.ss11_blog_app.model.Category;
import com.codegym.ss11_blog_app.repository.IBlogRepository;
import com.codegym.ss11_blog_app.repository.ICategoryRepository;
import com.codegym.ss11_blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAllBlog();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog.getNameBlog(), blog.getContent(), blog.getCreateday(), blog.getIdBlog(), blog.getCategory().getId());
    }

    @Override
    public void remove(int id) {
        iBlogRepository.remove(id);
    }

    @Override
    public List<Category> categoryList() {
        return null;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Blog> searchByName(String name, Pageable pageable) {
        return null;
    }

}
