# Eurowings-Newsletter-Subscription

The project provides a RESTful API to manage the newsletter subscription service.

For the backend an embedded H2 Database is used. Project data is initialized upon application start-up using the resources/data.sql.

Technology Used:
- Spring Boot
- Java8
- H2 Database
- Maven
- Swagger
- Eclipse

Assumptions: 
- The user is allowed to take the newsletter once he is subscribed., So for the service is provide the below functionality:
  - Subscribe a user
  - Unsubscribe a user
  - Get the status (subscribed/unsubscribed) of a user. (Once he is subscribed, so he must receive the new letter)
  - list all users by status.
  - list all users subscribed before a given date.
