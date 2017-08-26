# StarbucksOrderingPortal
Starbucks drink ordering portal based on Restbucks CRUD REST API design.

![ScreenShot](https://raw.github.com/shiva322/StarbucksOrderingPortal/master/starbucks_stores.png)

### Overview 

- The Frontend of Starbucks sends REST calls to middleware KONG Gateway which is backed by 3-Node Cassandra cluster. The KONG routes the REST calls to respective tenant backends which are independent Starbucks store.
 
- Frontend of our app is written in Angular JS. It has: 

(i)  home page  - can select Store 1, Store 2, Store 3.

(ii) home page of selected Store - can select and add products to cart.

(iii) cart page - add/remove item in cart, update size/quantity. Once products are confirmed, order status changes to PLACED, and overtime it changes to PREPARING, SERVED and COLLECTED.

(iv) order page - can view order id and status of order.

- The Middleware is implemented through KONG API Gateway.The Gateway routes the calls to respective Backend Microservice to handle the request.

- The Backend of Starbucks is writtten in JAVA to handle CRUD operations on resources. It is backed by 3 Node Mongo-DB cluster.



### Run the Application

We have preconfigured the project with a simple development web server. The simplest way to start
this server is:

```
npm start
```

Now browse to the app at [`localhost:8000/index.html`][local-app-url].


