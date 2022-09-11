package com.basmingo.patterns;

import com.basmingo.patterns.Animal;

public class Dog implements Animal {
    @Override
    public void getSound() {
        System.out.println("WOF!!!");
    }
}
