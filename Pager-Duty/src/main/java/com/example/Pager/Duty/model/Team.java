package com.example.Pager.Duty.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="team")
@Getter
@Setter
public class Team {

 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Integer id;

 private String name;

 @OneToMany(targetEntity = Developer.class, cascade = CascadeType.ALL)
 @JoinColumn(name = "team_id",  referencedColumnName = "id")
 private List<Developer> developers;
}
