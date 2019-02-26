#!/usr/bin/env bash
docker run -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=password -p 27017:27017 -d --name my-mongodb mongo:4.0.5
