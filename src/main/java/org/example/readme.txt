Assuming each customer orders from only one restuarant  and if a restuarant gets multiple orders there are completed in the given preptime only
preptime in mins
distance in km


Process / algo

Basically first created the classes for the restuarants and the customer
created a function to calculate the distance and time taken to reach from location a to location b
next made list of all the restaurnt and customers called nodes
made a ordermap which maps the customer to the restuarant
next intialized a visted set, a temporary route array , and a ans array
the visited set -> keeps track of the visited nodes (list of restuarants and customers)
route arraylist -> keeps track of the current path (it is a list nodes we visited)


getBestRoute function :
created a function which gives us the best route and also the minimum time required to go through the path -> getBestRoute
this method calls the recur method

recur function:
created a function which takes the visited set, route arraylist , ordermap , time , mintime values called recur

using this function , i recursively go to the all possible nodes from my current node and check if it is feasible to go to that node if yes continue the
recursion till you finish all the elemnts in the node arraylist , while going to the nodes we keep track of the time takes to reach the node
if the node is customer we just add the time taken to go there
if the node is restuarant we need to check the time taken to reach the restaurant and also the time taken for the restuarant to prepare the food

with this time we check for minimum value , if we encounter a value lesser than the current minTime we update the minTime and also tha path for it whicg
we have been storing in the Route array

Steps
1. create objects for restuarant , customer, order
2.create a node array which has all the restuarants from where a order has been placed and also the customers who have placed the orders
3. create a orderMap which will map the customer to the restuarant
4.we create a visited set to have all the visited nodes
5. we find the smallest time path using dfs from the driver/delivery node

Dry Run
1. From Delivery node we have 4 options R1,R2,C1,C2  using for loop over node array and go to unvisited node-> here we check wehther we can go to that node or not
2. we can go to R1,R2 , but we cant go to C1 or C2 , because for us to go to a customer we need to get his order first , this we check using the ordermap
   and visited set
3.do the step 2 continously till you visit all the nodes in the array
4. after reaching to the end we check the time taken to minTime and if it is less we set the ans path to the current Route
5. else we just backtrack and go to other possibilities.
6.After all the possibilities  we have the minTime and its path in ans
7. we return the ans and minTime