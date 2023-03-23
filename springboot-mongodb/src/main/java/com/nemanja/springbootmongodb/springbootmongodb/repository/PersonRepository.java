package com.nemanja.springbootmongodb.springbootmongodb.repository;

import com.nemanja.springbootmongodb.springbootmongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person,String> {
    @Query(

            value = "{'age': {$gt : ?0, $lt : ?1}}"
    )
    List<Person> getByPersonAge(Integer minAge, Integer maxAge);

    //List<Person> findBy(String name);
}
