package com.dh.catalogservice.domain.model;


import lombok.Data;

import java.util.List;


public record Serie (String id, String name, String genre, List<Season> seasons)/*ObjectId _id??*/ {

    public record Season(Integer seasonNumber, List<Chapter> chapters) {
        public record Chapter(String name, Integer number, String urlStream) {}
    }
}
