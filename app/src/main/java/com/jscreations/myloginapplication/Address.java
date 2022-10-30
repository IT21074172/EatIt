package com.jscreations.myloginapplication;

public class Address {

    private String addressname;
    private String addresstext;

    public Address(String addressname, String addresstext) {
        this.addressname = addressname;
        this.addresstext = addresstext;
    }

    public Address() {
    }

    public String getAddressname() {
        return addressname;
    }

    public String getAddresstext() {
        return addresstext;
    }
}
