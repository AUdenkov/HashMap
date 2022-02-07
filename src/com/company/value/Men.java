package com.company.value;

import java.util.Objects;

public class Men {
    private String name;

    public Men(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Men{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Men men = (Men) o;
        return Objects.equals(name, men.name);
    }

    @Override
    public int hashCode() {
        return 2;
    }
}
