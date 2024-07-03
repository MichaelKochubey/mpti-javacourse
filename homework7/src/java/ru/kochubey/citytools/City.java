package ru.kochubey.citytools;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private ArrayList<Road> roads;
    public City(String name) {
        this.name = name;
    }

    public City(String name, ArrayList<Road> roads) {
        this.name = name;
        this.roads = new ArrayList<Road>(roads);
    }

    public void setRoads(List<Road> roads) {
        this.roads = new ArrayList<Road>(roads);
    }
    public void addRoad(Road road) {
        for (Road r : roads) {
            if (r.getTo().equals(road.getTo())) throw new IllegalArgumentException("ru.kochubey.Road should not be duplicated");
        }
        this.roads.add(road);
    }
    public void deleteRoadByIndex(int index) {
        this.roads.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Road r : roads) {
            sb.append(r.getTo().name + " : " + r.getPrice() + ", ");
        }
        return "{" + name + ": [" + sb.toString() + "]}";
    }
}
