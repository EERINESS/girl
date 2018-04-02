package com.zzq.service;

import com.zzq.domain.Girl;
import com.zzq.enums.ResultEnum;
import com.zzq.exception.GirlException;
import com.zzq.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zzq
 * @createTime 2018/3/12
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if (age < 10){
            //返回 "你可能还在上小学吧" code = 100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16){
            //返回 "你可能还在上初中" code = 101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //如果 > 16 岁， ...
    }


    /**
     * 通过 Id 查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findById(id).get();
    }
}
