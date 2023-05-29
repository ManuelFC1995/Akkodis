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
