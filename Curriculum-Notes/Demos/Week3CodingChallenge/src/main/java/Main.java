//import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.*;

import java.io.*;

import java.lang.Math;

//Promt:
//        you have an arrary of N (5) elements.
//        Find and print the difference between the
//        Xth(2nd) and the Yth(4th) largest elements of the given array java

/*
Sample Input

        3
        3 1 2
        1 3

        Constraints
        1 <= N <= 1000
        1 <= X <= Y <= N
        1 <= A[i] <= 1000

        Output Format
        The output contains a single integer denoting the difference between the Xth and Yth largest elements of the given array.

        Sample Output

        2

        Explanation
        The 1st greatest element in the array is 3 and the 3rd greatest element in the array is 1.
*/

public class Main
    {
        public static int difference(int N, int[] Arr,int X,int Y){

            //this is default OUTPUT. You can change it.
            int result = 0;

            //write your Logic here:

            //this sorts the array from the smallest to the largest number
            //when we sort the array like this smallest to largest is the default

            //this solution is us sorting the array then making variables equal to the
            //Xth and Yth elements
            //then finding the difference and returning it

//            Arrays.sort(Arr);
//            int Xlargest = largestTogreatest.get(N-X);
//            int Ylargest = largestTogreatest.get(N-Y);

//            result = Xlargest - Ylargest;
//
//            return Math.abs(result);


            //this solution is basically the same only we are reversing the sorted array
            //to descend from largest to greatest

            Arrays.sort(Arr);

            ArrayList<Integer> largestTogreatest = new ArrayList<>();

            for(int int2:Arr) {
                largestTogreatest.add(0,int2);
            }

            System.out.println(largestTogreatest);
            int Xlargest = largestTogreatest.get(X-1);
            int Ylargest = largestTogreatest.get(Y-1);

            result = Xlargest - Ylargest;

            return Math.abs(result);
        }


        public static void main (String[] args)
        {
//            Scanner sc = new Scanner(System.in);

            //INPUT [uncomment & modify if required]
            int N = 5;
            int[] Arr = {12,77,8,10,6};

            int X = 2;
            int Y = 4;


            //OUTPUT [uncomment & modify if required]
//            public static int difference(int N, int[] Arr,int X,int Y)
            System.out.print(difference(N,Arr,X,Y));
        }
    }

