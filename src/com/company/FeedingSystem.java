package com.company;

import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class FeedingSystem {
    private int qtt1, qtt2, qtt3;
    private int timeToFeed; //every timeTofeed hour machine will feed pet
    private int firstBox; //choose box be a first to feed
    private int toFeed; //Amount of food => plate
    private int chooseBox; // choose box for addind food to that box
    private int amount; //amount you want to add
    private int inPlate;
    private Supply sp = new Supply();
    private Supply[] supply = {new Supply("BOX 1"), new Supply("BOX 2"), new Supply("BOX 3")};
    private String name;


    Scanner sc = new Scanner(System.in);


    //    ===== FIRST SETTING =====
    public void firstSetting() {
        for (int i = 0; i < supply.length; i++) {
            System.out.print("Add food to BOX " + (i + 1) + " : ");
            qtt1 = sc.nextInt();
            supply[i].setQuantity(qtt1);
        }
        System.out.print("Please select time for feeding : ");
        timeToFeed = sc.nextInt();
        System.out.print("Please inout amount of food you want to feed : ");
        toFeed = sc.nextInt();
        showStatus();
    }
//    ===== END FIRST SETTING =====

    //    ===== ADD FOOD =====
    public void addFood() {
        System.out.print("What box you want to add");
        chooseBox = sc.nextInt() - 1;
        System.out.print("Enter your amount : ");
        amount = sc.nextInt();
        supply[chooseBox].add(amount);
        showStatus();
    }
//    ===== END ADD FOOD =====

//    ===== SHOW STATUS =====
    public void showStatus() {
        System.out.println("=*=*=*=*=*=*=*=*=*=*");
        System.out.println("     **STATUS**     ");
        for (int i = 0; i < supply.length; i++) {
            System.out.println(supply[i].getName() + " => Food Amount : " + supply[i].getQuantity());
        }
        System.out.println("Time to feed => " + timeToFeed + " Hr/time");
        System.out.println("Amount food to feed => " + toFeed);
        System.out.println("=*=*=*=*=*=*=*=*=*=*");
    }
//    ===== END SHOW STATUS =====

//    ===== SHOW REMAIN FOOD =====
    public void showRemainFood() {
        for (int i = 0; i < supply.length; i++) {
            System.out.println(supply[i].getName() + " => Food Amount : " + supply[i].getQuantity());
        }
    }

//    ===== END SHOW REMAIN FOOD =====

//    ===== EDIT SETTINGS =====
    public void editSetiing() {
        System.out.print("1. Edit time for feeding" +
                "\n2. Edit amount food to feed" +
                "\nWhat do you want to edit? : ");
        int edit = sc.nextInt();
        if (edit == 1) {
            System.out.print("Enter your new time : ");
            int newTime = sc.nextInt();
            timeToFeed = newTime;
        } else if (edit == 2) {
            System.out.print("Enter your new amount : ");
            int newAmount = sc.nextInt();
            toFeed = newAmount;
        } else {
            System.out.print("*** Please try again ***");
            editSetiing();
        }
    }
//    ===== END EDIT SETTINGS =====

//    ===== CHECK SUPPLY =====
    public void checkSupply() throws InterruptedException {
        for (int i = 0; i < supply.length; i++) {
            if (supply[i].getQuantity() <= 0) {
                if (supply[i].getQuantity() < toFeed) {
                    System.out.println("Not enough food in " + supply[i].getName() + " to feed.");
                }else {
                    System.out.println("Not enough food in " + supply[i].getName() + " to feed.");
                }
            }else{supply[i].feed(toFeed); break;}
        }
    }
//    ===== END CHECK SUPPLY =====

//    ===== START FEEDING =====
    public void startFeed() throws InterruptedException {
        do {
            checkSupply();
            int time = timeToFeed;
            do {
                Thread.sleep(timeToFeed * 1000); //**FOR PRESENTATION** timeToFeed(sec) => timeToFeed(mill)
//                Thread.sleep(timeToFeed*60*60*1000); //timeTofeed(Hr) => timeToFeed(min) => timeToFeed(sec) => timeToFeed(mill)
                System.out.println(time + " minutes to feed.");
                time--;
            } while (time != 0);
            Thread.sleep(500);
            System.out.println("Feeding");
            showRemainFood();
        }while (supply[0].getQuantity() != 0 || supply[1].getQuantity() != 0 || supply[2].getQuantity() != 0 || supply[0].getQuantity() != 0 && supply[1].getQuantity() != 0 && supply[2].getQuantity() != 0);
    }

}
