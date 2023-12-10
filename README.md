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

## Зависимости

Убедитесь, что у вас установлены следующие инструменты:

- Java Development Kit (JDK) 11
- Maven
- PostgreSQL

## Запуск приложения

1. Склонируйте репозиторий:

    ```bash
    git clone https://github.com/yourusername/online-survey.git
    cd online-survey
    ```

2. Установите зависимости и запустите приложение:

    ```bash
    mvn spring-boot:run
    ```

    Как альтернатива: через запуск в IDE метода main() класса SurveyApplication 

3. Откройте веб-браузер и перейдите по адресу [http://localhost:8080/survey](http://localhost:8080/survey).

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
