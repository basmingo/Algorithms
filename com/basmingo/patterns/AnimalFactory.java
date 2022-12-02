package com.basmingo.patterns;

public class AnimalFactory {
    public static Alive getAnimal() {
        return new Cat();
    }
}
