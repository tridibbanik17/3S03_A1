package ca.mcmaster.sfwreng3s03;
public class A1_Q2_Program2_Incorrect
{ 
/**
 * Finds last index of zero
 *
 * @param x array to search
 *
 * @return last index of 0 in x; -1 if there is no zero
 * @throws NullPointerException if x is null
 */
 public static int lastZero (int[] x)
 {
 for (int i = 0; i < x.length; i++)
 {
 if (x[i] == 0)
 {
 return i;
 }
 }
 return -1;
 }

 public static void main(String[] args)
 {
 int[] x = {0, 2, 0};
 System.out.println(lastZero(x));
 }
}

