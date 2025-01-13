package zth.datastructure.arrays;

public class ReverseStirng {


  // complexity O(n)
  // space O(n)

  public static  String reverseString(String input) {

    if(input == null || input.length() <= 1){
      return input;
    }


    int index = 0;
    int reverseIndex = input.length() - 1;

    char[] in = input.toCharArray();
    char[] out  = new char[input.length()];

    while(reverseIndex >= 0 ){
      out[index] = in[reverseIndex];
      index++;
      reverseIndex--;
    }

    return new String(out);
  }


  public static void main(String[] args) {
    System.out.println(reverseString("null"));
  }
}
