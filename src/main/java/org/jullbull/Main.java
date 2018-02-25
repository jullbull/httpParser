package org.jullbull;

import org.jullbull.services.FileManager;
import org.jullbull.services.HttpConnectionService;
import org.jullbull.services.ParserService;

import java.io.IOException;

public class Main {


    public static void main(String [] args) throws IOException {
ParserService parserService = new ParserService();
parserService.startParse();



    }
}
