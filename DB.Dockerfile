FROM postgres:latest
ADD ./api/data/schema.sql /docker-entrypoint-initdb.d/