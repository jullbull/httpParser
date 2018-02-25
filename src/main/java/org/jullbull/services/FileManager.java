package org.jullbull.services;

import org.jullbull.interfaces.FilesConstans;

import java.io.*;
import java.util.stream.Stream;

public class FileManager implements FilesConstans {

    private FileWriter fileWriter = new FileWriter(SAVE_FILE);
    private FileReader urlFileReader = new FileReader(URL_FILE);
    private FileReader pathFileReader = new FileReader(PATH_FILE);
    private BufferedReader urlBuffer = new BufferedReader(urlFileReader);
    private BufferedReader pathBuffer = new BufferedReader(pathFileReader);


    public FileManager() throws IOException {
    }

    public Stream<String> getUrlReaderByLine() throws IOException {

        return urlBuffer.lines();

    }


    public Stream<String> getPropertiesReadByLine() throws IOException {

        return pathBuffer.lines();
    }


    public FileWriter getFileWriter() {
        return fileWriter;
    }
}

