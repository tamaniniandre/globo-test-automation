package com.globo.test.automation.utils;

import com.github.javafaker.Faker;

public class FakeDatas {

    public static String generateRandomProductDescription(){
        Faker faker = new Faker();
        return faker.beer().name()+" "+faker.random().nextInt(100);
    }
}
