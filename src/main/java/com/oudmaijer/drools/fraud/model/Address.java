package com.oudmaijer.drools.fraud.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Stephan on 19-06-14.
 */
@XmlRootElement
public class Address {

    private String zip;
    private int houseNumber;

    public Address() {
    }

    public Address(String zip, int houseNumber) {
        this.zip = zip;
        this.houseNumber = houseNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (houseNumber != address.houseNumber) return false;
        if (!zip.equals(address.zip)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zip.hashCode();
        result = 31 * result + houseNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zip='" + zip + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
