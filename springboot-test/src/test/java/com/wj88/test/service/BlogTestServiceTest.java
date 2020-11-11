package com.wj88.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.wj88.test.pojo.BlogTest;
import com.wj88.test.repository.BlogTestRepository;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class BlogTestServiceTest {

    @Mock
    private BlogTestRepository blogTestRepository;

    @InjectMocks
    private BlogTestService blogTestService;

    /**
     * 测试service层中获取Spring相关博客的方法.
     */
    @Test
    public void getSpringBlogs() {
        // 构造需要返回的博客信息集合数据.
        BlogTest blog = new BlogTest()
                .setId("1")
                .setTitle("Spring Action");
        List<BlogTest> blogList = new ArrayList<>();
        blogList.add(blog);

        Mockito.when(blogTestRepository.queryTest())
                .thenReturn(blogList);
        List<BlogTest> blogs = blogTestService.getSpringBlogs();

        // 断言验证查询到的数据.
        Assert.assertEquals(1, blogs.size());
        Assert.assertEquals("Spring Action", blog.getTitle());
    }

    /**
     * 测试根据博客ID来修改该博客的名称成功时的情况.
     */
    @Test
    public void modifyTitileById() {
        // Mock 相关数据和类方法的行为.
        String id = "1";
        Mockito.when(blogTestRepository.findById(id))
                .thenReturn(Optional.of(new BlogTest()));
        Mockito.when(blogTestRepository.save(Mockito.any()))
                .thenReturn(new BlogTest());

        blogTestService.modifyTitileById(id, "算法导论");

        // 验证 blogRepository.save(s) 方法被调用过一次.
        Mockito.verify(blogTestRepository).save(Mockito.any());
    }

    /**
     * 测试根据博客ID来修改该博客的名称失败时的情况.
     */
    @Test
    public void modifyTitileByIdWithFailure() {
        // Mock 未根据 ID 找到对应的博客信息的情况.
        String id = "1";
        Mockito.when(blogTestRepository.findById(id))
                .thenReturn(Optional.ofNullable(null));

        blogTestService.modifyTitileById(id, "算法导论");

        // 验证 blogRepository.save(s) 方法并没有被调用过.
        Mockito.verify(blogTestRepository, Mockito.never()).save(Mockito.any());
    }

}