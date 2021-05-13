package com.yuanchun.controler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/kafka")
public class CollectController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;




    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void sendKafka(String message) {
        try {
            logger.info("kafka的消息={}", message);
            kafkaTemplate.send("topic-1",  message);
            logger.info("发送kafka成功.");

        } catch (Exception e) {
            logger.error("发送kafka失败", e);

        }
    }
}
