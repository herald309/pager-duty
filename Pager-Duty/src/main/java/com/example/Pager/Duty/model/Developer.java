package com.example.Pager.Duty.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="developer")
@Getter
@Setter
public class Developer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String phone_number;

    @Column(name = "team_id")
    private Integer teamId;
}
