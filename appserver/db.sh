docker run -p 27017:27017 --rm --name mongodb -d mongo:3.4-xenial
docker run --rm --name pg-docker -d -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -v pgdata:/var/lib/postgresql/data postgres
