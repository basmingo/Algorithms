package com.basmingo;

import java.io.BufferedReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Good {
    Long id;
    LocalDate arrivingDate;
    long price;
    String name;
    String json;

    public Good(long id, String arrivingDate, long price, String name, String json) throws java.text.ParseException {
        this.id = id;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy");
        this.arrivingDate = LocalDate.parse(arrivingDate, formatter);
        this.price = price;
        this.name = name;
        this.json = json;
    }
}
public class ZlibobaBuingSomething {
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/pavel/Desktop/3"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy");

        String goodsToParse = reader.readLine();
        final long PRICE_LESS_THAN = Long.parseLong(reader.readLine().split(" ")[1]);
        final LocalDate DATE_AFTER = LocalDate.parse(reader.readLine().split(" ")[1], formatter).minusDays(1);
        final String NAME_CONTAINS = reader.readLine().split(" ")[1];
        final long PRICE_GREATER_THAN = Long.parseLong(reader.readLine().split(" ")[1]);
        final LocalDate DATE_BEFORE = LocalDate.parse(reader.readLine().split(" ")[1], formatter).plusDays(1);


        JSONParser parser = new JSONParser();
        List<Good> goods = new ArrayList<>();

        JSONArray A = (JSONArray) parser.parse(goodsToParse);
        for (Object i : A) {
            JSONObject O = (JSONObject) i;
            Long id = (Long) O.get("id");
            String date = (String) O.get("date");
            Long price = (Long) O.get("price");
            String name = (String) O.get("name");

            goods.add(new Good(id, date, price, name, i.toString()));
        }

        List<Good> result = new ArrayList<>(goods.stream()
                .filter(p -> p.name.toLowerCase(Locale.ROOT).contains(NAME_CONTAINS.toLowerCase()))
                .filter(p -> p.price < PRICE_LESS_THAN)
                .filter(p -> p.price >= PRICE_GREATER_THAN)
                .filter(p -> p.arrivingDate.isAfter(DATE_AFTER))
                .filter(p -> p.arrivingDate.isBefore(DATE_BEFORE))
                .sorted(Comparator.comparing(p -> p.id))
                .collect(Collectors.toList())
        );

        System.out.println(result.stream().map(p -> p.json).collect(Collectors.toList()));
    }
}
