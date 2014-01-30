/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs325_project1;

/**
 *
 * @author Kevin Stephenson CS 325 1/29/14
 */
public class Counter {

    private int[] myArray;
    private int[] helperArray;
    private int counter;
    public int arrayLength;

    public Counter(int[] inArray) {
        arrayLength = inArray.length;
        myArray = new int[arrayLength];
        helperArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            myArray[i] = inArray[i];
        }

    }

    public int bruteForce() {
        int k;
        counter = 0;

        for (int i = 0; i < arrayLength; i++) {
            for (k = i + 1; k < arrayLength; k++) {
                if (myArray[i] > myArray[k]) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public int divideNConquer(int start, int end) {
        counter = 0;
        int k;

        if (end - start <= 0) {
            return 0;
        }

        counter += divideNConquer(start, (start + end) / 2);    //Al
        counter += divideNConquer((start + end) / 2 + 1, end);     //Ar

        for (int i = start; i <= (start + end) / 2; i++) { //Each element in Al
            for (k = (start + end) / 2 + 1; k <= end; k++) {   //Each element in Ar
                if (myArray[i] > myArray[k]) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public int mergeNCount() {
        counter = 0;
        
        mergeSort(0, (arrayLength-1)/2);
        mergeSort((arrayLength-1)/2+1, arrayLength-1);
        
        return counter;
    }

    public void mergeSort(int start, int end) {
        //This actually modifies the array
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(start, middle);
            mergeSort(middle + 1, end);

            merge(start, middle, end);
        }
    }

    public void merge(int start, int middle, int end) {
        for (int i = start; i <= end; i++) {
            helperArray[i] = myArray[i];
        }

        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {
            if (helperArray[i] <= helperArray[j]) {
                myArray[k] = helperArray[i];
                i++;
                counter++;
            } else {
                myArray[k] = helperArray[j];
                j++;
                counter++;
            }
            k++;
        }

        while (i <= middle) {
            myArray[k] = helperArray[i];
            k++;
            i++;
        }
    }
    
    public void printArray() {
        System.out.println("Printing array.");
        for(int i = 0; i < arrayLength; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }
}
