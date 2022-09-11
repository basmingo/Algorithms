package com.basmingo.patterns;

public class FactoryMethod {
    public static void main(String[] args) {
        Animal A = AnimalFactory.getAnimal();

        A.getSound();
    }
}