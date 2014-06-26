package com.oudmaijer.drools.fraud.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Stephan on 18-06-14.
 */
@XmlRootElement
public class Order {

    private Long orderId;
    private Seller seller;
    private Address shipmentAddress;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(Long orderId, Seller seller, Address shipmentAddress) {
        this.orderId = orderId;
        this.seller = seller;
        this.shipmentAddress = shipmentAddress;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
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
