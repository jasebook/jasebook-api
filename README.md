## Acebook

### Instructions
Install docker app and open it.

In order to run our database you need to cd into Docker and run: ```docker-compose up -d``` command 
to pull the docker image running postgresql engine. This has to be done everytime you reboot your machine.

In TablePlus, connect to your postgres databse engine running on port 54320 as defined in docker-compose.yml file
and create the database - this will only need to be done once with the following command:
```CREATE DATABASE "jasebook-dev";```


This is a java/springboot and react project to be developed on.

It uses:
  - `maven` to build the project
  - `webpack` to bundle the javascript
  - `thymeleaf` to serve `index.html`
  - `react` to make requests to the api and render the component views
  - `flyway` to manage `postgres` db migrations

### Card wall

REPLACE THIS TEXT WITH A LINK TO YOUR CARD WALL

### Design

This app has a somewhat typical API structure: in this case a springboot API serving data which a react frontend consumes.

**IMPORTANT:** Test your understanding by diagramming the request/response cycles that occur when you load the app by visiting `localhost:8080`

### Learning Plan

This project will ultimately be really rewarding if you follow these three points:
  1. **Work as a team.** Don't be tempted to split up to learn solo. At the very least pair on learning, and share knowledge as a team.
  2. As a team, **plan your learning**. There's a ton of new things in this project, purposefully so. That's ok. As always with everything, **take it slowly & in small steps**: ask a coach if you want more ideas how to plan your team learning.
  3. As an individual, **plan your learning**. Use `Diode` to keep yourself focused on setting and achieving your learning goals.

### QuickStart Instructions

- Fork and clone this repository to your machine
- Use an IDE, like `intellij`, and select the project directory to load into the editor (you may need to set the source folder in the project settings)
- From the command line create a dev database `createdb acebook_springboot_development`
- Install Maven `brew install maven`
- Build the app and start the server, using the Maven command `mvn spring-boot:run`
- Visit `localhost:8080`

- Temporarily, if you want to add some posts you can use `curl` to post data to the API and then refresh the page.
```
curl -X POST 'localhost:8080/api/posts' -d '{"content": "Hi, Folks!"}' -H 'Content-Type: application/json'
```

(At some point a form would be implemented sends data to the API)

### Database

Flyway is being used to manage your database migrations. Use the flyway docs to become familiar how to migrate your data.

### Deployment

- This template application is hosted on heroku at https://springboot-react-template.herokuapp.com/
- Have a look at `application.properties`, `application-dev.properties` and `application-prod.properties`
- The first line in `application.properties` specifies that the application is run using the config in `application-dev.properties`.
- The config in `application-dev.properties` specifies that the development datebase be used.
- This ensures that you do not manipulate the production database whilst developing new features.
- Before deploying your application, you'll need to add some config to `application-prod.properties` so that the deployed application uses the production database.
- Then, make sure the deployed app will use `application-prod.properties` by using `spring.profiles.active=dev` in your deployment script.

### CI/CD

Travis is our CI tool - runs the tests behind the scenes using `mvn test -B command` by default. 
Linked to your GitHub account. 

Every pull request triggers it to run build and tests.
At the moment `travis.yml` is only set up to run unit tests for java code but we are working on the set up for running feature tests in js.

We implemented test coverage functionality by using JaCoCo that generates reports. They can be found in the temporary directory `target` created by the maven build.
Coveralls also connected to Github, is an online tool that keeps track of how code coverage changes over each build. The integration of Coveralls and Travis has proved challenging.
Most of this set up has to be done by managing dependencies and plugins via pom.xml file. 

Travis is also a middle man for deploying the production version of the application to Heroku that hosts it on the cloud.
[Our App in Prod](https://jasebook.herokuapp.com/)
Heroku creates a PostgresQL database for our application by detecting a reference to it in our code out of the box which was a nice surprise.

### Testing
Maven runs most of our tests.

To run the feature and integration tests, you must start Cypress:

```npm run cypress:open ```

Cypress is a react native app that can visit your website, click links, buttons, fill in text boxes etc.
It come with nice documentation and scripting language for writing feature tests that can be tracked in a browser.
When you first run it, it runs example tests that can be deleted and leaves the folder structure.

`cy-data` is a property that can be set on html tag and then referred to by feature tests. 


### Gochas

webpack does not deposit the bundle in the target directory where the running spring instance reads it's static resources. You must copy it over yourself from 
'src' to 'target' if you wish for react changes to be seen without a reboot of spring


Mark resources directory as test sources root to make intellij know they are being used.

#### Other Learnings

- `npm update` - when run inside your project, it updates the versions of the packages in package.json file.
You should run `npm install ` after that.
- @Data annotation is a part of lombok plugin and provides invisible getters and setters
- to manage spring active profiles we added application.properties file in the `test` directory
- React:
  -  you need a wrapping `<div>` around your components
  - `super` in a constructor is referring to a class that is being extended
  - `state`: data within a component; it is set up in a constructor, any change in state causes the component to be rerendered
  - function callback, `function() {}` behaves differently to `() => {}`
  - <=>binding - binding a value of an element to a value of the state of the component the element is in; if one changes the other one will change as well
  - axios in react is like ajax in js
  - remember to prevent default behaviour on a single page app
- Spring:
  - There is a lot of magic in the air
  - Our timestamp is created by the server and not the database
  - @Query annotation executes SQL queries and the method's name, below the annotation, can be formatted as a query
  - the default api endpoints are added by the `spring.data.rest.base-path=/api` in application.properties
 - SQL:
  - Do not use `bigserial` as a datatype for a foreign key column as it auto-generates and auto-increments numbers!
  
 
 ### Progress in Team :) 
 
Disconnected in Week 1  **-------->** Better teamwork in Week 2
     
     - Sitting apart  ---->  Sitting together
     - Not planning our time properly  ---->  Planning meeting and regular stand-ups using Trello
     - Individual work  ---->  Pairing twice a day and sharing knowledge
     - Not sharing thoughts and feelings with other members of the team  ---->  Better/More 
     comfortable communication
 
 These elements created an uncomfortable atmosphere/awkwardness in the team in week 1 when we met. Tension was likely getting in the way of progress.
 
 The Friday afternoon was a turning point after a planning meeting. We looked at the Trello board, prioritised tickets and made decisions as a team like choosing to use 
 `REACT` instead of `Java, HTML and Thymeleaf` on the front end for example.
 We reflected on the week and gave each other the chance to voice concerns and offer up small ways to make things easier.
 
  ![Board](/65675779_497652997638323_5096544386846556160_n.jpg)
Format: ![Alt Text](https://github.com/jasebook/jasebook-api/blob/master/64916106_2346387452291206_1749866497838153728_n%20(1).jpg)

 ### :( 
 
    - Spring magic
    - Using the seed project
    - Uncomfortable meetings (week 1)
    - Not following processes we have learnt so far (TDD, debugging, etc.)
    - Pairing was difficult
 
 
 #### Things we learnt: 
 
    - You can't just assume team members will just know that you need more support.
        - Team members won't know you don't understand if you don't make it clear.
    - Become more aware of different styles of pairing as too many unknowns made it hard to pair effectively.
    - Learn what annotations do before using them.
    - Use comments to describe/explain what annotations do so other members of the team can clearly see.
    - Write tests on behaviour of the program to understand annotations better.
    - Write our own project from scratch.
        - Avoid using Spring (for next time).
    - Check in and time-box more often. Also have a mid-week planning meeting to keep us on track.
    
