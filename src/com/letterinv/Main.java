//isaac cartagena
//CS145
//2/13/2022
//This program takes prompts user to enter a string then counts
//all letters in string and let you know how many are in the string

package com.letterinv;

import java.util.Arrays;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] alphabet = {'a', 'b', 'c',
                           'h', 'i', 'j',
                           'k', 'l', 'm',
                           'n', 'o', 'p',
                           'd', 'e', 'f',
                           'q', 'r', 's',
                           't', 'u', 'v',
                           'w', 'x', 'y', 'z'};

        int alphaCount[] = new int[26];

        //User input
        System.out.println("Please enter a sentence: ");
        String str = toLowerCase(input.nextLine());

        //Remove special characters
        str = str.replaceAll("[^a-zA-Z]", " ");

        //Remove Spaces from String
        String noSpaceStr = (str.replaceAll(" ", ""));

        for (int i = 0; i < noSpaceStr.length(); i++) {
            for(char letter: alphabet) {
                if(noSpaceStr.charAt(i) == letter) {
                    alphaCount[i] += 1;
                    System.out.println(Arrays.toString(alphaCount));
                }else {
                    System.out.println("poop");
                }
            }
        }

    }
}
