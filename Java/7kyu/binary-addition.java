/*
Implement a function that adds two numbers together and returns their sum in binary. The conversion can be done before, or after the addition.

The binary number returned should be a string.

Examples:(Input1, Input2 --> Output (explanation)))

1, 1 --> "10" (1 + 1 = 2 in decimal or 10 in binary)
5, 9 --> "1110" (5 + 9 = 14 in decimal or 1110 in binary)

*/

// My Solution
public class Kata{
  /*
  * Returns: int
  * Description: A simple program to take to ints, add them, and then return their binary value as a string
  */
  
  public static String binaryAddition(int a, int b){
    
    // first add the numbers
    int sum = a + b;
    
    // check if sum is 0, if it is return "0"
    if (sum == 0) {
      return "0";
    }
    
    //here we create a string to store the conversion
    StringBuilder binary = new StringBuilder();
    
    //quotient here is to store the number as we calculate the binary form of the sum
    Integer quotient = sum;
    
    // this while loop keeps dividing the sum by 2, keeping the quotient, as it divides it adds the quotient to the string to create the binary
    while (quotient >0) {
      int remainder = quotient %2;
      binary.append(remainder);
      quotient /= 2;
    }
    
    //because we are appending the 1 or 0 the binary string is reveresed, so if we just reverse it again it should be right
    binary = binary.reverse();
    
    //StringBuilder need to be converted, can do this with reverse
    String binaryString = binary.toString();
    
    return binaryString;
  }
}

// Best solution
public class Kata{
  
  public static String binaryAddition(int a, int b){
    return Integer.toBinaryString(a + b);
  }
}