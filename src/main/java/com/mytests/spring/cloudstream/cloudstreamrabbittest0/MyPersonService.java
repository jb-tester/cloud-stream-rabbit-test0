package com.mytests.spring.cloudstream.cloudstreamrabbittest0;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyPersonService {

  @Input("personInput")
  SubscribableChannel myInput();

  @Output("personOutput")
  MessageChannel anOutput();

  @Output
  MessageChannel anotherPersonOutput();

}
