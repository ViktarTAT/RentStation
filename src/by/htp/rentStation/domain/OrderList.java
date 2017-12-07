package by.htp.rentStation.domain;

import java.util.List;

public class OrderList {
    
    private Client clinent;
    private List<Order> orders;
    
    public Client getClinent() {
        return clinent;
    }
    public void setClinent(Client clinent) {
        this.clinent = clinent;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    
}
