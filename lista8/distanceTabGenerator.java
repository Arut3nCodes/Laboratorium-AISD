package base;

import java.util.ArrayList;

public class distanceTabGenerator {
    public distanceTabGenerator(){
    }

    ArrayList<Integer> generateA(int limit) { // h1 = 1 hi+1 = 3hi + 1
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1; i <= limit; i = 3*i + 1){
            al.add(i);
            System.out.print(i + ", ");
        }
        System.out.println();
        return al;
    }

    ArrayList<Integer> generateB(int limit) { //2^k - 1
        ArrayList<Integer> al = new ArrayList<>();
        int h = 1;
        for(int i = 2; h <= limit; i++){
            al.add(h);
            System.out.print(h + ", ");
            h = (int)Math.pow(2, i) - 1;
        }
        System.out.println();
        return al;
    }

    ArrayList<Integer> generateC(int limit) { //2^k + 1
        ArrayList<Integer> al = new ArrayList<>();
        int h = 1;
        for(int i = 1; h <= limit; i++){
            al.add(h);
            System.out.print(h + ", ");
            h = (int)Math.pow(2, i) + 1;
        }
        System.out.println();
        return al;
    }

    ArrayList<Integer> generateD(int limit){ //fibonacci
        ArrayList<Integer> al = new ArrayList<>();
        int num1 = 1;
        int num2 = 1;
        int temp;
        while(num1 < limit){
            al.add(num1);
            System.out.print(num1 + ", ");
            temp = num1;
            num1 = num1 + num2;
            num2 = temp;
        }
        System.out.println();
        return al;

    }
    
    ArrayList<Integer> generateE(int limit){ // n/2
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = limit; i >= 1 ; i /= 2){
            al.add(0, i);
            System.out.print(i + ", ");
        }
        return al;
    }

    ArrayList<Integer> generateF(int limit){ //1,25hi
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = limit; i >= 1; i = (int)(i * 0.75)){
            al.add(0, i);
            System.out.print(i + ", ");
        }
        return al;
    }
}
