package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BestRoute {

    public static void recur(Double time, Double minTime, ArrayList<User> nodes, ArrayList<User> ans, ArrayList<User> Route, User curnode,
                             HashMap<User,User> orderMap, HashSet<User> vis)
    {
//        System.out.println(minTime + " " + time + " "+ vis.size() + " "+ nodes.size() );


        if(vis.size() == nodes.size() && minTime > time)
        {
            minTime  = time;
            if(ans.size() == 0)
            {
                for(int i=0;i<Route.size();i++)
                ans.add(Route.get(i));
            }
            else
            {
                for(int i=0;i< Route.size();i++)
                {
                    ans.set(i,Route.get(i));
                }
            }
//            System.out.println(ans.size());
            return;
        }
        for(int i=0;i<nodes.size();i++)
        {
            if(!vis.contains(nodes.get(i)))
            {
                // customer restaurant should be visited
                if(orderMap.containsKey(nodes.get(i)) && vis.contains(orderMap.get(nodes.get(i))))
                {
//                    System.out.println("added node is" + nodes.get(i).getName());
                    vis.add(nodes.get(i));
                    Route.add(nodes.get(i));
                    double addedtime = HaversineDistance.calculateTime(nodes.get(i).getLocation(),curnode.getLocation());
                    recur(time+addedtime,minTime,nodes,ans,Route,nodes.get(i),orderMap,vis);
                    vis.remove(nodes.get(i));
                    Route.remove(Route.size()-1);
                }
                else if(!orderMap.containsKey(nodes.get(i)))
                {
//                    System.out.println("added node is" + nodes.get(i).getName());
                    double reachTime  = time + HaversineDistance.calculateTime(nodes.get(i).getLocation(),curnode.getLocation());
                    time = reachTime>((Restaurant)nodes.get(i)).getPrepTime() ? reachTime : ((Restaurant)nodes.get(i)).getPrepTime();
                    vis.add(nodes.get(i));
                    Route.add(nodes.get(i));
                    recur(time,minTime,nodes,ans,Route,nodes.get(i),orderMap,vis);
                    vis.remove(nodes.get(i));
                    Route.remove(Route.size()-1);
                }

            }

        }

    }
    public static ArrayList<User> getBestRoute(ArrayList<Order> orders,Customer driver)
    {
        HashMap<User, User> orderMap = new HashMap<>();
        ArrayList<User> nodes = new ArrayList<>();
        ArrayList<User> Route = new ArrayList<>();
        ArrayList<User> ans = new ArrayList<>();
        HashSet<User> vis = new HashSet<>();
        for(Order i :orders)
        {
            orderMap.put(i.getCustomer(),i.getRestaurant());
            nodes.add(i.getCustomer());
            nodes.add(i.getRestaurant());
        }
        Double minTime = Double.MAX_VALUE;
//        System.out.println(minTime>0.0);

        recur(0.00,minTime,nodes,ans,Route,driver,orderMap,vis);
        System.out.println("minimum time is "+minTime);
        return ans;
    }
}
