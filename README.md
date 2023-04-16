
# Online Movie Streaming Platform

### Project Description:

The Online Movie Streaming Platform is a RESTful web-based platform that allows users to browse and stream movies and TV shows. The platform should have a user-friendly interface and a rich public REST API that allows users to search for content, create watchlists, and stream videos. The platform should also have features like personalized recommendations, ratings, and reviews.

### Technical Requirements:

The platform should be built using Spring Boot and Spring MVC as core tech stack to create a REST API that serves data to the front-end.
The platform should use Spring JPA to interact with H2 in memory database to store user and content data.
The platform should use third-party APIs like The Movie Database or IMDB to fetch movie and TV show data.  Any REST API client can be used to consume the information can be added, such as **OkHttp**.

### Implementation Notes:

No need to build the front-end app, the RESTful API should be agnostic, obey common patterns and best practices.  Anything related to tech stack, third party is not the main purpose but de Object-Oriented Design.  Streaming videos is not part of the scope, but we can provide an interface for any front-end client app, no matter the tech stack.

### User Stories:

As a user, I want to be able to create an account and login to the platform.

As a user, I want to be able to search for movies and TV shows by title, year, genre, and actor.

As a user, I want to be able to create a watchlist of movies and TV shows that I'm interested in.

As a user, I want to be able to rate and review movies and TV shows that I've watched.

As a user, I want to be able to receive personalized recommendations based on my viewing history.

As a user, I want to be able to stream movies and TV shows in high-quality and without buffering.

As an administrator, I want to be able to add new movies and TV shows to the platform and manage existing content.

As an administrator, I want to be able to view user ratings and reviews and use this information to improve the platform.

As an administrator, I want to be able to track user activity and usage patterns to improve the platform's performance and features.

### Object-Oriented Design:

To implement the Online Movie Streaming Platform, you can use object-oriented design concepts and principles like GRASP (and SOLID) to build a scalable and maintainable system.
UML diagrams, such as Use Cases, Class and Sequence diagrams are a nice to have deliverable.

### Testing:

You can use unit testing to ensure that your code is correct and robust.  You can also use integration testing tools like Postman.
