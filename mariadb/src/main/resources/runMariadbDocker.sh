#!/usr/bin/env bash
docker run -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 -d --name my-mariadb mariadb/server:10.3