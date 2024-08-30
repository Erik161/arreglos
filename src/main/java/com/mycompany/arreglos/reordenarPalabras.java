/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arreglos;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Asus Tuf
 */
public class reordenarPalabras {
    
    public static String reorderSentence(String[] words) {
        return Arrays.stream(words)
                .sorted(Comparator.comparingInt(reordenarPalabras::extractNumber))
                .map(reordenarPalabras::removeNumber)
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }

    private static int extractNumber(String word) {
        String numberPart = word.replaceAll("\\D+", "");
        return Integer.parseInt(numberPart);
    }

    private static String removeNumber(String word) {
        return word.replaceAll("\\d", "");
    }

    public static void main(String[] args) {
        String[] words = {"esta2", "bien4", "muy3", "esto1"};
        String result = reorderSentence(words);
        System.out.println(result);  
    }
}
