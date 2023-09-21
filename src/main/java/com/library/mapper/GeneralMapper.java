package com.library.mapper;

public interface GeneralMapper<entity, dto> {

    public dto entityToDto(entity publisher);
    public entity dtoToEntity(dto publisherDTO);

}
