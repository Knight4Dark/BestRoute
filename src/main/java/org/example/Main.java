package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {


    public static void main(String[] args)
    {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        restaurants.add(new Restaurant("R1",20,new GeoPoint(1.00,2.00)));
        restaurants.add(new Restaurant("R2",10,new GeoPoint(2.00,3.00)));
        customers.add(new Customer("C1",new GeoPoint(3.00,4.00)));
        customers.add(new Customer("C2",new GeoPoint(4.00,5.00)));
        orders.add(new Order(customers.get(0),restaurants.get(0)));
        orders.add(new Order(customers.get(1),restaurants.get(1)));

        Driver driver = new Driver("driver",new GeoPoint(0.00,0.00));

        ArrayList<User> ans;
        ans = BestRoute.getBestRoute(orders,driver);
        for (User an : ans) {
//            System.out.println("this is the ans");
            System.out.println(an.getName());
        }

    }
}