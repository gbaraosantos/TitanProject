package com.baronhub.titan.project.components.services.operation.file.system.gce;

import com.baronhub.titan.project.common.objects.file.FileWrapper;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.StorageObject;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Service to Handle the file system operations
 */

@Service("FileSystemService")
public class GceFileSystemServiceImpl implements GceFileSystemService{
    @Autowired private Storage storage;

    /**
     * Deletes an Object from a GCE Bucket
     * @param bucketName Bucket name in GCE
     * @param filePath Path within the bucket
     * @throws IOException Exception
     */
    public void deleteObject(String bucketName, String filePath) throws IOException {
        storage.objects().delete(bucketName , filePath).execute();
    }

    /**
     * Gets an Object from a GCE Bucket
     * @param bucketName Bucket name in GCE
     * @param filePath Path within the bucket
     * @return StorageObject
     * @throws IOException Exception
     */
    public String getObject(String bucketName, String filePath) throws IOException {
        return storage.objects().get(bucketName, filePath).execute().getMediaLink();
    }

    /**
     * Adds a file to the GCE File System
     * @param bucketName Bucket name
     * @param filePath File Path
     * @param file File
     * @throws IOException Exception
     */
    public void addObject(String bucketName , String filePath , MultipartFile file) throws IOException{
        FileWrapper fileWrapper = new FileWrapper(file);
        InputStreamContent mediaContent = new InputStreamContent( "application/octet-stream",fileWrapper.getFileInputStream());

        StorageObject storageObject = new StorageObject()
                .setName(filePath + fileWrapper.getFileName())
                .setAcl(ImmutableList.of(
                        new ObjectAccessControl().setRole("publicRead")
                ));

        storage.objects().insert(bucketName, storageObject,mediaContent).execute();
    }



    /**
     * Creates a new Bucket in the GCE File Sytem
     * @param bucketName Bucket name
     * @throws IOException Exception
     */
    public void createBucket(String bucketName) throws IOException{
        storage.buckets().insert(bucketName, new Bucket()).execute();
    }



}
