package com.nemanja.springbootmongodb.springbootmongodb.service;

import com.nemanja.springbootmongodb.springbootmongodb.collection.Person;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface  PersonService {
    String save(Person person);

    List<Person> findByName(String name);

    String delete(String id);

    List<Person> getByPersonAge(Integer minAge, Integer maxAge);

    List<Person> getAll();

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

    List<Document> getOldestPersonByCity();

    List<Document> getPopulationByCity();
}
