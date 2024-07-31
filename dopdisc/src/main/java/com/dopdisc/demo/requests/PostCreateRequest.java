package com.dopdisc.demo.requests;

import lombok.Data;

import java.util.Date;

@Data
public class PostCreateRequest {

    Long id;
    String text;
    String title;
    Long userId;
    private Date date;


}
