package com.mytests.spring.cloudstream.cloudstreamrabbittest0.model;

public class Person {
    String first_name;
    String second_name;
    int age;

    public Person(String name, String surname, int age) {
        this.first_name=name;
        this.second_name=surname;
        this.age=age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", age=" + age +
                '}';
    }
}
