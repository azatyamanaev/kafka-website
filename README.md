# kafka-website

Проект представляет собой веб-приложение для создания, заполнения и хранения опросов.

## Технологии

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Apache Kafka 
- Bootstrap
- FLyway

## Зависимости

Убедитесь, что у вас установлены следующие инструменты:

- Java Development Kit (JDK) 11
- Maven
- PostgreSQL
- Docker

## Запуск приложения

1. Склонируйте репозиторий:

    ```bash
    git clone https://github.com/azatyamanaev/kafka-website.git
    cd kafka-website
    ```
    
2. Выполните команду:
   ```bash
    mvn clean package
    ```
   
3. Скопируйте файл app.jar из папки target в папку docker

4. В терминале перейдите в папку docker и выполните команду:
    ```bash
    docker build -t kafka-app:latest .
    ```

5. Перейдите в корень проекта и выполните команду:
   ```bash
    docker-сompose -f docker-compose.yml up -d
    ```

6. Откройте веб-браузер и перейдите по адресу [http://localhost:8080](http://localhost:8080).

## Настройки базы данных

- Имя базы данных: your_database_name
- Пользователь: your_database_username
- Пароль: your_database_password


## Дополнительные настройки (опционально)

- Для асинхронной обработки с Apache Kafka, укажите настройки Kafka в `application.properties`.
- Для изменения порта приложения, укажите `server.port` в `application.properties`.

## Разработка

- Ваш код может быть дополнен и расширен в соответствии с вашими требованиями.
- Добавьте тесты для обеспечения стабильности.

## Автор

- Иванов Илья
- Яманаев Азат
- Счастливцев Михаил
