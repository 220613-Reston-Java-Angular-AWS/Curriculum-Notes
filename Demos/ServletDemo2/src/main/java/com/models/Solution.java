package com.models;

import java.util.ArrayList;

class Solution {

    static ArrayList<Integer> nums = new ArrayList<Integer>();
    static ArrayList<Integer> expectedNums = new ArrayList<Integer>();
    public static ArrayList<Integer> removeDuplicates (ArrayList<Integer> list) {


        for (int k : nums) {

            if (!expectedNums.contains(k)) {
                expectedNums.add(k);

            } else {

                expectedNums.remove(k);

            }
        }

        return expectedNums;



    }

    public static void main(String[] args) {

        expectedNums = removeDuplicates(expectedNums);

        System.out.println(expectedNums);
    }
}