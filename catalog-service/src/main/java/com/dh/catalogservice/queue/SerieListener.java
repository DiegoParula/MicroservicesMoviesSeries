package com.dh.catalogservice.queue;

import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.service.impl.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SerieListener {

    private final CatalogService catalogService;

    public SerieListener(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RabbitListener(queues = "serie-queue")
    public void listen(Serie serie) {
        //catalogService.addSeries(serie.genre(), serie);
        //catalogService.addSerieGeneric(serie);
        catalogService.saveCatalog(serie);
    }
}
