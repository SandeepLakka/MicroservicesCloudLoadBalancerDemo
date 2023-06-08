# Discovery Service

Service acting as registry to maintain multiple instances of various microservices in application

All services which needs to be maintained by this server needs to register themselves as clients to this service

this can be done by placing the following configuration in their properties

```properties

eureka.client.serviceUrl.defaultZone = <this_server_url>/eureka/   #e.g. http://localhost:7777/eureka/

# this is key property, mentioning that it needs to be registered as this name in the registry and other services
# can refer this name to call this service.
spring.application.name=<service-name>

#Optional: To maintain a unique instance-id in the instance list for a specific service
eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}
```

