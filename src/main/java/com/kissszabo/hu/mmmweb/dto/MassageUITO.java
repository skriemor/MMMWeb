package com.kissszabo.hu.mmmweb.dto;


import java.io.Serializable;
import java.util.Objects;

public class MassageUITO implements Serializable {
        private Long id;
        private String name;
        private int length;


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MassageUITO that = (MassageUITO) o;
        return length == that.length &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
        }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, length);
    }

    public String toString() {
            return "Massage{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", length=" + length +
                    '}';
        }

}
