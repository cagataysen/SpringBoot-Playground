package com.example.demo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/*Elastic Search type Document*/

@Document(indexName = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private String id;

    @Field(name= "name", type = FieldType.Text)
    private String name;

    @Field(name= "surname", type = FieldType.Text)
    private String surname;

    @Field(name= "address", type = FieldType.Text)
    private String address;

    @Field(name= "birthday", type = FieldType.Text)
    private Date birthday;


}
