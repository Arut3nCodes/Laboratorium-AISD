package base;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import algorithms.*;

public class Simulation {
    int[] tab;

    public Simulation(){
        System.out.println("");

        generujCiagLiczb();
        distanceTabGenerator dtg = new distanceTabGenerator();
        ArrayList<Integer> al1 = dtg.generateA(tab.length);
        ArrayList<Integer> al2 = dtg.generateB(tab.length);
        ArrayList<Integer> al3 = dtg.generateC(tab.length);
        ArrayList<Integer> al4 = dtg.generateD(tab.length);
        ArrayList<Integer> al5 = dtg.generateE(tab.length);
        ArrayList<Integer> al6 = dtg.generateF(tab.length);

        int[] arr1 = al1.stream().mapToInt(i -> i).toArray();
        int[] arr2 = al2.stream().mapToInt(i -> i).toArray();
        int[] arr3 = al3.stream().mapToInt(i -> i).toArray();
        int[] arr4 = al4.stream().mapToInt(i -> i).toArray();
        int[] arr5 = al5.stream().mapToInt(i -> i).toArray();
        int[] arr6 = al6.stream().mapToInt(i -> i).toArray();


        System.out.println("\nShell Sort V1");
        System.out.println("hi = 3hi-1 + 1");
        ShellSortV1 ss1 = new ShellSortV1(tab.clone(),arr1);
        System.out.println("2^k - 1:");
        ShellSortV1 ss2 = new ShellSortV1(tab.clone(),arr2);
        System.out.println("2^k + 1:");
        ShellSortV1 ss3 = new ShellSortV1(tab.clone(),arr3);
        System.out.println("Fibonacci:");
        ShellSortV1 ss4 = new ShellSortV1(tab.clone(),arr4);
        System.out.println("n/2:");
        ShellSortV1 ss5 = new ShellSortV1(tab.clone(),arr5);
        System.out.println("hi=0,75h-1");
        ShellSortV1 ss6 = new ShellSortV1(tab.clone(),arr6);
        System.out.println();

        System.out.println("\nShell Sort V2");
        System.out.println("hi = 3hi-1 + 1");
        ShellSortV2 ss21 = new ShellSortV2(tab.clone(),arr1);
        System.out.println("2^k - 1:");
        ShellSortV2 ss22 = new ShellSortV2(tab.clone(),arr2);
        System.out.println("2^k + 1:");
        ShellSortV2 ss23 = new ShellSortV2(tab.clone(),arr3);
        System.out.println("Fibonacci:");
        ShellSortV2 ss24 = new ShellSortV2(tab.clone(),arr4);
        System.out.println("n/2:");
        ShellSortV2 ss25 = new ShellSortV2(tab.clone(),arr5);
        System.out.println("hi=0,75h-1");
        ShellSortV2 ss26 = new ShellSortV2(tab.clone(),arr6);
        System.out.println();

        System.out.println("\nShell Sort V2");
        System.out.println("hi = 3hi-1 + 1");
        ShellSortV3 ss31 = new ShellSortV3(tab.clone(),arr1);
        System.out.println("2^k - 1:");
        ShellSortV3 ss32 = new ShellSortV3(tab.clone(),arr2);
        System.out.println("2^k + 1:");
        ShellSortV3 ss33 = new ShellSortV3(tab.clone(),arr3);
        System.out.println("Fibonacci:");
        ShellSortV3 ss34 = new ShellSortV3(tab.clone(),arr4);
        System.out.println("n/2");
        ShellSortV3 ss35 = new ShellSortV3(tab.clone(),arr5);
        System.out.println("hi=0,75h-1");
        ShellSortV3 ss36 = new ShellSortV3(tab.clone(),arr6);
        System.out.println();



    }
    public void generujCiagLiczb(){
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Podaj ilosc probek");
        int ilosc = sc.nextInt();
        System.out.println("Podaj gorny limit probek");
        int gornyLimit = sc.nextInt();

        tab = new int[ilosc];

        for(int i = 0; i < ilosc; i++){
            tab[i] = ran.nextInt(gornyLimit + 1);
        }
        System.out.println("Wygenerowano ciag do sortowania");
        if(ilosc <= 100) {
            for(int i = 0; i < ilosc; i++){
                System.out.print(tab[i] + " ,");
            }
            System.out.println();
        }
    }
}
