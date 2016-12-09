package com.baronhub.titan.project.components.controllers.homepage;

import com.baronhub.titan.project.components.services.mailer.Mailer;
import com.baronhub.titan.project.configurations.storage.file.system.GceStorageConfig;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.model.Objects;
import com.google.api.services.storage.model.StorageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Homepage Controller
 */

@Controller
public class Homepage {
    @Autowired private Mailer mailer;

    /**
     * Testing Controller - Useless controller
     */

    @RequestMapping(value = "/teste" , method = RequestMethod.GET)
    void teste() throws IOException, GeneralSecurityException {
        Storage client = GceStorageConfig.getService();
        Storage.Objects.List listRequest = client.objects().list("titan-bucket");

        List<StorageObject> results = new ArrayList<StorageObject>();
        Objects objects;

        // Iterate through each page of results, and add them to our results list.
        do {
            objects = listRequest.execute();
            // Add the items in this page of results to the list we'll return.
            results.addAll(objects.getItems());

            // Get the next page, in the next iteration of this loop.
            listRequest.setPageToken(objects.getNextPageToken());
        } while (null != objects.getNextPageToken());

        System.out.println(results);
    }
}
