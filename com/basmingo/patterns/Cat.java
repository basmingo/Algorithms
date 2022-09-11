package com.basmingo.patterns;

import com.basmingo.patterns.Animal;

public class Cat implements Animal {
    @Override
    public void getSound() {
        System.out.println("meow");
    }
}
