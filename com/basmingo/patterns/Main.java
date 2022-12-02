package com.basmingo.patterns;

public class Main {
    public static void main(String[] args) {
        Alive A = AnimalFactory.getAnimal();

        A.getSound();
    }
}