import java.util.Arrays;

public class CircleBarn {

  public static void main(String[] args) {
    int[] Rooms= {4,7,8,6,4};
    
    for (int a =0; a<5; a++){
      int diff = 29;
      int sum = 0;
      int a1 = a;
      while (diff != 0) {
        int a2 = (a1 % 5);
        diff = diff - Rooms[a2];
        sum += diff;
        a1 += 1;
      }
      System.out.println(sum);
    }
  }
}
      

    