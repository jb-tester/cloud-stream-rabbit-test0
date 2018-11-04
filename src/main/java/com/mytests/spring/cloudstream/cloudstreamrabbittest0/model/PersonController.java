package com.mytests.spring.cloudstream.cloudstreamrabbittest0.model;

import com.mytests.spring.cloudstream.cloudstreamrabbittest0.MyPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableBinding(MyPersonService.class)
public class PersonController {

    @Autowired
    private MyPersonService myPersonService;
    @Autowired
    private PersonProducer personProducer;

   @ModelAttribute("person")
    public Person person(){
        return personProducer.getPerson();
    }

    /*@PostMapping("/")
    public String processPerson(@ModelAttribute @RequestBody Person person) {
        myPersonService.myInput()
                .send(MessageBuilder.withPayload(new GenericMessage(person.toString()))
                        .build());
        return "redirect:/result";
    }*/

    @GetMapping("/result")
    @StreamListener(value = "personInput")
    @SendTo("personOutput")
    public String listen(Person person) {
        return person.toString();
    }

    @GetMapping("/result")
    @StreamListener(target = "personInput", condition = "payload.getAge()>45")
    public void listen2(Person person) {
        System.out.println("***************************");
      myPersonService.anotherPersonOutput().send(message(person));
    }
    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }

    @GetMapping("/result")
    @StreamListener(target = "personInput", condition = "headers['type']=''")
    public void listen3(@Payload(expression = "") Person person) {
        System.out.println("***************************");
      myPersonService.anotherPersonOutput().send(message(person));
    }





    // TODO: payload is not resolved
}