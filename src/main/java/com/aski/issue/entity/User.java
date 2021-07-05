package com.aski.issue.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by temelt on 3.02.2019.
 */
@Entity
@Table(name = "users", indexes = {@Index(name = "idx_username", columnList = "username")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", length = 100, unique = true)
    private String username;
    @Column(name = "tc", length = 100, unique = true)
    private String tc;

    @Column(name = "pwd", length = 200)
    private String password;

    @Column(name = "name", length = 200)
    private String name;
    @Column(name = "name_surname", length = 200)
    private String nameSurname;

    @Column(name = "email", length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;
}
