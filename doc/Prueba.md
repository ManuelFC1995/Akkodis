# Servicio de Consulta de Precios

Este repositorio contiene una aplicación/servicio desarrollado con Spring Boot que provee un endpoint REST para la consulta de precios. La aplicación utiliza una base de datos en memoria H2 e se inicializa con datos de ejemplo.

## Esquema de la Tabla

En la base de datos de comercio electrónico de la compañía, disponemos de una tabla llamada PRICES que refleja el precio final (PVP) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla con los campos relevantes:

PRICES
-------

BRAND_ID   | START_DATE             | END_DATE               | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE  | CURR
-----------|------------------------|------------------------|------------|------------|----------|--------|------
1          | 2020-06-14-00.00.00    | 2020-12-31-23.59.59    | 1          | 35455      | 0        | 35.50  | EUR
1          | 2020-06-14-15.00.00    | 2020-06-14-18.30.00    | 2          | 35455      | 1        | 25.45  | EUR
1          | 2020-06-15-00.00.00    | 2020-06-15-11.00.00    | 3          | 35455      | 1        | 30.50  | EUR
1          | 2020-06-15-16.00.00    | 2020-12-31-23.59.59    | 4          | 35455      | 1        | 38.95  | EUR

**Campos:**

- `BRAND_ID`: foreign key de la cadena del grupo (1 = ZARA).
- `START_DATE`, `END_DATE`: rango de fechas en el que aplica el precio tarifa indicado.
- `PRICE_LIST`: Identificador de la tarifa de precios aplicable.
- `PRODUCT_ID`: Identificador código de producto.
- `PRIORITY`: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
- `PRICE`: precio final de venta.
- `CURR`: iso de la moneda.

## Endpoint del Servicio

El servicio provee un endpoint REST para la consulta de precios. Acepta los siguientes parámetros de entrada:

- `fecha`: fecha de aplicación.
- `productId`: identificador de producto.
- `brandId`: identificador de cadena.

Los datos de salida incluyen:

- `productId`: identificador de producto.
- `brandId`: identificador de cadena.
- `tarifa`: tarifa a aplicar.
- `fechas de aplicación`: fechas de aplicación.
- `precio final a aplicar`: precio
