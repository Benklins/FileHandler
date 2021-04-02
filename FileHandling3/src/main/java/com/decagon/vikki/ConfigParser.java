package com.decagon.vikki;

import java.io.File;

public class ConfigParser {

       private String filePath;
       private FileInputParser fileInputParser;

    public ConfigParser(String filePath){

        this.filePath = filePath;
        readFileContent();

    }


    private void readFileContent(){

        //create file input parser that parses the file content
        fileInputParser =   new FileInputParser(new File(filePath));
    }



    public String get(String key){

          // returns the value based on the key supplied
         return this.fileInputParser.getValue(key);

    }

}
