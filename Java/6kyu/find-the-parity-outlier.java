/* Details

You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.

Examples
[2, 4, 0, 100, 4, 11, 2602, 36]
Should return: 11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21]
Should return: 160 (the only even number)

*/

// My Solution
public class FindOutlier{
  /*
  Paramaters: int[] integers
  Returns: int outlier
  Description: int[] integers is an array of indetermined size that has all odd or even numbers, except 1 entry, this method returns that one outlier
  */
  static int find(int[] integers){
    int[] evenOrOdd = new int[integers.length];
    int sum = 0;
    int index = 0;
    for( int i = 0; i < integers.length; i++){
      evenOrOdd[i] = Math.abs(integers[i]%2);
    }
    for(int i = 0; i< evenOrOdd.length; i++){
      sum += Math.abs(evenOrOdd[i]);
    }
    if (sum == 1) {
      for( int i = 0; i < evenOrOdd.length; i++) {
        if (evenOrOdd[i] == 1) {
          index = i;
        }
      }
    }
    else {
      for( int i = 0; i < evenOrOdd.length; i++) {
        if (evenOrOdd[i] == 0) {
          index = i;
        }
      }
    }
    
    int outlier = integers[index];
    
  return outlier;
}}

// Top rated
import java.util.Arrays;

public class FindOutlierBest{
    public static int find(int[] integers) {
        // Since we are warned the array may be very large, we should avoid counting values any more than we need to.

        // We only need the first 3 integers to determine whether we are chasing odds or evens.
        // So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
        // It will be 0 for even numbers and 1 for odd numbers.
        // Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
        int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
        int mod = (sum == 0 || sum == 1) ? 1 : 0;

        return Arrays.stream(integers).parallel() // call parallel to get as much bang for the buck on a "large" array
                .filter(n -> Math.abs(n) % 2 == mod).findFirst().getAsInt();
    }
}