/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pavel.d.cisc.pkg3130.fall.pkg2020;

/**
 *
 * @author My PC
 */
import java.io.*;       
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
public class Lab3{
    public static void main(String [] args) {
        //Creates the Linked List.
        LinkedList<String> list = new LinkedList<>(); 
        // The name of the file to open.
        String fileName = "viral-global-weekly-latest.csv";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                String [] parts = line.split(",");
                String artist = parts[2];
                list.add(artist);
            }   

            // Closes the file
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            
        }
        //This sorts the Linked List.
        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        //This prints the list with one member on each line in ascending alphabetical order.
        sortedList.forEach(System.out::println);
    }
}