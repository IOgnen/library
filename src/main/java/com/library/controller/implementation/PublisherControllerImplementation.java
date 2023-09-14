package com.library.controller.implementation;

import com.library.entity.Publisher;
import com.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/publisher")
public class PublisherControllerImplementation {

    @Autowired
    PublisherRepository publisherRepository;

    @PostMapping("insertPublisher")
    public ResponseEntity<Publisher> insertPublisher(@RequestBody Publisher publisher) {

        try {
            publisherRepository.save(publisher);
            return new ResponseEntity<Publisher>(publisher, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Publisher>(publisher, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getAllPublishers")
    public ResponseEntity<List<Publisher>> getAllPublishers() {

        List<Publisher> result = new ArrayList<Publisher>();
        try {
            result = publisherRepository.findAll();
            if (result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable("id") int id){

        try {
            Publisher result = publisherRepository.getReferenceById(id);
            return new ResponseEntity<Publisher>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
