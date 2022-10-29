package com.basmingo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Participant {
    String name;
    int score;
    long fine;

    public Participant(String name, int score, long fine) {
        this.name = name;
        this.score = score;
        this.fine = fine * -1;
    }

    public long getFine() {
        return fine;
    }

    public int getScore() {
        return score;
    }
}

public class SportCompetition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/pavel/Desktop/2"));

        List<String> competitionList = new ArrayList<>();
        Map<String, List<Participant>> competitionList2 = new HashMap<>();
        Map<String, Integer> competitionMaxPartisipants = new HashMap<>();
        int competitionsAmount = Integer.parseInt(reader.readLine());



        for (int i = 0; i < competitionsAmount; i++) {
            String[] currentCompetition = reader.readLine().split(",");
            competitionList2.put(currentCompetition[0], new ArrayList<>());
            competitionList.add(currentCompetition[0]);

            competitionMaxPartisipants.put(
                    currentCompetition[0],
                    Integer.parseInt(currentCompetition[1]));
        }

        int partisipantsAmount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < partisipantsAmount; i++) {
            String[] currentParticipantParse = reader.readLine().split(",");
            Participant currentParticipant = new Participant(currentParticipantParse[0],
                    Integer.parseInt(currentParticipantParse[2]),
                    Long.parseLong(currentParticipantParse[3]));

            competitionList2.get(currentParticipantParse[1]).add(currentParticipant);
        }

        List<String> result = new ArrayList<>();
        Comparator<Participant> byScore = Comparator.comparing(Participant::getScore);
        Comparator<Participant> byFine = Comparator.comparing(Participant::getFine);

        for (var i : competitionList) {
            List<Participant> participants = competitionList2.get(i);
            participants.sort(byScore.thenComparing(byFine));

            for (int j = 0; j < competitionMaxPartisipants.get(i); j++) {
                String name = participants.get(participants.size() - j - 1).name;
                result.add(name);
            }
        }

        Collections.sort(result);
        for (var i : result) {
            System.out.println(i);
        }
    }
}
