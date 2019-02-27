#!/usr/bin/env bash
docker run -p 7000:7000 -p 9042:9042 -d --name my-cassandra cassandra:2.1.20

### connect to db insance
# docker exec -it my-cassandra /bin/bash

### use cql
# cqlsh