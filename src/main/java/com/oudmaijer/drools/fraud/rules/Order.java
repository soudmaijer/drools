package com.oudmaijer.drools.fraud.rules;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Stephan on 18-06-14.
 */
@XmlRootElement
public class Order {

    private String orderId;
    private Seller seller;
    private Address shipmentAddress;
    private List<OrderItem> orderItems;
    private String paymentType;

    public Order() {
    }

    public Order(String orderId, Seller seller, Address shipmentAddress) {
        this.orderId = orderId;
        this.seller = seller;
        this.shipmentAddress = shipmentAddress;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Address getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(Address shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", seller=" + seller +
                ", shipmentAddress=" + shipmentAddress +
                ", orderItems=" + orderItems +
                '}';
    }
}
