package com.basmingo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Dish {
    public String name;
    public Map<String, Integer> ingredients = new HashMap<>();

    public Dish(String name) {
        this.name = name;
    }
}

class Position {
    public String name;
    public int cost;
    public String type;

    public Position(String name,  String type) {
        this.name = name;
        this.type = type;
    }
}

class EnergyPosition {
    public String name;
    public int amount;
    public String type;

    public double proteins;
    public double fats;
    public double carps;
    public double energy;

    public EnergyPosition(String name, int amount, String type) {
        this.name = name;
        this.amount = amount;
        this.type = type;
    }
}
public class VasiyaCooking {
    public static void main(String[] args) throws IOException {
        BufferedReader bd = new BufferedReader(new FileReader("com/basmingo/resources/vasiyacooking.txt"));
//        BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));


        Map<Dish, Integer> dishes = new HashMap<>();
        int amountOfVaryDishes = Integer.parseInt(bd.readLine());
        for (int i = 0; i < amountOfVaryDishes; i++) {
            String[] dishString = bd.readLine().split(" ");
            int amountOfOneDish = Integer.parseInt(dishString[1]);
            int amountOfIngredients = Integer.parseInt(dishString[2]);

            Dish dish = new Dish(dishString[0]);

            for (int j = 0; j < amountOfIngredients; j++) {
                String[] ingredientsString = bd.readLine().split(" ");
                int amountOfOneIngredient = Integer.parseInt(ingredientsString[1]);
                dish.ingredients.put(ingredientsString[0], amountOfOneIngredient);
            }
            dishes.put(dish, amountOfOneDish);
        }
        // here we have map with dishes

        Map<Position, Integer> ingredientCosts = new HashMap<>();
        int amountOfIngredients = Integer.parseInt(bd.readLine());
        for (int i = 0; i < amountOfIngredients; i++) {
            String[] costsLine = bd.readLine().split(" ");
            int ingredientCost = Integer.parseInt(costsLine[1]);
            String ingredientType = costsLine[2];

            Position position = new Position(costsLine[0], ingredientType);
            ingredientCosts.put(position, ingredientCost);
        }
        // here we have map of costs

        Set<EnergyPosition> energiesForIngredient = new HashSet<>();
        int amountOfPositions = Integer.parseInt(bd.readLine());
        for (int i = 0; i < amountOfPositions; i++) {
            String[] energyiesPos = bd.readLine().split(" ");
            String name = energyiesPos[0];
            int countOfIngredients = Integer.parseInt(energyiesPos[1]);
            String ingType = energyiesPos[2];

            double proteins = Double.parseDouble(energyiesPos[3]);
            double fats = Double.parseDouble(energyiesPos[4]);
            double carps = Double.parseDouble(energyiesPos[5]);
            double energies = Double.parseDouble(energyiesPos[6]);

            EnergyPosition energyPosition = new EnergyPosition(name, countOfIngredients, ingType);
            energyPosition.proteins = proteins;
            energyPosition.fats = fats;
            energyPosition.carps = carps;
            energyPosition.energy = energies;

            energiesForIngredient.add(energyPosition);
        }

        System.out.println("done");
    }
}
