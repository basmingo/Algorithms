package com.basmingo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Car implements Comparable<Car>{
    private int price;

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.price, o.price);
    }
}
