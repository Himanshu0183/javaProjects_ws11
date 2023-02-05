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

package com.himanshu.workshop11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Weather_Interface_Implement extends UnicastRemoteObject implements Weather_Interface {
    private ArrayList<Weather> data;

    public Weather_Interface_Implement(String filename) throws RemoteException {
        super();
        data = new ArrayList<>();
        ReadData(filename);
    }

    public void ReadData(String filename) {
        String line;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] record = line.split(",");
                if (record[0].trim().isEmpty()) {
                    break;
                }
                data.add(new Weather(record[0], record[1], record[2], record[3], record[4], record[5]));
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\tTask completed...");
        }
    }

    @Override
    public Weather getWeather(String my_date) throws Exception {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        for (int i = 0; i < data.size(); i++) {
            Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(data.get(i).getDate());
            Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(my_date);

            cal1.setTime(date1);
            cal2.setTime(date2);

            if (cal1.equals(cal2)) {
                return data.get(i);
            }
        }
        return new Weather("", "", "", "", "", "");
    }

}
