package com.dh.serieservice.Queue;

import com.dh.serieservice.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component//para que Spring lo inyecte en su contexto y lo maneje de forma de que se pueda iostancia r
@RequiredArgsConstructor
public class SerieSender {
    //los hago final por el @RequiredArgsConstructor
    private final RabbitTemplate rabbitTemplate;
    private final Queue serieQueue;

    public void send(Serie serie){
        //convertAndSend para convertir por medio de Jackson
        this.rabbitTemplate.convertAndSend(this.serieQueue.getName(), serie);
    }
}
