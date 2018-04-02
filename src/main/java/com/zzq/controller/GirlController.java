package com.zzq.controller;

import com.zzq.domain.Girl;
import com.zzq.domain.Result;
import com.zzq.repository.GirlRepository;
import com.zzq.service.GirlService;
import com.zzq.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zzq
 * @createTime 2018/3/13
 */
@RestController
public class GirlController {
    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询单个女生信息
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl getGirl(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 更新
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("curSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄查询女生列表
     * @param age
     * @return
     */
    @GetMapping("age/{age}")
    public List<Girl> getListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping("girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping("girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }


}
