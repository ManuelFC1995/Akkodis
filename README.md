# AppController 

The `AppController` is a REST controller responsible for handling product price-related requests. It is annotated with `@RestController` and mapped to the `/prices` route using `@RequestMapping`.

## Dependencies

The controller relies on the `ProductService`, which is injected through the constructor. Make sure to provide a valid implementation of `ProductService` when instantiating `AppController`.

## Endpoints

The controller defines the following endpoints:

### Get Price

This endpoint receives a validated `ProductRequest` through the `@Validated` annotation. The request should include the following fields:

- `productId`: the ID of the requested product.
- `brandId`: the ID of the product's brand.
- `date`: the date in a valid format.

If the date does not have a valid format, an error response with a status code of 400 (Bad Request) is returned.

If the request is valid, the `getProduct` method of the `ProductService` is called to retrieve the corresponding `Prices` object. If a valid price is found, a response with a status code of 200 (OK) and the `Prices` object in the response body is returned. If no valid price is found, a response with a status code of 204 (No Content) is returned.

In case of an error during the price retrieval, a response with a status code of 500 (Internal Server Error) is returned.

## Logging

The controller utilizes the `Slf4j` logging framework to log information and errors. Log messages are sent through the logger associated with the controller.

Make sure to configure the appropriate logging configuration to capture the log messages generated by the controller.

## Usage Example

Here's an example of how you can use the microservice to retrieve product prices using a curl request:
# Ejemplos de Uso

En este archivo encontrarás una serie de ejemplos de uso que te ayudarán a probar y comprender el funcionamiento de la aplicación. Los ejemplos consisten en solicitudes cURL que puedes ejecutar desde la línea de comandos para obtener información sobre los precios de productos.

Cada ejemplo representa una petición a la API de la aplicación, utilizando diferentes combinaciones de fecha, ID de producto y ID de marca. Estos ejemplos te permitirán familiarizarte con la estructura de las solicitudes y observar las respuestas correspondientes.

A continuación, se presentan los ejemplos de uso disponibles:
- Test 1: petición a las 10:00 del día 14 del producto 35455 para la marca 1 (ZARA)

    ```
    curl --location 'http://localhost:8080/prices?date=2020-06-14%2010%3A00%3A00&productId=35455&brandId=1'
    ```

- Test 2: petición a las 16:00 del día 14 del producto 35455 para la marca 1 (ZARA)

    ```
    curl --location 'http://localhost:8080/prices?date=2020-06-14%2016%3A00%3A00&productId=35455&brandId=1'
    ```

- Test 3: petición a las 21:00 del día 14 del producto 35455 para la marca 1 (ZARA)

    ```
    curl --location 'http://localhost:8080/prices?date=2020-06-14%2021%3A00%3A00&productId=35455&brandId=1'
    ```

- Test 4: petición a las 10:00 del día 15 del producto 35455 para la marca 1 (ZARA)

    ```
    curl --location 'http://localhost:8080/prices?date=2020-06-15%2010%3A00%3A00&productId=35455&brandId=1'
    ```

- Test 5: petición a las 21:00 del día 16 del producto 35455 para la marca 1 (ZARA)

    ```
    curl --location 'http://localhost:8080/prices?date=2020-06-16%2021%3A00%3A00&productId=35455&brandId=1'
    ```

## Repository

You can find the source code of this application in the following GitHub repository:

[Akkodis Repository](https://github.com/ManuelFC1995/Akkodis)
