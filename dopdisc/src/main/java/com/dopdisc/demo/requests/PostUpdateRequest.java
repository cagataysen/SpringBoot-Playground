package com.dopdisc.demo.requests;

import lombok.Data;

import java.util.Date;

@Data
public class PostUpdateRequest {

    Long postId;

    String userId;
    String text;
    String title;
    Date date;


}
