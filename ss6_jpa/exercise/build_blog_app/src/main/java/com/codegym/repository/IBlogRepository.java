package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog", nativeQuery = true)
    List<Blog> findAllBlog();

    @Modifying
    @Query(value = "insert into blog(name_blog,content,create_day) value(:name_blog,:content,:create_day) ", nativeQuery = true)
    void save(@Param("name_blog") String nameBlog, @Param("content") String content, @Param("create_day") String createDay);

    @Query(value = " select  * from blog where id_blog = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Modifying
    @Query(value = "update blog set name_blog= :name_blog,content=:content, create_day =:create_day where id_blog =:id", nativeQuery = true)
    void update(@Param("name_blog") String nameBlog, @Param("content") String content, @Param("create_day") String createDay, @Param("id") Integer idBlog);

    @Modifying
    @Query(value = "delete from blog where id_blog =:id", nativeQuery = true)
    void remove(@Param("id") Integer idBlog);
}
