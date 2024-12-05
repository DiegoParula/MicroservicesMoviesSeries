Microservicios de Películas y Series
Este proyecto está compuesto por tres microservicios interconectados que permiten la gestión y consulta de películas y series. La arquitectura implementa comunicación mediante Feign, mensajería con RabbitMQ, trazabilidad con Zipkin, y tolerancia a fallos con Resilience4j.

Microservicios
1. Movie Service
Gestión de películas. Este servicio permite realizar operaciones CRUD para películas y cuenta con la siguiente estructura de datos:

Atributos de una película:
id: Identificador único.
name: Nombre de la película.
genre: Género al que pertenece.
urlStream: URL del stream de la película.

Características adicionales:
Configuración para auto-descubrimiento utilizando Eureka.
Comunicación con Catalog Service mediante Feign para enviar información de las películas.
Envío de mensajes a través de RabbitMQ al guardar una película, para actualizar el catálogo en Catalog Service.

2. Serie Service
Gestión de series. Este servicio permite realizar operaciones CRUD para series y tiene la siguiente estructura:

Atributos de una serie:
id: Identificador único.
name: Nombre de la serie.
genre: Género al que pertenece.
seasons: Lista de temporadas de la serie, con los siguientes atributos:
id: Identificador único de la temporada.
seasonNumber: Número de la temporada.
chapters: Lista de capítulos con:
id: Identificador único del capítulo.
name: Nombre del capítulo.
number: Número del capítulo.
urlStream: URL del stream del capítulo.

Características adicionales:
Configuración para auto-descubrimiento utilizando Eureka con el nombre serie-service.
Comunicación con Catalog Service mediante Feign para sincronizar la información de las series.
Envío de mensajes a través de RabbitMQ al guardar una serie, para actualizar el catálogo en Catalog Service.

3. Catalog Service
Este microservicio permite consultar películas y series por género, así como sincronizar y persistir la información recibida de los otros microservicios. La base de datos utilizada es MySql, con la siguiente estructura:
Estructura del catálogo:
genre: Género de las películas o series.
movies: Lista de películas asociadas al género.
id, name, genre, urlStream
series: Lista de series asociadas al género.
id, name, genre, seasons

Características adicionales:
Modificación de la consulta por género para realizarla directamente en MySql.
Comunicación con Movie Service y Serie Service mediante Feign para sincronizar películas y series.
Recepción de mensajes desde RabbitMQ para actualizar automáticamente la base de datos cuando se crean nuevas películas o series.
Arquitectura y Tecnologías
1. Comunicación entre Microservicios
Uso de Feign para realizar llamadas entre servicios.
Mensajería asíncrona con RabbitMQ para sincronización de datos.
2. Trazabilidad con Zipkin
Configuración de Zipkin en todos los microservicios para rastrear las solicitudes.
Ejemplo: Una búsqueda por género puede ser visualizada en el dashboard de Zipkin.
3. Resiliencia con Resilience4j
Implementación en Catalog Service para garantizar tolerancia a fallos en la comunicación con los microservicios.

Pruebas con Postman
Se incluye una colección de Postman con todos los endpoints necesarios para probar los microservicios. Esta colección se encuentra en el archivo Microservice-Movie-Serie..postman_collection.json, ubicado en la raíz del repositorio.

Requisitos Previos
Java 17+
Spring Boot
MySql
RabbitMQ
Zipkin
Postman 