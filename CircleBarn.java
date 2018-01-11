import java.io.*;
import java.util.*;


public class CircleBarn {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
    int n = Integer.parseInt(br.readLine());
    int[] cows = new int[n];
    for(int i=0; i < n; i++){
      cows[i] = Integer.parseInt(br.readLine());
    }
    br.close();
    int ans = n*n*100;                                         
    for (int a =0; a<n; a++){
      int diff = Arrays.stream(cows).sum();
      int sum = 0;
      int a1 = a;
      while (diff != 0) {
        int a2 = (a1 % n);
        diff = diff - cows[a2];
        sum += diff;
        a1 += 1;
      }
      if(sum < ans){
        ans = sum;
      }
      
    }
    pw.println(ans);
    pw.close();
  }
}    

    