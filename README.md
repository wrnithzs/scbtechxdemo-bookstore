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
