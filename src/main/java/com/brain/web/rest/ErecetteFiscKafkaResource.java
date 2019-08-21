package com.brain.web.rest;

import com.brain.service.ErecetteFiscKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/erecette-fisc-kafka")
public class ErecetteFiscKafkaResource {

    private final Logger log = LoggerFactory.getLogger(ErecetteFiscKafkaResource.class);

    private ErecetteFiscKafkaProducer kafkaProducer;

    public ErecetteFiscKafkaResource(ErecetteFiscKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
