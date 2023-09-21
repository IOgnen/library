package com.library.mapper;
import com.library.dto.PublisherDTO;
import com.library.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper implements GeneralMapper<Publisher, PublisherDTO> {

    @Override
    public PublisherDTO entityToDto(Publisher publisher) {
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setName(publisher.getName());
        publisherDTO.setAddress(publisher.getAddress());
        publisherDTO.setCity(publisher.getCity());
        publisherDTO.setNumber(publisher.getNumber());
        return publisherDTO;
    }
    @Override
    public Publisher dtoToEntity(PublisherDTO publisherDTO) {
        return null;
    }

}
