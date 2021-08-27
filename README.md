# userbase
Simple user repository that will store:
* First Name
* Last Name
* Email Address

## Build and Run
Latest version will be provided as .jar under Releases.

Download this file and open command line prompt to the containing directory.

Otherwise you will need to checkout the code repository and build yourself using Gradle.

For help on installing Gradle: [Spring Guides - Gradle](https://spring.io/guides/gs/gradle/)

From the root directory of the checked out project, run `./gradlew bootjar`

The file will be created in `.\build\libs`


For help on installing Java: [JDK Installation Overview](https://docs.oracle.com/en/java/javase/16/install/overview-jdk-installation.html)

Using command line prompt, navigate to the directory containing .jar file.

Execute the command `java -jar userbase-1.0.0.jar`

Once initialisation is complete, API endpoints will be available.

## API usage
### GET root list of all users
Endpoint [http://localhost:8081/users/](http://localhost:8081/users/)

### GET list of users with specified last name
Endpoint http://localhost:8081/users/{LastName}

e.g. [http://localhost:8081/users/Baggins](http://localhost:8081/users/Baggins)

### GET details of individual user from ID
Endpoint http://localhost:8081/users/user/{id}

e.g. [http://localhost:8081/users/user/1](http://localhost:8081/users/user/1)

### POST json payload of new user details
Endpoint http://localhost:8081/users/

Request body of JSON specifying the following Keys:

* firstName
* lastName
* emailAddress

e.g.
`{"firstName": "Peregrin", "lastName": "Took", "emailAddress": "pippin@whitwell.com"}`