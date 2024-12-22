
# Steps to run the application

1) mvn clean package
2) docker build --tag=usersapi-api:latest .
3) docker run -p8080:8080 usersapi-api:latest
