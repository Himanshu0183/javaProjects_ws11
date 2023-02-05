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

public class Weather implements java.io.Serializable{
   private String date,temperature,rain,snow,daylight,cloud;

    public Weather(String date, String temperature, String rain, String snow, String daylight, String cloud) {
        this.date = date;
        this.temperature = temperature;
        this.rain = rain;
        this.snow = snow;
        this.daylight = daylight;
        this.cloud = cloud;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getRain() {
        if(rain.equals("") || rain.equals("0")){
            return  "No Rain";
        }
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getSnow() {
        if(snow.equals("") || snow.equals("0")){
            return  "No Snow";
        }
        return snow;
    }

    public void setSnow(String snow) {
        this.snow = snow;
    }

    public String getDaylight() {
        if(daylight.equals("")  || daylight.equals("0")){
            return  "Not Sunny";
        }
        return daylight;
    }

    public void setDaylight(String daylight) {
        this.daylight = daylight;
    }

    public String getCloud() {
        if(cloud.equals("")  || cloud.equals("0")){
            return  "NO clouds";
        }
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", temperature='" + temperature + '\'' +
                ", rain='" + rain + '\'' +
                ", snow='" + snow + '\'' +
                ", daylight='" + daylight + '\'' +
                ", cloud='" + cloud + '\'' +
                '}';
    }
}
