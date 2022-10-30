package com.jscreations.myloginapplication;

public class Test {
    String name ;
    String age;

    public Test(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Test(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
