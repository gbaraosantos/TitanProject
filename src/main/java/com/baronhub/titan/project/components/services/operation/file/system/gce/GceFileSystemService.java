package com.baronhub.titan.project.components.services.operation.file.system.gce;

import com.google.api.services.storage.model.StorageObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * File System Service Interface
 */
public interface GceFileSystemService {
    /**
     * Deletes an Object from a GCE Bucket
     * @param bucketName Bucket name in GCE
     * @param filePath Path within the bucket
     * @throws IOException Exception
     */
    void deleteObject(String bucketName, String filePath) throws IOException;

    /**
     * Gets an Object from a GCE Bucket
     * @param bucketName Bucket name in GCE
     * @param filePath Path within the bucket
     * @return StorageObject
     * @throws IOException Exception
     */
    StorageObject getObject(String bucketName, String filePath) throws IOException ;

    /**
     * Gets all Objects from a GCE Bucket
     * @param bucketName Bucket name in GCE
     * @return List<StorageObject>
     * @throws IOException Exception
     */
    List<StorageObject> listBucket(String bucketName) throws IOException;

    /**
     * Adds a file to the GCE File System
     * @param bucketName Bucket name
     * @param filePath File Path
     * @param file File
     * @throws IOException Exception
     */
    void addObject(String bucketName , String filePath , MultipartFile file) throws IOException;

    /**
     * Creates a new Bucket in the GCE File Sytem
     * @param bucketName Bucket name
     * @throws IOException Exception
     */
    void createBucket(String bucketName) throws IOException;
}
