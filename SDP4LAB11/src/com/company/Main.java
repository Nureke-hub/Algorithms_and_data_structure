package com.company;

public class Main {
    public static void main(String[] args) {
        //1-2
        /*
        Graph<String> graph = new Graph<>(false);
        graph.put("a", "c");
        graph.put("d", "a");
        graph.put("c", "d");
        graph.put("c", "e");//
        graph.put("c", "b");

        graph.put("b", "a");
        graph.put("b", "e");
        graph.put("d", "e");

        graph.put("a", "j");
        graph.put("d", "z");
        graph.put("b", "q");
        graph.put("e", "f");
        System.out.println(graph.route("c", "f"));
         */


        //3
        Graph<String> friends = new Graph<>(false);
        friends.put("Aqzhol", "Dastan");
        friends.put("Aqzhol", "Erlan");
        friends.put("Aqzhol", "Bota");
        friends.put("Aqzhol", "Alihan");


        friends.put("Dastan", "Erlan");
        friends.put("Dastan", "Alihan");

        friends.put("Alihan", "Bota");
        friends.put("Bota", "Erlan");

        friends.Common_friends("Aqzhol");

    }
}
