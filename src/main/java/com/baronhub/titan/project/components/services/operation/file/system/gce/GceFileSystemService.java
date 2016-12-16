package com.baronhub.titan.project.components.services.operation.file.system.gce;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    String getObject(String bucketName, String filePath) throws IOException ;

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
