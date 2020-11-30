package com.company;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


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

//    Task A

    public int countOfSubscribers(T myAccount, T myFriend){
        ArrayList<Edge<T>> values =  new ArrayList<>(map.get(myFriend));
        for(Edge e :values){
            if (e.getVertex().compareTo(myAccount) == 0){
                return ((Account)myFriend).getSubscribers();
            }
        }
        return 0;
    }

    public Account find_account(){
        ArrayList<T> keys = new ArrayList<>(map.keySet());
        Collection<ArrayList<Edge<T>>> values = map.values();
        System.out.println(values);
        int sum = 0, maxSubscribers = 0;
        String name = "";
        for (T i :keys){
            sum = ((Account)i).getSubscribers();

            for (T k : keys){
                sum+= countOfSubscribers(i, k);
            }
            if(sum > maxSubscribers){
                maxSubscribers = sum;
                name = ((Account)i).getName();
            }
            sum = 0;
        }
        Account a = new Account(name, maxSubscribers);
        return a;
    }

// Task B

    public void ambulance(T from, int oil){
        ArrayList<T> list = ambulance(from, from, oil);
        int ill = 0;

        for (int i = list.size() -1; i != -1; i--){
            System.out.print(((City)list.get(i)).getName() + " => ");
            ill += ((City)list.get(i)).getIll();
        }System.out.print(ill + " is maximum\n");
    }

    private ArrayList<T> ambulance(T from, T back, int oil){
        ArrayList<ArrayList<T>> all_route = new ArrayList<>();
        ArrayList<Edge<T>> list = new ArrayList<>(map.get(from));
        ArrayList<T> optimal_route = new ArrayList<>();

        for (Edge<T> e : list)
            if (e.getVertex().compareTo(back)!=0 && e.getWeight() <= oil)
                all_route.add(ambulance(e.getVertex(), from, oil - e.getWeight()));

        if (all_route.size() != 0)
            optimal_route.addAll(optimal(all_route));

        optimal_route.add(from);
        return optimal_route;
    }

    private ArrayList<T> optimal(ArrayList<ArrayList<T>> route){
        int max = -1;
        int max_index = 0;
        for (int i=0; i<route.size(); i++)
            if (max_treat(route.get(i)) > max){
                max = max_treat(route.get(i));
                max_index = i;
            }
        return route.get(max_index);
    }

    private int max_treat(ArrayList<T> list){
        int ill = 0;
        for (T city : list)
            ill += ((City)city).getIll();
        return ill;
    }


    @Override
    public String toString() {
        return  map + " ";
    }
}
