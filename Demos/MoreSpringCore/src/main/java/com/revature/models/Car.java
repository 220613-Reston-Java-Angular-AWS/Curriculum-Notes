package com.revature.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Car {

    private String model;
    private String make;
    private int year;
    private int cylinders;
}
