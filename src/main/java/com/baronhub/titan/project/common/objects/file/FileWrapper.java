package com.baronhub.titan.project.common.objects.file;

import com.baronhub.titan.project.common.enums.FileExtension;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

/**
 * Wrapper for Multipart File Object
 */
@Immutable
public class FileWrapper{
    private File file;
    private FileExtension extension;
    private String fileName;
    private String absolutePath;
    private long size;
    private Date uploadDate;

    /**
     * Creates the file Wrapper from file Object
     * @param file File
     */
    public FileWrapper(File file){
        this.file = file;
        init();
    }

    /**
     * Constructor using multipart File(Converts)
     * @param multipartFile MultipartFile
     * @throws IOException Exception
     */
    public FileWrapper(MultipartFile multipartFile) throws IOException {
        File fileTemp = new File(multipartFile.getOriginalFilename());

        FileOutputStream fos = new FileOutputStream(fileTemp);
        fos.write(multipartFile.getBytes());
        fos.close();

        this.file = fileTemp;
        init();

    }

    /**
     * Constructor using FilePath
     * @param filePath filePath
     */
    public FileWrapper(String filePath){
        this.file = new File(filePath);
        init();
    }

    /**
     * Initializes the remaining parameters
     */
    private void init(){
        this.fileName = file.getName();
        this.absolutePath = file.getAbsolutePath();

        this.extension = FileExtension.getExtension(this.fileName);
        this.uploadDate = new Date();
        this.size = file.length(); //?
    }

    /**
     * Getters
     */
    public Date getUploadDate() { return uploadDate; }
    public File getFile() { return file; }
    public FileExtension getExtension() { return extension; }
    public String getFileName() { return fileName; }
    public String getAbsolutePath() { return absolutePath;  }
    public long getSize() { return size; }

    /**
     * Checks if the file is an Image
     * @return Boolean
     */
    public Boolean isImage(){
        return  FileExtension.PNG   == extension    ||
                FileExtension.JPEG  == extension    ||
                FileExtension.JPG   == extension;
    }

    /**
     * Checks if the image if a Video
     * @return Boolean
     */
    public Boolean isVideo(){
        return  FileExtension.AVI   == extension    ||
                FileExtension.MKV   == extension    ||
                FileExtension.MPEG  == extension    ||
                FileExtension.MPG   == extension    ||
                FileExtension.MP4   == extension    ||
                FileExtension.WEBM  == extension;
    }

    /**
     * Checks if the File is a music File
     * @return Booleam
     */
    public Boolean isMusic(){
        return  FileExtension.FLAC   == extension    ||
                FileExtension.MP3    == extension;
    }

    /**
     * @return FileInputStream
     * @throws FileNotFoundException Exception
     */
    public FileInputStream getFileInputStream() throws FileNotFoundException {
        return new FileInputStream(file);
    }
}
