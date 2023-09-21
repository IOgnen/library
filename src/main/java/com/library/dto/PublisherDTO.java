package com.library.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherDTO {

    private String name;
    private String address;
    private String number;
    private String city;

}
