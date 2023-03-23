package com.nemanja.springbootmongodb.springbootmongodb.controller;

import com.nemanja.springbootmongodb.springbootmongodb.collection.Person;
import com.nemanja.springbootmongodb.springbootmongodb.service.PersonService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;
    @PostMapping
    public String save(@RequestBody Person person){
        return service.save(person);
    }
    @GetMapping("/name")
    public List<Person> findByName(@RequestParam("name") String name){
        return service.findByName(name);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id){
        return service.delete(id);
    }
    @GetMapping("/age")
    public List<Person> getByPersonAge(@RequestParam Integer minAge, @RequestParam Integer maxAge ){
        return  service.getByPersonAge(minAge,maxAge);
    }
    @GetMapping
    public List<Person> getAll(){
        return service.getAll();
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ){
        Pageable pageable= PageRequest.of(page,size);
        return  service.search(name,minAge,maxAge,city,pageable);

    }
    @GetMapping("/oldestPerson")
    public List<Document> getOlestPerson(){
        return service.getOldestPersonByCity();
    }

    @GetMapping("/getPopulationByCity")
    public List<Document> getPopulationByCity(){
        return service.getPopulationByCity();
    }



}
