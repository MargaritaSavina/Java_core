# Устанавливаем базовый образ, содержащий JDK
FROM openjdk:latest
# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /usr/src/app
# Копируем исходный код приложения внутрь контейнера
COPY ./src/sem1 .
# Компилируем Java исходный код
RUN javac -sourcepath . -d out ./task/Hello.java
# Теперь рабочая директория - директория с файлами .class
WORKDIR /usr/src/app/out
CMD java -classpath . task.Hello
#ENTRYPOINT ["sem1","task.Hello"]