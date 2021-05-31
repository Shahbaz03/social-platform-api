# social-platform-api

A Spring Boot Application for basic APIs for a social media platform

The application uses an embedded MongoDB to persist the data. No external DB is needed.


Requirements:

* Java 1.8+
* Maven

To Run the Appliation
```bash
1. Please Clone the repo
2. mvn clean install (Root of the repo)
3. java -jar <snapshot>
```

To Run the Application on any IDE
```bash
1. Please Clone the repo
2. Open the Repo in any IDE
3. Run the SocialPlatformServiceStarter.java file
```


Access the swagger at

```bash
http://localhost:8080/swagger-ui.html
```

APIs currently Implemented

```bash
POST /users - Create User

GET /users - Fetch All Users

GET /users/{emailId} - Fetch Specific User

POST /status - Post a Status Update

POST /follow - Follow a User

GET /users/{emailId}/timeline - Get Posts of Followed Users
```

Things Left to Do

1. Unit Tests
2. Authnetication/Authorization

Scope for Improvement

1. Exception Handling