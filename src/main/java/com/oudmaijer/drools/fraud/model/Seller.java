package com.oudmaijer.drools.fraud.model;

/**
 * Created by Stephan on 19-06-14.
 */
public class Seller {

    private Integer rating;

    public Seller(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "rating=" + rating +
                '}';
    }
}
