package com.company;

public class City implements Comparable<City> {
    private String name;
    private int ill;

    public City(String name, int ill) {
        this.name = name;
        this.ill = ill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIll() {
        return ill;
    }

    public void setIll(int ill) {
        this.ill = ill;
    }

    @Override
    public int compareTo(City o) {
        if (name.equals(o.name))
            return 0;
        return -1;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", ill=" + ill +
                '}';
    }
}
