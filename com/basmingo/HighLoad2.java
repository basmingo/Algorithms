package com.basmingo;

import java.util.ArrayList;
import java.util.List;

class Request {
    int id;
    int time;

    Request(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

class Server {
    List<Request> cache = new ArrayList<>();

    public void call(Request request) {
        int intersectsFromUser = 0;
        int intersectsTotal = 0;
        for (var item : cache) {
            int prevLimit = request.time - HighLoad2.duration;
            if (item.time >= prevLimit) {
                intersectsTotal++;
                if (request.id == item.id)  intersectsFromUser++;
            }
        }
                                            
        if (intersectsFromUser >= HighLoad2.userLimit) System.out.println("479");
        else if (intersectsTotal >= HighLoad2.totalLimit) System.out.println("503");
        else {
            System.out.println("200");
            cache.add(request);
        }
    }
}

public class HighLoad2 {
    static int userLimit = 2;
    static int totalLimit = 5;
    static int duration = 5;
    static int[][] input = {{1, 100}, {1, 100}, {2, 100}, {2, 200}, {2, 300}, {2, 400}, {2, 500}, {3, 500}, {5, 200}, {6, 100}, {7, 200}};
    static int[][] input2 = {{1, 100}, {1, 100}, {2, 100}, {6, 100}, {2, 200}, {5, 200}, {7, 200}, {2, 300}, {2, 400}, {2, 500}, {3, 500}};

    public static void main(String[] args) {
        Server server = new Server();

        for (var i : input) {
            server.call(new Request(i[1], i[0]));
        }

    }
}
