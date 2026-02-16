package ca.mcmaster.sfwreng3s03;
public class A1_Q2_Program3_Correct {
/**
 * Counts positive elements in array
 *
 * @param x array to search
 * @return number of positive elements in x
 * @throws NullPointerException if x is null
 */
 public static int countPositive(int[] x)
 {
 int count = 0;

 for (int i=0; i < x.length; i++)
 {
 if (x[i] > 0)
 {
 count++;
 }
 }
 return count;
 }

 public static void main(String[] args) {
     int[] x = {-4, 2, 0, 2};
     System.out.println(countPositive(x));

 }

}

