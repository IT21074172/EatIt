package com.jscreations.myloginapplication;

public class Item {
    private String itemname;
    private String price;
    private String description;

    public Item(String itemname, String price, String description) {
        this.itemname = itemname;
        this.price = price;
        this.description = description;
    }

    public Item() {
    }



    public String getItemname() {
        return itemname;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
