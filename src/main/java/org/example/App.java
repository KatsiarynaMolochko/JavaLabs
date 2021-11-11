
package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;


public class App
{
    public static void main( String[] args ) throws Exception{
        FileReader in = new FileReader("input.txt");
        BufferedReader read = new BufferedReader(in);
        String line = read.readLine();
        ArrayList<String> lines = new ArrayList<String>();

        while(line != null) {
            lines.add(line);
            line = read.readLine();
        }

        in.close();

        Pattern reg = Pattern.compile("(^([0-9A-Fa-f]{2}[:]){5}([0-9A-F-a-f]{2})$)");
        ArrayList<String> macAdress = new ArrayList<String>();

        for(int i = 0; i < lines.size(); ++i) {
            Matcher matcher = reg.matcher(lines.get(i));
            while(matcher.find()) {
                macAdress.add(lines.get(i));
            }
        }


        try(FileWriter out = new FileWriter("output.txt")) {
            for(int i = 0; i < macAdress.size(); ++i) {
                out.write(macAdress.get(i) + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println( "Hello World!" );
    }
}