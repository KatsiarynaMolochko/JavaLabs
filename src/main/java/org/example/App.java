package org.example;
import java.util.*;
import java.lang.String;
import java.lang.StringBuffer;
import java.util.Random;




public class App 
{
    public static StringBuffer Delete (String lexemes, ArrayList<String> words) {
        StringBuffer string = new StringBuffer(lexemes);
        String minimal = String.valueOf(lexemes);

        for (int i = 0; i < words.size(); ++i) {
            if (checkIsNumber(words.get(i)) && words.get(i).length() < minimal.length()) {
                minimal = String.valueOf(words.get(i));
            }
        }
        int indexSubstr = string.indexOf(minimal);
        string.delete(indexSubstr,indexSubstr + minimal.length());
        return string;

    }


    public static boolean checkIsNumber(String str) {
        for(int i = 0; i < str.length(); ++i){
            if(!(str.charAt(i) >= '0' && str.charAt(i) < '8')) return false;
        }
        return true;
    }


    public static boolean checkIfOctNumber(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) < '8')) return false;
        }
        return true;
    }


    public static StringBuffer pasteRandom(String lexemes, ArrayList<String> words, ArrayList<String> numbers, String num) {
        StringBuffer string = new StringBuffer(lexemes);
        Random random = new Random();

        if (FindNumber(words, numbers, num) == -1) {
            string.insert(0, random.nextInt(100));
            return string;
        }


        string.insert(lexemes.indexOf(num) - 1, random.nextInt(100));
        return string;
    }


    public static int FindNumber(ArrayList<String> words, ArrayList<String> numbers, String num) {
        for (String number : numbers) {
            if (Objects.equals(number, num)) {
                return words.indexOf(number);
            }
        } return -1;
    }


    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a line with any symbols from keyboard");
        String lexemes = in.nextLine();

        System.out.println("Input a line with delimiters-symbols with any amount of delimiters.");
        String delimList = in.nextLine();

        System.out.println("Input an integer number");
        Integer num = in.nextInt();
        String num_str = num.toString();


        ArrayList<String> words = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(lexemes, delimList);

        while(tokenizer.hasMoreTokens()){
            words.add(tokenizer.nextToken());
        }

        ArrayList<String> numbers = new ArrayList<>();
        System.out.println("Numbers in octal system was: ");

        for (int i = 0; i < words.size(); ++i) {
            if (checkIfOctNumber(words.get(i))) {
                numbers.add(words.get(i));
                System.out.print(String.format(words.get(i)) + ' ');
            }
        }

        System.out.println();
        System.out.println(String.format(num + " is in line of words and the index is: " + FindNumber(words, numbers, num_str)));
        System.out.println();
        System.out.println("Random number insertion:");
        System.out.println(pasteRandom(lexemes, words, numbers, num_str));
        System.out.println();
        System.out.println("Removing the shortest number from the line");
        System.out.println(Delete(lexemes, words));
    }
}
