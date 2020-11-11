package com.wj88.test.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wj88.test.pojo.BlogTest;
import com.wj88.test.repository.BlogTestRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * BlogTestService
 *
 * @author huayu
 * @date 2020/9/27 14:29
 * @version 1.0
 */
@Slf4j
@Service
public class BlogTestService {

    @Resource
    private BlogTestRepository blogTestRepository;

    /**
     * 查询所有 Spring 相关的博客信息.
     *
     * @return 博客信息
     */
    public List<BlogTest> getSpringBlogs() {
        log.info("进入了获取 Spring 相关博客的 Service 方法.");
        return blogTestRepository.queryTest();
    }

    /**
     * 根据博客ID来修改该博客的名称.
     *
     * @param id 博客ID
     * @param title 博客标题
     */
    public void modifyTitileById(String id, String title) {
        Optional<BlogTest> blogOptional = blogTestRepository.findById(id);
        if (!blogOptional.isPresent()) {
            log.warn("需要修改名称的博客不存在，id为【{}】请检查！", id);
            return;
        }
        blogTestRepository.save(blogOptional.get().setTitle(title));
    }
}
