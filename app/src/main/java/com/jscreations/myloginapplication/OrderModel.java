package com.jscreations.myloginapplication;

public class OrderModel {

    String orderName;
    String riderName;
    String specialInstructions;


    public OrderModel(){}

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public OrderModel(String orderName, String riderName, String specialInstructions) {
        this.orderName = orderName;
        this.riderName = riderName;
        this.specialInstructions = specialInstructions;
    }
}
