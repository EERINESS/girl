package com.zzq.repository;

import com.zzq.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zzq
 * @createTime 2018/3/12
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    //通过年龄来查询
    List<Girl> findByAge (Integer age);
}
