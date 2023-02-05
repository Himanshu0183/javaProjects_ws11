/**********************************************
 Workshop 11
 Course: JAC 444 - Summer 2022
 Last Name: Himanshu
 First Name: Himanshu
 ID: 146109202
 Section: ZBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature  Himanshu
 Date: 08/19/2022
 **********************************************/


package com.himanshu.workshop11;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server_RMI {

    public static void main(String args[]) {
        try {

            Registry reg = LocateRegistry.createRegistry(3000);

            Weather_Interface_Implement cl = new Weather_Interface_Implement("weatherstats.csv");

            reg.rebind("Weather", cl);

            System.out.println("Server ready...");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
