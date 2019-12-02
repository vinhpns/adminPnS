/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.tool;

import java.util.Scanner;

/**
 *
 * @author SGDG Company
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ordercode = "s102019110210008";
        String newOrderCode = Utils.setBidOrderCode(ordercode);
        System.out.println(newOrderCode);
    }

}
