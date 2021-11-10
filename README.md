# How to run project
```
<Eclipse> 

1. install Spring Tools 4 from Eclipse Marketplace 

2. Run As Maven clean 
3. Run As Maven install 
4. Run As Spring Boot App

<VS Code>

1. Run command 

Install Extension  

1. Java Extension Pack
2. Lombok Annotaions Support for VS Code
3.  run command ` ./mvnw spring-boot:run `


2. Run By Spring Boot Dashboard 

Install Extension  

1. Lombok Annotaions Support for VS Code
2. Spring Boot Dashboard
3. Spring Boot Tools 
4. Spring initializr Java Support
5. Run By Spring Boot Dashboard 
```

# CuRL Script

## POST: /login
```
curl --location --request POST 'http://localhost:8080/login' \
--header 'Content-Type: application/json' \
--data-raw '{   
    "username": "john.doe",
    "password": "thisismysecret"

}'
```

## GET: /users
```
curl --location --request GET 'http://localhost:8080/users' \
--header 'Authorization: Bearer <-- Your Login Token -->'
```

## DELETE: /users
```
curl --location --request DELETE 'http://localhost:8080/users' \
--header 'Authorization: Bearer <-- Your Login Token -->'
```

## POST: /users
```
curl --location --request POST 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{   
    "username": "john.doe",
    "password": "thisismysecret",
    "date_of_birth": "15/01/1985"
}'
```

## POST: /users/orders
```
curl --location --request POST 'http://localhost:8080/users/orders' \
--header 'Authorization: Bearer  <-- Your Login Token -->' \
--header 'Content-Type: application/json' \
--data-raw '{"orders": [1, 4]}'
```

## GET: /books
```
curl --location --request GET 'http://localhost:8080/books'
```
