package com.dh.movieservice.Queue;

import com.dh.movieservice.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component//para que Spring lo inyecte en su contexto y lo maneje de forma de que se pueda iostancia r
@RequiredArgsConstructor
public class MovieSender {
    //los hago final por el @RequiredArgsConstructor
    private final RabbitTemplate rabbitTemplate;
    private final Queue movieQueue;

    public void send(Movie movie){
        //convertAndSend para convertir por medio de Jackson
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), movie);
    }


}
