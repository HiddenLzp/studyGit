package com.lzp.springboot.testJackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 11 14:42
 */
public class jacksonTest {

    public static void main(String[] args) {
        try {
            User user = new User();
            user.setAge(1);
            user.setBirthday(new Date());
            user.setEmail("123456");
            user.setName("李泽平");

            ObjectMapper mapper = new ObjectMapper();

            //当反序列化json是 未知属性会引起的反序列化被打断， 这里我们禁用未知属性打断反序列化功能
            //因为，例如json里有10个属性，而我们的beac中之定义了两个属性，其他8个属性将被忽略
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            //Convert object to JSON string

            String json = mapper.writeValueAsString(user);
            System.out.println(json);

            //Convert json string to Object
            User user1 = mapper.readValue(json, User.class);
            System.out.println(user1);

            User user2 = new User();
            user2.setName("lzp");
            user2.setAge(22);
            user2.setEmail("789456");
            user2.setBirthday(new Date());

            List<User> users = new ArrayList<>();
            users.add(user);
            users.add(user2);

            //Convert List<Object> to String
            String listUsers = mapper.writeValueAsString(users);
            System.out.println(listUsers);

            //Convert json String to List<Object>
            List<User> stringToList = mapper.readValue(listUsers, new TypeReference<List<User>>() {
            });

            for (int i = 0; i< stringToList.size() ; i++) {
                System.out.println(stringToList.get(i));
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
