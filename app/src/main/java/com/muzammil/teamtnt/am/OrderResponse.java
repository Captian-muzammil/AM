package com.muzammil.teamtnt.am;

import java.util.ArrayList;

class OrderResponse {
    public String message;
    public ArrayList<Order> data;

    public class Order {
        public int id;
        public int amount;
        public String outlet;
    }
}
