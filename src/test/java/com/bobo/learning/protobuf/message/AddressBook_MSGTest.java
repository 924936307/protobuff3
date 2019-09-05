package com.bobo.learning.protobuf.message;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

import javax.lang.model.SourceVersion;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: bobo
 * Date: 2019/9/5
 * Description: No Description
 */
public class AddressBook_MSGTest {


    @Test
    public void test(){
        //测试protobuff生成的java类
        AddressBook_MSG.Person.Builder builder = AddressBook_MSG.Person.newBuilder();
        builder.setId(1);
        builder.setEmail("bobo@q.com");
        builder.addPhones(AddressBook_MSG.Person.PhoneNumber.newBuilder().setNumber("110").setTypeValue(1));
        AddressBook_MSG.Person person = builder.build();
        System.out.println("person = " + person);
        byte[] bytes = person.toByteArray();
        System.out.println("bytes = " + bytes.length);
        System.out.println("序列化完成！！！");
        //反序列化
        AddressBook_MSG.Person per = null;
        try {
            per = AddressBook_MSG.Person.parseFrom(bytes);
            System.out.println("per = " + per);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

}