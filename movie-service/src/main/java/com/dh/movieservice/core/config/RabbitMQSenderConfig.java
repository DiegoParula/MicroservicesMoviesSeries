package com.dh.movieservice.core.config;


import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.movie.name}")//(movie-queue)busca el nombre en el prop o yml, que despues lo va a guardar cuando cree la nueva cola
    private String movieQueque;

    @Bean //@Bean: Indica que el método que sigue será responsable de crear un bean de Spring
   public Queue queue(){
        //Crea una nueva instancia(cola) de Queue con el nombre de la cola obtenido de la propiedad inyectada y establece la durabilidad de la cola como false.
       return new Queue(this.movieQueque, false);
   }
}
