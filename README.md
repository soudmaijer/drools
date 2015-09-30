drools
======

Spring boot drools demo app

## How to run

```
mvn spring-boot:run 
```

## Using

Try the drools offer check using the following URL:

Go to the Swagger API page: [http://localhost:8080/sdoc.jsp#!/fraud/checkOrder](http://localhost:8080/sdoc.jsp#!/fraud/checkOrder)

Paste the following offer:

```json
{
    "offerId": "1",
    "seller": {
        "rating": "3"
     }
}
```
