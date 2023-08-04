# event-driven-architecture

Microservice communication through events.
When user is deleted, the orders of that user will also be deleted through a kafka event.

**Usage**

1.  In spring boot terminal go to \kafka-project\Order and run the project with the following command: ./gradlew bootRun.
2.  Do the same for Product and User.
3.  Open a terminal in the kafka-project folder and run docker with the follwoing command: docker-compose up --build
4.  Endpoints:

                http://localhost:8083/api/v1/orders

                http://localhost:8083/api/v1/orders/details

                http://localhost:8083/api/v1/products

                http://localhost:8082/api/v1/users

                http://localhost:8081/api/v1/shopping-cart

5.  Delete a user and check that the orders of that user were deleted.
