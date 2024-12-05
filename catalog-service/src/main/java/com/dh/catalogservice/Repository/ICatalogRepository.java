package com.dh.catalogservice.Repository;

import com.dh.catalogservice.domain.model.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICatalogRepository extends MongoRepository<Catalog, String> {

    @Query(value = "{ 'content.genre' : ?0 }")
    List<Catalog> findByGenre(String genre);
    //List<Catalog> findByGenre(String genre);

}
