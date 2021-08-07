@echo off 
call gradlew build -x test
docker build -t api:1.0 .
docker-compose up -d
pause