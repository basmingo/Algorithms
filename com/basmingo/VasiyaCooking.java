package com.basmingo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



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

            Set<Ingredient> ingredientMap = new HashSet<>();


            for (int j = 0; j < amountOfIngredients; j++) {
                String[] ingredientsString = bd.readLine().split(" ");
                int amount = Integer.parseInt(ingredientsString[1]);
                String type = ingredientsString[2];
                ingredientMap.add(new Ingredient(ingredientsString[0], type, amount));
            }

            Dish dish = new Dish(dishString[0], ingredientMap);
            dishes.put(dish, amountOfOneDish);
        }
        // here we have map with dishes

        Map<String, CataloguePosition> ingredientCosts = new HashMap<>();
        int amountOfIngredients = Integer.parseInt(bd.readLine());
        for (int i = 0; i < amountOfIngredients; i++) {
            String[] costsLine = bd.readLine().split(" ");
            int ingredientCost = Integer.parseInt(costsLine[1]);
            int inredientAmount = Integer.parseInt(costsLine[2]);
            String ingredientType = costsLine[3];

            CataloguePosition position = new CataloguePosition(costsLine[0], ingredientType, ingredientCost, inredientAmount);
            ingredientCosts.put(costsLine[0], position);
        }
        // here we have map of costs

        HashMap<String, EnergyPosition> energiesForIngredient = new HashMap<>();
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

            energiesForIngredient.put(name, energyPosition);
        }

        Map<String, Integer> resultIngredients = new HashMap<>();
        int resultSum = 0;


        //calculations
        dishes.keySet().forEach(x -> x.calculateEnergy(energiesForIngredient));
        Map<String, Integer> totalIngredients = new HashMap<>();
        for(var i : dishes.entrySet()) {
            for (var j : i.getKey().ingredients.entrySet()) {
                totalIngredients.merge(j.getKey(), j.getValue() * i.getValue(), Integer::sum);
            }
        }

        for(var i : ingredientCosts.entrySet()) {
            double a = (double) Optional
                    .ofNullable(totalIngredients.get(i.getKey()))
                    .orElse(0)
                    / (double) i.getValue()
                    .amountInside;

            int aNeeded = (int) Math.ceil(a);
            resultSum += aNeeded * i.getValue().cost;
            resultIngredients.put(i.getKey(), aNeeded);
        }

        System.out.println(resultSum);
        resultIngredients.forEach((x, y) -> System.out.println(x + " " + y));
        dishes.forEach((x, y) -> System.out.println(x.name + " "
                + x.proteins + " "
                + x.fats + " "
                + x.carps + " "
                + x.energy));
    }
    static class Ingredient {
        public String name;
        public String type;
        public int amount;

        public Ingredient(String name, String type, int amount) {
            this.name = name;
            this.type = type;
            this.amount = amount;
        }
    }

    static class Dish {
        public String name;
        public Map<String, Integer> ingredients = new HashMap<>();

        public double proteins = 0;
        public double fats = 0;
        public double carps = 0;
        public double energy = 0;

        public Dish(String name, Set<Ingredient> ingredients) {
            this.name = name;
            ingredients.forEach(x -> this.ingredients.put(x.name, convertUp(x.type, x.amount)));
        }

        private int convertUp(String type, int amount) {
            return switch (type) {
                case "tens" -> amount * 10;
                case "l", "kg" -> amount * 1000;
                default -> amount;
            };
        }

        public void calculateEnergy(Map<String, EnergyPosition> input) {
            for (var i : ingredients.entrySet()) {
                EnergyPosition position = input.get(i.getKey());
                double proteins = convert(position.type, position.proteins / position.amount);
                double fats = convert(position.type, position.fats / position.amount);
                double carps = convert(position.type, position.carps / position.amount);
                double energy = convert(position.type, position.energy / position.amount);

                this.proteins += proteins * i.getValue();
                this.fats += fats * i.getValue();
                this.carps += carps * i.getValue();
                this.energy += energy * i.getValue();
            }
        }

        private double convert(String type, double amount) {
            return switch (type) {
                case "tens" -> amount / 10;
                case "l", "kg" -> amount / 1000;
                default -> amount;
            };
        }
    }

    static class CataloguePosition {
        public String name;
        public String type;
        public int cost;
        public int amount;
        public int amountInside;

        public CataloguePosition(String name, String type, int cost, int amount) {
            this.name = name;
            this.type = type;
            this.cost = cost;
            this.amount = amount;
            this.amountInside = convert(this.type, amount);
        }

        private int convert(String type, int amount) {
            return switch (type) {
                case "tens" -> amount * 10;
                case "l", "kg" -> amount * 1000;
                default -> amount;
            };
        }
    }

    static class EnergyPosition {
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
}
