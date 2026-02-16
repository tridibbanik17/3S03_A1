package ca.mcmaster.sfwreng3s03;
public class A1_Q2_Program1_Incorrect {
  /**
 * Find last index of element
 *
 * @param x array to search
 * @param y value to look for
 * @return last index of y in x; -1 if absent
 * @throws NullPointerException if x is null
 */
  public static int findLast (int[] x, int y) {
    for (int i=x.length-1; i > 0; i--) {
      if (x[i] == y) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] x = {2, 3, 5};
    int y = 2;
    System.out.println(findLast(x, y));
  }
}


