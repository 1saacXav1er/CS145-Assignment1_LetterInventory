//isaac cartagena
//CS145
//2/13/2022
//This program takes prompts user to enter a string then counts
//all letters in string and let you know how many are in the string

package com.letterinv;

import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
                           'h', 'i', 'j', 'k', 'l', 'm',
                           'n', 'o', 'p', 'q', 'r', 's',
                           't', 'u', 'v', 'w', 'x', 'y', 'z'};

        int[] alphaCount = new int[26];

        //User input
        System.out.println("Please enter a sentence: ");
        String str = toLowerCase(input.nextLine());

        //Remove special characters
        str = str.replaceAll("[^a-zA-Z]", " ");

        //Remove Spaces from String
        String noSpaceStr = (str.replaceAll(" ", ""));

        //loop through each letter and add up how many letters
        //are in the user input
        for (int i = 0; i < noSpaceStr.length(); i++) {
            int count = 0;
            for(char letter: alphabet) {
                //System.out.println(count);
                if(noSpaceStr.charAt(i) == letter) {
                    //System.out.println("match");
                    alphaCount[count] += 1;
                }
                count++;
            }
        }

        //display totals of letters
        System.out.println("--------Totals--------");
        for(int i = 0; i < alphabet.length; i++) {
                System.out.print(" |" + alphabet[i] + " " + alphaCount[i] + "| ");
                if((i+1) % 3 == 0) {
                    System.out.println(" ");
                    System.out.println("----------------------");
                }
        }

        //find the highest amount of letters
        int maxVal = getMaxValue(alphaCount);
        //get index of most letters
        int alpindex = findMax(maxVal,alphaCount);
        System.out.println(" ");
        System.out.println(" ");
        //prints total letters
        System.out.println("Total Letters: " + noSpaceStr.length());
        System.out.println(" ");
        //prints letter with most letters
        System.out.println("Most Letters: " + alphabet[alpindex] + " " + maxVal);

    }

    //get the max amount of letters
    public static int getMaxValue(int[] alphaCount){
        int maxValue = 0;
        for (int j : alphaCount) {
            if (j > maxValue) {
                maxValue = j;
            }
        }
        return maxValue;
    }

    //find the letter with the most letters and return its index
    //takes the most numbers and array and returns the index of the letter
    //if there are two letters with the same amount returns first letter
    public static int findMax(int maxValue, int[] alphaCount) {
        int indexNum = 0;
        int count = 0;
        for (int i : alphaCount) {
            if (i == maxValue) {
                indexNum = count;
            } else {
                count++;
            }
        }
        return indexNum;
    }
}
