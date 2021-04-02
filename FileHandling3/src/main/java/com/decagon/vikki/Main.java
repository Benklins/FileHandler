package com.decagon.vikki;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
	// write your code here
        Scanner inputReader = new Scanner(System.in);

       String filePath = null;

        if(args.length  == 0){

            filePath = "resources/config.txt";

        }

        else{

            if(args[0].equalsIgnoreCase("production")){}

            else if(args[0].equalsIgnoreCase("staging")){ filePath = "resources/config.txt.staging";}

            else if(args[0].equalsIgnoreCase("development")){ filePath = "resources/config.txt.dev";}
        }






        ConfigParser configParser = new ConfigParser(filePath);

        System.out.println("Input the key to get its value");
        System.out.println("Value:"+configParser.get(inputReader.next()));


    }
}
