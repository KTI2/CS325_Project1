package cs325_project1;

/**
 * @author Kevin Stephenson CS 325 1/29/14
 */
public class CS325_Project1 {

    public static void main(String[] args) {
        int[] myArray = {4, 2, 5, 3, 1, 8};
        int inversionCount = 0;
        
        
        inversionCount = bruteForce(myArray);
        System.out.println("Inversioncount = " + inversionCount);
    }

    public static int bruteForce(int[] myArray) {
        int k;
        int arrayLength = myArray.length;
        int counter = 0;

        for (int i = 0; i < arrayLength; i++) {
            for (k = i+1; k < arrayLength; k++) {
                if (myArray[k] < myArray[i])
                    counter++;
            }
        }

        return counter;
    }
    
    public static int divideNConquer(int[] myArray) {
        
        return 0;
    }
}
