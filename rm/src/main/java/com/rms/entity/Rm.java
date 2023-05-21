package com.rms.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Rm implements Serializable {
    private String id;
    private String name;
    private String degree;
    private String school;
    private String hobby;
}
