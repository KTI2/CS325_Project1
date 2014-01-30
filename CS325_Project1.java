package cs325_project1;

/**
 * @author Kevin Stephenson CS 325 1/29/14
 */
public class CS325_Project1 {

    public static void main(String[] args) {
        int[] myArray = {1, 5, 4, 8, 10, 2, 6, 9, 12, 11, 3, 7};
        int inversionCount;

        Counter counter = new Counter(myArray);
        
        inversionCount = counter.bruteForce();
        System.out.println("Brute force inversions = " + inversionCount);
        
        inversionCount = counter.divideNConquer(0, counter.arrayLength - 1);
        System.out.println("Divide and conquer inversions = " + inversionCount);
        
        counter.printArray();
        counter.counter=0;
        inversionCount = counter.mergeNCount(0, counter.arrayLength-1);
        System.out.println("Merge and count = " + inversionCount);
        
        counter.printArray();
    }
}
