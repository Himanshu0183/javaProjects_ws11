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

import java.rmi.Remote;

/**
 *
 * @author User
 */
public interface Weather_Interface extends Remote{
     public Weather getWeather(String date) throws Exception;
}
