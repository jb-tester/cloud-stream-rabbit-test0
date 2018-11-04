package com.mytests.spring.cloudstream.cloudstreamrabbittest0.model;

import org.springframework.stereotype.Component;

@Component
public class PersonProducer {

    Person person = new Person("irina","petrovskaya",48);

    public Person getPerson() {

        return person;
    }


}
