package com.decagon.vikki;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileInputParser {


     private BufferedReader fileInputReader;
     private Map<String,String> configMap ;
     private String[] key_Value;

    public FileInputParser(File file)  {

        //
        configMap = new HashMap();

        try{
        this.fileInputReader = new BufferedReader(new FileReader(file));
            parseLine();
        }

        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }



      private void addToMap(String key,String value){
          configMap.put(key,value);
      }



         public String getValue(String key){
            return configMap.get(key);

         }


         private void parseLine() throws IOException {


        try {
            String string="";
            String outerLineContent="";

            while ((string=fileInputReader.readLine()) != null) {
                string = string.trim();

                //Checks for empty line
                if (string.length()==0){
                    outerLineContent="";
                    continue;
                }


                //Checks if the new line is outer line that wraps other lines
                if(string.startsWith("[") && string.endsWith("]") ){

                    //get the name of the content of the outer line
                    outerLineContent=string.substring(string.indexOf("[")+1,string.indexOf("]"))+".";

                    // Jumps to the next line
                    continue;

                }


                else{

               key_Value = string.split("=");
               configMap.put(outerLineContent+key_Value[0],key_Value[1]);

                }
            }
        }


           catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
           }


           catch (IOException e) {
            e.printStackTrace();
        }


           finally{
               fileInputReader.close();
        }


           }


         }



