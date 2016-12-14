package com.baronhub.titan.project.components.services.file.system;

import com.google.api.services.storage.model.StorageObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * File System Service Interface
 */
public interface GceFileSystemService {
    void deleteObject(String bucket, String filePath) throws IOException;
    StorageObject getObject(String bucket, String filePath) throws IOException ;
    List<StorageObject> listBucket(String bucketName) throws IOException;
    void addObject(String bucketName , String filePath , MultipartFile file) throws IOException;
    void createBucket(String bucketName) throws IOException;
}
