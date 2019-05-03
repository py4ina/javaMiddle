package com.learn;


import lombok.Data;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private final static String PATH = "/home/vitalik/";
    private static List<String> result = new ArrayList();
    private static String fileNameToSearch;

    //и его геттер
    public static List<String> getResult() {
        return result;
    }
    //Имя файла, для хранения:
    public static String getFileNameToSearch() {
        return fileNameToSearch;
    }
    public void setFileNameToSearch(String fileNameToSearch) {
        this.fileNameToSearch = fileNameToSearch;
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.inputVars();
    }

    public void inputVars(){
        System.out.println("Enter the path from start search:");
        Scanner in = new Scanner(System.in);
        String inPath = in.nextLine();
        System.out.println("Enter the file name:");
        String inName = in.nextLine();

        searchDirectory(new File(inPath),inName);
        int count = getResult().size();
        if (count == 0)
            System.out.println("\nNo results!");
        else{
            System.out.println("\nFound "+count+" result!\n");
            for (String matched:getResult())
                System.out.println("Found: "+matched);
        }
    }

    public void searchDirectory(File file, String fileName){
        setFileNameToSearch(fileName);
        if (file.isDirectory())
            search(file);
        else
            System.out.println(file.getAbsoluteFile()+" is not a directory\n");
    }

    public static void search(File file){
        if (file.isDirectory()){
            System.out.println("Searching directory "+file.getAbsoluteFile());
            if (file.canRead()){
                for (File temp : file.listFiles())
                    if (temp.isDirectory())
                        search(temp);
                    else
                    if (getFileNameToSearch().equals(temp.getName().toLowerCase()))
                        result.add(temp.getAbsoluteFile().toString());
            }else
                System.out.println(file.getAbsoluteFile()+": Permission Denied!");
        }
    }
}