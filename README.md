The problem is to deliver the order batch in the minimum amount of time 
For that we used backtracking algo to find out the time taken for the possible and feasible paths and compared them to get the minimum time and the path to follow it

Assumptions :
1. Each person can order from only one restaurant
2. If a restuarant gets multiple orders they all will be finished in the given preptime only
3. preptime in mins and distance in km

Algo steps
1. Create a List Containing all the nodes we need to visit (Restuarant,Customer) , Driver node is the starting point
2. using for loop we check all the possible nodes he can visit from the current node and check if going to that node is feasible (driver can go to customer only after getting his food i.e visiting the restaurant)
3. We then go to the feasible nodes and we keep track of the time it is taking (time to reach node , time to wait if any at the restaurant) and also the path followed
4. we then compare the time with minTime and if it is less we store the time and its path in the answer
5. after the full recursion and going through all paths we get the optimum path and time for our delivery

This is the brief idea on the algo for the problem
You can refer to process.txt file in org.example folder for all the definitions of functions and variables used in the algo
