# DEMO JAVA API #

This is a project to explore and demonstrate the layering that can be implemented in a microservice / API using Java and
Spring. Along with this, researching the annotations provided by the Spring framework and what they can unlock.

Using a local `postgresql` database, the API manages a list of students, giving the client CRUD options with the data.

The structure of the project is as follows:

* `Controller Layer`
    * Receives and routes requests
* `Service Layer`
    * Takes commands from `Controller` and arranges appropriate implementation via the `Repository`
* `Repository`
    * Sends and receives data directly from database.

The API uses an [imported library](https://github.com/wimdeblauwe/error-handling-spring-boot-starter) to send readable
error messages to the user, along with logging the appropriate data.

### API REQUESTS ###

`GET`
http://localhost:8080/api/v1/student will return the list of students. <BR>
`POST` http://localhost:8080/api/v1/student with a JSON request body of e.g.

``` 
{
    "name": "dave",
    "email": "dave@example.com",
    "dob": "1960-01-01"
}
```

will add a new student to the database. <BR>
`DELETE` http://localhost:8080/api/v1/student/{id} will delete the student with id = {id}. <BR>
`PUT` http://localhost:8080/api/v1/student/{id}?name={name}&email={email} will update student with id = {id} with a new
{name} and {email}. 

24.05.2022 Update

* As this is a demo project, TDD has not been followed to allow for exploratory learning.
    * Testing shall now be implemented for:
        * Unit tests on the service and model classes.
        * Integration tests on the repository and data access classes.
        * Acceptance test on the overall application.