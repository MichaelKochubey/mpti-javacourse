package ru.kochubey.citytools;

public class Road {
    private City to;
    private int price;
    public Road(City to, int price) {
        this.to = to;
        this.price = price;
    }

    public City getTo() {
        return to;
    }
    public void setTo(City to) {
        this.to = to;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}

