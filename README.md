# StorageForSocks
# Автоматизация учета склада носков
Реализовано приложение для автоматизации учёта носков на складе магазина.

Кладовщик имеет возможность:
* учесть приход и отпуск носков;
* узнать общее количество носков определенного цвета и состава в данный момент времени.
Доступные запросы
### POST /api/socks/income - Регистрирует приход носков на склад.

### POST /api/socks/outcome - Регистрирует отпуск носков со склада.

Параметры запроса передаются в теле запроса в виде JSON-объекта со следующими атрибутами:

- color — цвет носков, строка;
- cottonPart — процентное содержание хлопка в составе носков, целое число от 0 до 100;
- amount — количество пар носков, целое число больше 0.

Возможные статусы ответа:

- HTTP 200 — удалось добавить приход/отпуск;
- HTTP 400 — параметры запроса отсутствуют или имеют некорректный формат;
- HTTP 500 — произошла ошибка, не зависящая от вызывающей стороны.
### GET /api/socks - Возвращает общее количество носков на складе, соответствующих переданным в параметрах критериям запроса.

Параметры запроса передаются в URL:

- color — цвет носков, строка;
- operation — оператор сравнения значения количества хлопка в составе носков, одно значение из: moreThan, lessThan, equal;
- cottonPart — значение процента хлопка в составе носков из сравнения.

Возможные статусы ответа:

- HTTP 200 — запрос выполнен, результат в теле ответа в виде строкового представления целого числа;
- HTTP 400 — параметры запроса отсутствуют или имеют некорректный формат;
- HTTP 500 — произошла ошибка, не зависящая от вызывающей стороны.

 Стек, используемых технологий
Язык и окружение:
* <img src="https://github.com/alikeli/images/blob/main/java.png"  width="30"/> &nbsp;&nbsp;  Java 11 и выше  
* <img src="https://github.com/alikeli/images/blob/main/icons8-spring-boot-48.png" width="30"/> &nbsp;&nbsp; Spring Boot  
* <img src="https://github.com/alikeli/images/blob/main/icons8-postgresql-48.png" width="30"/> &nbsp;&nbsp; PostgreSQL 15
* <img src="https://github.com/alikeli/images/blob/main/hibernate.png" width="35"/> &nbsp;&nbsp; Hibernate  
* <img src="https://github.com/alikeli/images/blob/main/liquibase_logo_icon_247825.png" width="30"/> &nbsp;&nbsp; Liquibase 
* <img src="https://github.com/alikeli/images/blob/main/pb_Hp8ci.jpg" width="30"/> &nbsp;&nbsp;  Lombok 


### Документация

- Open API определение SwaggerUI: http://localhost:8080/api/swagger-ui/index.html
- Проект использует контейнеризацию с помощью Docker Compose для PostgreSQL
