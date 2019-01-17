package com.bxy.couchdb.db;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;

@Configuration
public class CouchDbConfig {

    public static final String DATABASE_NAME = "db-test";

    /*
       Ektorp (integration of CouchDb with Java ) documentation can be found here:
       https://helun.github.io/Ektorp/reference_documentation.html
     */

    @Bean
    public CouchDbConnector couchDbConnector() throws MalformedURLException {
        HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("password")
                .build();
        CouchDbInstance couchDbInstance = new StdCouchDbInstance(httpClient);
        CouchDbConnector couchDbConnector = new StdCouchDbConnector(DATABASE_NAME, couchDbInstance);
        couchDbConnector.createDatabaseIfNotExists();
        return couchDbConnector;
    }

}
