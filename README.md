# AppController

El controlador `AppController` es un controlador REST que maneja las solicitudes relacionadas con los precios de productos. Está anotado con `@RestController` y mapeado a la ruta `/prices` utilizando `@RequestMapping`.

## Dependencias

El controlador depende de `ProductService`, que se inyecta a través del constructor. Asegúrate de proporcionar una implementación válida de `ProductService` al crear una instancia de `AppController`.

## Endpoints

El controlador define los siguientes endpoints:

### Obtener precio


Este endpoint recibe una solicitud `ProductRequest` validada a través de la anotación `@Validated`. La solicitud debe contener los siguientes campos:

- `productId`: el ID del producto solicitado.
- `brandId`: el ID de la marca del producto.
- `date`: la fecha en formato válido.

Si la fecha no tiene un formato válido, se devuelve una respuesta de error con el código de estado 400 (Bad Request).

Si la solicitud es válida, se llama al método `getProduct` del servicio `ProductService` para obtener el objeto `Prices` correspondiente. Si se encuentra un precio válido, se devuelve una respuesta con el código de estado 200 (OK) y el objeto `Prices` en el cuerpo de la respuesta. Si no se encuentra un precio válido, se devuelve una respuesta con el código de estado 204 (No Content).

En caso de producirse un error durante la obtención del precio, se devuelve una respuesta con el código de estado 500 (Internal Server Error).

## Registro

El controlador utiliza el marco de registro `Slf4j` para registrar información y errores. Los mensajes de registro se envían a través del logger asociado al controlador.


Asegúrate de configurar la configuración de registro adecuada para capturar los mensajes de registro generados por el controlador.

