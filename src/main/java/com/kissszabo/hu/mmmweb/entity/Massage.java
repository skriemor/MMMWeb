package com.kissszabo.hu.mmmweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "MASSAGE")
public class Massage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    int length;

    public Massage(){}

    public Massage(String name, int length) {
        this.name = name;
        this.length = length;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}