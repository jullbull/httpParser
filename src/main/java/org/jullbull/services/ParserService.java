package org.jullbull.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserService {


    private FileManager fileManager = new FileManager();
    private List<String> listOfUrls = new ArrayList<>();
    private List<String> listOfProperites = new ArrayList<>();
    private List<String> readyForworkURLS = new ArrayList<>();
    private HttpConnectionService connect = new HttpConnectionService();


    public ParserService() throws IOException {
    }


    private List fromUrlFileToURLlist() throws IOException {


        Stream<String> url = fileManager.getUrlReaderByLine();

        listOfUrls = url.collect(Collectors.toList());
        return listOfUrls;

    }

    private List fromPropertiesFileToList() throws IOException {


        Stream<String> properties = fileManager.getPropertiesReadByLine();

        listOfProperites = properties.collect(Collectors.toList());
        return listOfProperites;

    }


    private void urlMaker() throws IOException {

        fromUrlFileToURLlist();
        fromPropertiesFileToList();

        for (int i = 0; i < listOfUrls.size(); i++) {
            for (int l = 0; l < listOfProperites.size(); l++) {
                readyForworkURLS.add(listOfUrls.get(i) + listOfProperites.get(l));
            }
        }

    }


    public void startParse() throws IOException {

        try {
            urlMaker();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < readyForworkURLS.size(); i++) {


            System.out.println(readyForworkURLS.get(i));
            try {
                if (connect.getConnection(readyForworkURLS.get(i)) == 200) {
                    System.out.println("200");
                    fileManager.getFileWriter().write(readyForworkURLS.get(i) + System.lineSeparator());
                    continue;


                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }


        }
        fileManager.getFileWriter().close();


    }


}
