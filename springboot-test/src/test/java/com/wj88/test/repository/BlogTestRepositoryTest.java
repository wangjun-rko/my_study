package com.wj88.test.repository;


import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wj88.test.pojo.BlogTest;

@RunWith(SpringRunner.class)
@ActiveProfiles("hsqldb")
@DataJpaTest
public class BlogTestRepositoryTest {

    @Resource
    private BlogTestRepository blogTestRepository;

    /**
     * 测试新增博客的情况.
     */
    @Test
    public void save() {
        String id = "newblogId";
        String title = "Java 从入门到放弃";
        blogTestRepository.save(new BlogTest().setId(id).setTitle(title));

        Optional<BlogTest> blogOptional = blogTestRepository.findById(id);
        Assert.assertTrue(blogOptional.isPresent() && title.equals(blogOptional.get().getTitle()));
    }

    /**
     * 测试查询所有 Spring 相关的博客信息.
     */
    @Test
    public void query() {
        List<BlogTest> blogs = blogTestRepository.queryTest();
        Assert.assertEquals(1, blogs.size());
        Assert.assertEquals("Spring从入门到精通", blogs.get(0).getTitle());
    }
}