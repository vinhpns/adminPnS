/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author SGDG Company
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        String a = "Sinh Viên Công Nghệ Thông Tin";
//        String a1 = removeAccent(a);
//        String a2 = a1.replaceAll("\\s", "-");
//        System.out.println(a2);
        String str = "Sinh viên Công Nghệ Thông Tin";
        String sentence = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)) == true) {
                char ch2 = (char) (str.charAt(i) + 32);
                sentence = sentence + ch2;
            } else {
                sentence = sentence + str.charAt(i);
            }

        }
        String a = removeAccent(sentence).replaceAll("\\s", "-");
        System.out.println(a);
    }

    public static String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

}
