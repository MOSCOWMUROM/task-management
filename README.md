# Система управления задачами

## Обзор
Это система управления задачами, реализованная с использованием Java, Spring Boot и PostgreSQL.

## Требования
- JDK 17 или выше
- Docker и Docker Compose

## Настройка

1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/example/taskmanagement.git
    cd taskmanagement
    ```

2. Соберите и запустите приложение с помощью Docker Compose:
    ```bash
    docker-compose up --build
    ```

3. Доступ к приложению можно получить по адресу `http://localhost:8080`

## Документация API
API задокументирован с помощью Swagger. После запуска приложения вы можете получить доступ к Swagger UI по адресу `http://localhost:8080/swagger-ui.html`.

## Запуск тестов
Для запуска тестов используйте следующую команду:
```bash
./mvnw test
```
Эндпоинты

POST /register: Регистрация нового пользователя

POST /authenticate: Аутентификация пользователя и получение JWT токена

GET /tasks/author/{authorId}: Получение задач по автору

GET /tasks/assignee/{assigneeId}: Получение задач по исполнителю

POST /tasks: Создание новой задачи
