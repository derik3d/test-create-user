# Test - Users creation
User creation test repo using spring boot.

## H2 db
Get into the in memory db with user sa and no pass on /h2-console

## API doc
Api doc on /v3/api-docs/ or /swagger-ui.html for better visualization

## Db schema
Db schema is located on target/sql as create.sql, to get it extracted run mvn with target properties file application-db.properties

## How to execute project
- Execute on terminal, "mvn clean install" on project folder to generate jar
- On the terminal, run jar with this command "java -jar myusersapp-0.0.1-SNAPSHOT.jar"

## Diagram of the application

### EndPoints

```text
┌──────────────┐
│UserController│
│/api/v1       │
├──┬───────────┘
│  │
│  │   ┌──────────────┐
│  └─► │GET/welcome   │  (Ignore this)
│      └──────────────┘
│
│      ┌──────────────┐
└────► │POST/user     │
       └──────────────┘
       
```  
       
### Data flow through app (POST/user)

```text    
   
         (Data validation error)    ┌────────────┐
 ◄───────────────────────────────── │ErrorFormat │
                                    └────────────┘
                                           ▲
                                           │
                                    ┌──────┴───────┐
                                    │UserController│
                                    └──────────┬───┘
                                             ▲ │
                                             │ ▼          Transform
(incoming   ┌─────────────────┐        ┌─────┴─┐          ┌─────┐        ┌───────────────┐
 request)   │CreateUserRequest│ │      │@Valid │      ┌►  │User ├─┐  ┌───┤UserRepository │
            └─────────────────┘ │      └───────┘      │   └─────┘ │  │   └───────────────┘
 ─────►                         └──►   Validate       │           │  │
            ┌──────────────────┐    ─────────────────►    ┌─────┐ │  │   ┌───────────────────┐
            │CreatePhoneRequest│ ┌─►                  │   │Phone├─►  │ ┌─┤PhoneRepositoryUser│
            └──────────────────┘ │                    └─► └─────┘ │  │ │ └───────────────────┘
                                                                  │  │ │
                                                                  │  │ │
                                                                  ▼  ▼ ▼
                                                             ┌───────────┐
                                                             │UserService├────────┐
                                                             └───────────┘        │
                                                                                  │
                                                                                  │
    (sucessful res)  ┌───────────────────┐                       (Ok)           │
 ◄───────────────────┤UserCreatedResponse│◄─────────────┐ ┌─── ◄────────┐         │
                     └───────────────────┘              │ │             │         │
                                                        │ │             │         │
                                                        │ │             │         │
                                                        │ ▼             │         │
                                             ┌──────────┴───┐                     ▼
                                             │UserController│        Validate integrity
                                             └──────────┬───┘
                                                        │ ▲             │
                                                        │ │             │
                                                        │ │             │
       (after db error)     ┌────────────┐              │ │    (Fail)   │
 ◄──────────────────────────┤ErrorFormat │ ◄────────────┘ └─────────────┘
                            └────────────┘
       
```