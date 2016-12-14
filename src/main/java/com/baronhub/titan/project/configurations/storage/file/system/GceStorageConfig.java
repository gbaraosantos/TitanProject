package com.baronhub.titan.project.configurations.storage.file.system;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.StorageScopes;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collection;

/**
 * Google Cloud Engine Storage Config
 */
@Configuration
public class GceStorageConfig {
    private static Logger logger = Logger.getLogger(GceStorageConfig.class);

    /**
     * Setup of the GCE Storage
     * @return Storage
     */
    @Bean
    public Storage gceStorageSetup(){
        try {
            File file = new File(getClass().getResource("/keys/projectKey.json").getFile());

            HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
            JsonFactory jsonFactory = new JacksonFactory();

            GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(file.getAbsolutePath()));

            if (credential.createScopedRequired()) {
                Collection<String> scopes = StorageScopes.all();
                credential = credential.createScoped(scopes);
            }

            return new Storage.Builder(transport, jsonFactory, credential)
                    .setApplicationName("Titan Project")
                    .build();

        } catch (GeneralSecurityException | IOException e) {
            logger.error("Error initializing Google Cloud Engine Storage" , e);
            return null;
        }
    }
}
