package com.library.service.implementation;

import com.library.dto.PublisherDTO;
import com.library.mapper.PublisherMapper;
import com.library.service.PublisherService;
import com.library.entity.Publisher;
import com.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImplementation implements PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    PublisherMapper publisherMapper;

    public ResponseEntity<PublisherDTO> insertPublisher( Publisher publisher) {

        try {
            publisherRepository.save(publisher);
            return new ResponseEntity<PublisherDTO>(publisherMapper.entityToDto(publisher), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PublisherDTO>> getAllPublishers() {

        try {
            List<Publisher> publishers = publisherRepository.findAll();
            if (!publishers.isEmpty()) {
                List<PublisherDTO> result =
                        publishers.stream()
                                  .map(publisher -> publisherMapper.entityToDto(publisher))
                                  .collect(Collectors.toList());
                return new ResponseEntity<List<PublisherDTO>>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PublisherDTO> getPublisherById(Integer id){

        try {
            Optional<Publisher> result = publisherRepository.findById(id);
            if (result.isPresent()) {
                return new ResponseEntity<PublisherDTO>(publisherMapper.entityToDto(result.get()), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
