package com.company;

public class Supply {
    private String name;
    private int quantity;
    private int inPlate;

    public Supply(){}
    public Supply(String name) { this.name = name; }
    public Supply(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;

    }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void add(int amount){
        quantity += amount;
    }


    public void feed(int toFeed) {
        inPlate += toFeed;
        quantity -= toFeed;
    }
}
