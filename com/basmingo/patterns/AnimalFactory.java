package com.basmingo.patterns;

public class AnimalFactory {
    public static Animal getAnimal() {
        return new Cat();
    }
}
