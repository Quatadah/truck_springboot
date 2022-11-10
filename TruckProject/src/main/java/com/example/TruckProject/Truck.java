package com.example.TruckProject;

public class Truck {
    private int truckId;
    private double ts;
    private  Position position;

    public int getTruckId() {
        return truckId;
    }

    public double getTs() {
        return ts;
    }

    public Position getPosition() {
        return position;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setTs(double ts) {
        this.ts = ts;
    }
}
