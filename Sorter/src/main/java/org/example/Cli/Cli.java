package org.example.Cli;

import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cli {
    private final String filePath;
    private final List<Integer> list = new ArrayList<>();

    public Cli(String filePath){ this.filePath = filePath; }
    public void get_file() throws IOException {
        try {
            List<String> data = Files.readAllLines(Paths.get(filePath));

            for (String line : data){
                parse_list(line);
            }
        } catch (IOException e){
            throw new IOException("Error Reading File");
        }
    }

    public void parse_list(String line){
        String[] elements = line.split(",");
        for(String element: elements){
            element = element.replaceAll("\\s+", "");
            list.add(Integer.parseInt(element));
        }
    }

    public List<Integer> getList(){
        return list;
    }

    public void main_menu(){
        System.out.println("Choose one of the following sorting techniques: ");
        System.out.println("1- Insertion Sort");
        System.out.println("2- Quick Sort");
        System.out.println("3- Count Sort");
    }

    public void output_choice(){
        System.out.println("Choose one of the following options: ");
        System.out.println("1- Show final Output");
        System.out.println("2- Show intermediate steps");
    }
}
