package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SieveOfErasthosthenis {
    //used for finding prime numbers less than a given number
    //
    public static ArrayList<Integer> getPrimes(int number){
        boolean[] arr =new boolean[number+1];
        Arrays.fill(arr,true);

        arr[0]=arr[1]=false;

        for(int i=2;i*i<=number;i++){

            if(arr[i]){
                for(int j=i*i;j<=number;j=j+i){
                    arr[j]=false;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=2;i<=number;i++){
            if(arr[i]){
                result.add(i);
            }

        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getPrimes(n).toString());

    }
}
