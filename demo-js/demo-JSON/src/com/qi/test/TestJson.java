package com.qi.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qi.proj.Dog;
import com.qi.proj.Person;
import org.testng.annotations.Test;

public class TestJson {

    @Test
    public void testWriteJSON() throws JsonProcessingException {
        Dog dog = new Dog("chili", 1);

        Person person = new Person("Qi", 31, dog);

        ObjectMapper objectMapper = new ObjectMapper();
        String personStr = objectMapper.writeValueAsString(person);
        System.out.println(personStr);
    }

    @Test
    public void testReadJSON() throws JsonProcessingException {
        String personStr = "{\"name\":\"Qi\",\"age\":31,\"dog\":{\"name\":\"chili\",\"age\":1}}";
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(personStr, Person.class);
        System.out.println(person);
    }

}
