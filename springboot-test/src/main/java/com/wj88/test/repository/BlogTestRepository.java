package com.wj88.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wj88.test.pojo.BlogTest;

/**
 * BlogTestRepository
 *
 * @author huayu
 * @date 2020/9/27 14:17
 * @version 1.0
 */
@Repository
public interface BlogTestRepository extends JpaRepository<BlogTest, String> {

    @Query("SELECT b FROM Blog AS b WHERE b.title like 'Spring%'")
    List<BlogTest> queryTest();
}
