package com.company;
import java.util.*;

public class Graph<T extends Comparable<T>> {
    private HashMap<T, ArrayList<Edge<T>>> map;
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        map = new HashMap<T, ArrayList<Edge<T>>>();
    }

    public void put(T from, T to, int weight) {
        if (!map.containsKey(from)){
            map.put(from, new ArrayList<Edge<T>>());
        }
        map.get(from).add(new Edge<>(to, weight));

        if (!directed) {
            if (!map.containsKey(to))
                map.put(to, new ArrayList<Edge<T>>());
            map.get(to).add(new Edge<>(from, weight));
        }
    }
    public void put(T from, T to) {
        put(from, to, 1);
    }

    // check access from point A to B
    public boolean route(T from, T to) {
        boolean[] visited = new boolean[map.size()];
        return route(from, to, visited);
    }

    private boolean route(T from, T to, boolean[] visited) {
        if (from.compareTo(to) == 0)
            return true;
        visited[getIndex(from)] = true;
        ArrayList<Edge<T>> list = new ArrayList<>(map.get(from));
        for (int i = 0; i < list.size(); i++)
            if (key_check(list.get(i).getVertex(),to, list,visited) && route(list.get(i).getVertex(), to, visited))
                return true;
        return false;
    }

    private int getIndex(T key) {
        ArrayList<T> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++)
            if (keys.get(i).compareTo(key) == 0)
                return i;
        return -1;
    }

    private boolean value_check(T to, ArrayList<Edge<T>> list){
        for (Edge e: list)
            if (e.getVertex().compareTo(to) == 0)
                return true;
        return false;
    }

    private boolean key_check(T key,T to, ArrayList<Edge<T>> list, boolean[] visited){
        if (getIndex(key) < 0)
            return value_check(to, list);
        return !visited[getIndex(key)];
    }

    public String toString() {
        Object arr[] = (Object[]) map.keySet().toArray();
        String s = "";
        for (Object v : arr) {
            s += v.toString();
            s += " : ";
            s += map.get((T) v);
            s += "\n";
        }
        return s;
    }

    public void Common_friends(T from){
        ArrayList<Edge<T>> list = new ArrayList<>(map.get(from));
        for (int i=0; i<list.size(); i++){
            System.out.println(
                    list.get(i).getVertex() + " " + "("+ Common_friends(list.get(i).getVertex(), map.get(from))+ ")"
            );
        }
    }

    private int Common_friends(T from, ArrayList<Edge<T>> list){
        ArrayList<Edge<T>> new_list = new ArrayList<>();
        for (Edge<T> e : map.get(from))
            for (Edge<T> g : list)
                if (e.getVertex().compareTo(g.getVertex()) == 0) {
                    new_list.add(e);
                    break;
                }
        return new_list.size();
    }

}
