package com.library.service;

import com.library.dto.PublisherDTO;
import com.library.entity.Publisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PublisherService {

    ResponseEntity<List<PublisherDTO>>  getAllPublishers();
    ResponseEntity<PublisherDTO> getPublisherById(Integer id);
    ResponseEntity<PublisherDTO> insertPublisher(Publisher publisher);

}
