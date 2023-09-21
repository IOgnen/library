package com.library.controller;

import com.library.dto.PublisherDTO;
import com.library.entity.Publisher;
import com.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
@CrossOrigin(origins = "*")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping("/getAllPublishers")
    public ResponseEntity<List<PublisherDTO>> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/getPublisher")
    public ResponseEntity<PublisherDTO> getPublisher(@RequestParam("id") Integer id) {
        return publisherService.getPublisherById(id);
    }

    @PostMapping("insertPublisher")
    public ResponseEntity<PublisherDTO> insertPublisher(@RequestBody Publisher publisher) {
        return publisherService.insertPublisher(publisher);
    }

}
