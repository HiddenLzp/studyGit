package com.lzp.springboot.testJackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.Ignore;

import java.util.Date;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 11 14:40
 */

/**
 * jackson 提供了一些列的注解， 方便对JSON序列化和反序列化进行控制
 * @JsonIgnore 此注解用于属性上， 作用是进行JSON操作时 忽略该属性
 * @JsonFormat 此注解用于属性上 作用是吧Date类型直接转换为想要的格式
 *          如@JsonFormat(pattern = "yyyyMMdd")
 * @JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，如把eMail属性序列化为mail，@JsonProperty("mail")
 */
public class User {
    private String name;
    @JsonIgnore
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:hh",timezone = "GMT+8")
    private Date birthday;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
