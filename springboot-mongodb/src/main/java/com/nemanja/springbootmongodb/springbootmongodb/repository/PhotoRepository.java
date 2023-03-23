package com.nemanja.springbootmongodb.springbootmongodb.repository;

import com.nemanja.springbootmongodb.springbootmongodb.collection.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo,String> {
}
