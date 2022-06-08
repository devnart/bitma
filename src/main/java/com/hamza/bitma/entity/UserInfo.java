package com.hamza.bitma.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity = User.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId", referencedColumnName = "id",unique = true)
    private User user;

    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String avatar;

}
