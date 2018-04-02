package com.zzq.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author zzq
 * @createTime 2018/3/12
 */
@Entity
@Table(name = "girl")
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "这个字段必传")
    private String cupSize;

    @Min(value = 18, message = "未成年")
//    @NotNull
//    @Max
//    @Length
    private Integer age;

    @NotNull(message = "金额必传")
    private Double money;

    public Girl() {
    }

    public Girl(String cupSize, Integer age, Double money) {
        this.cupSize = cupSize;
        this.age = age;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
