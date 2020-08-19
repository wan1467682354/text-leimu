package com.jk.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookBean implements Serializable {

    private Integer id;

    private String name;
}
