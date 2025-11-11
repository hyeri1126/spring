package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id
//    DB가 ID를 자동으로 생성해주는 전략을 Identity 전략이라고 한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
