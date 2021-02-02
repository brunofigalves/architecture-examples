export KK_PRODUCTS_PORT=60260
export DATABASE_USERNAME=postgres
export DATABASE_URL=jdbc:postgresql://localhost:5432/postgres
export KK_PRODUCTS_HOST=localhost
export DATABASE_PASSWORD=admin
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
