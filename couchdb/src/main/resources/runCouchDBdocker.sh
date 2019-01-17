#!/usr/bin/env bash
docker run -e COUCHDB_USER=admin -e COUCHDB_PASSWORD=password -p 5984:5984 -d --name my-couchdb couchdb:2.3.0