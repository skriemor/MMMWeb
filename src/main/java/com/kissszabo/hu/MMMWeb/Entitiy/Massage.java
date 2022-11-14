package com.kissszabo.hu.MMMWeb.Entitiy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "massage")
public class Massage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String name;

    @ManyToOne
    private Reservation reservation;

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
                ", reservation=" + reservation +
                ", length=" + length +
                '}';
    }
}