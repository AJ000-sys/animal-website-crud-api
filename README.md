# su25-jpa-crud-api
## Description
Simple CRUD API for Bird Objects with JPA (Hibernate)

### Version
1.0.0

## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/AJ000-sys/animal-website-crud-api.git
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with jdk 21.
- [Dependencies](https://github.com/uncg-csc340/su25-jpa-crud-api/blob/3149ec363e4aae4baebe6f755df7d4c2d79c9d2c/pom.xml#L32) to JPA and Postgres in addition to the usual Spring Web. JPA handles the persistence, Postgresql is the database to be used.
- [`/src/main/resources/application.properties`](https://github.com/uncg-csc340/su25-jpa-crud-api/blob/main/src/main/resources/application.properties) This file  is the configuration for the PostgreSQL database to use for the API.
  - You MUST have the database up and running before running the project!
    - Login to your neon.tech account.
    - Locate your database project.
    - On the project dashboard, click on "Connect" and select Java.
    - Copy the connection string provided.
    - Paste it as a value for the property `spring.datasource.url`. No quotation marks.
- Build and run the main class. You should see a new table created in the Neon database.

## API Endpoints
Base URL: [`http://localhost:8080/birds`](http://localhost:8080/birds)


1. ### [`/`](http://localhost:8080/birds) (GET)
Gets a list of all Birds in the database.

#### Response - A JSON array of Bird objects.

```json
  {
    "birdId": 1,
    "name": "Crow",
    "description": "Intellegent, black birds",
    "breed": "Corvus",
    "age": 4
  }

  {
    "birdId": 2,
    "name": "Hawks",
    "description": "Birds of prey",
    "breed": "Accipiter",
    "age": 2
  }
```

2. ### [`/{birdId}`](http://localhost:8080/birds/1) (GET)
Gets an individual Bird in the system. Each Bird is identified by a birdId

#### Parameters
- Path Variable: `birdId` &lt;Long &gt; - REQUIRED

#### Response - A single bird

```json
  {
    "birdId": 1,
    "name": "Crow",
    "description": "Intellegent, black birds",
    "breed": "Corvus",
    "age": 4
  }
```
3. ### [`/name/{name}`](http://localhost:8080/birds/1) (GET)
Gets a list of birds with a name that contains the given string.

#### Parameters
- query parameter: `search` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Bird objects.

```json
[
  {
    "birdId": 1,
    "name": "Crow",
    "description": "Intellegent, black birds",
    "breed": "Corvus",
    "age": 4
  }
]
```
4. ### [`/description/{description}`](http://localhost:8080//birds/description/{description}) (GET)
Gets a list of birds by breed.

#### Parameters
- path variable: `description` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Bird objects.

```json
[
    {
    "birdId": 2,
    "name": "Hawks",
    "description": "Birds of prey",
    "breed": "Accipiter",
    "age": 2
  }
]
```
5. ### [`/breed/{breed}`](http://localhost:8080//birds//breed/{breed}) (GET)
Gets a list of birds by breed.

#### Parameters
- path variable: `breed` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Bird objects.

```json
[
    {
    "birdId": 2,
    "name": "Hawks",
    "description": "Birds of prey",
    "breed": "Accipiter",
    "age": 2
  }
]
```
6. ### [`/age/{age}`](http://localhost:8080//birds//age/{age}) (GET)
Gets a list of birds by age.

#### Parameters
- path variable: `age` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Bird objects.

```json
[
    {
    "birdId": 2,
    "name": "Hawks",
    "description": "Birds of prey",
    "breed": "Accipiter",
    "age": 2
  }
]
```