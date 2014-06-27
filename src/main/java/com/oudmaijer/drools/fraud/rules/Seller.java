package com.oudmaijer.drools.fraud.rules;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Stephan on 19-06-14.
 */
@XmlRootElement
public class Seller {

    private Integer rating;

    public Seller() {
    }

    public Seller(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "rating=" + rating +
                '}';
    }
}
