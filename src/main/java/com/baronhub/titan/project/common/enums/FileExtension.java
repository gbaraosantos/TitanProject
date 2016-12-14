package com.baronhub.titan.project.common.enums;

/**
 * Enum Regarding File Extensions
 */
public enum FileExtension {
    PNG(".png"),
    JPG(".jpg"),
    JPEG(".jpeg"),
    MP3(".mp3"),
    FLAC(".flac"),
    MPEG(".mpeg"),
    MPG(".mpg"),
    MKV(".mkv"),
    AVI(".avi"),
    MP4(".mp4"),
    PDF(".pdf"),
    RAR(".rar"),
    ZIP(".zip"),
    WEBM(".webm");


    private String extension;

    FileExtension(final String extension){
        this.extension = extension;
    }

    public String getExtension(){
        return this.extension;
    }

    @Override
    public String toString(){
        return this.extension;
    }

    public String getName(){
        return this.name();
    }

    /**
     * Uses the filename to define which extensions are accepted
     * @param originalFilename Filename
     * @return FileExtension
     */
    public static FileExtension getExtension(String originalFilename) {
        if(originalFilename.endsWith(FileExtension.FLAC.getExtension()))    return FileExtension.FLAC;
        if(originalFilename.endsWith(FileExtension.MP3.getExtension()))     return FileExtension.MP3;
        if(originalFilename.endsWith(FileExtension.ZIP.getExtension()))     return FileExtension.ZIP;
        if(originalFilename.endsWith(FileExtension.RAR.getExtension()))     return FileExtension.RAR;
        if(originalFilename.endsWith(FileExtension.PDF.getExtension()))     return FileExtension.PDF;
        if(originalFilename.endsWith(FileExtension.MPEG.getExtension()))    return FileExtension.MPEG;
        if(originalFilename.endsWith(FileExtension.AVI.getExtension()))     return FileExtension.AVI;
        if(originalFilename.endsWith(FileExtension.MKV.getExtension()))     return FileExtension.MKV;
        if(originalFilename.endsWith(FileExtension.MPG.getExtension()))     return FileExtension.MPG;
        if(originalFilename.endsWith(FileExtension.MP4.getExtension()))     return FileExtension.MP4;
        if(originalFilename.endsWith(FileExtension.JPEG.getExtension()))    return FileExtension.JPEG;
        if(originalFilename.endsWith(FileExtension.PNG.getExtension()))     return FileExtension.PNG;
        if(originalFilename.endsWith(FileExtension.JPG.getExtension()))     return FileExtension.JPG;
        if(originalFilename.endsWith(FileExtension.WEBM.getExtension()))    return FileExtension.WEBM;
        return null;
    }

}
