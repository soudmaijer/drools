package com.oudmaijer.drools.fraud.model;

/**
 * Created by Stephan on 23-06-14.
 */
public class IsSellerRatingOk {

    private Seller seller;

    public IsSellerRatingOk(Seller seller) {
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
