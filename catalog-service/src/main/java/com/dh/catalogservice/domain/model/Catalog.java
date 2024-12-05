package com.dh.catalogservice.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode
@Document(collection = "catalogs")
public class Catalog {
    @Id
    private String id;
    private Object content;
    //private String genre;
    //private List<Objects> generic;
    //private List<Serie> series;
}
