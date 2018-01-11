import java.io.*;
import java.util.*;

public class BovineShuffle {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
    int n = Integer.parseInt(br.readLine()); 
    String[] s = br.readLine().split(" ");
    String[] pos = br.readLine().split(" ");
    
    int[] tpos = new int[n];
    int[] shuffle = new int[n];
    int[] twpos = new int[n];
    int[] opos = new int[n];
    int[] zpos = new int[n];
    
    for(int i =0; i <n; i++){
      shuffle[i] = Integer.parseInt(s[i]);
      tpos[i] = Integer.parseInt(pos[i]);
    }
    
    for( int i =0; i < n; i++){
      twpos[i] = tpos[shuffle[i] - 1];
    }
    for( int i =0; i < n; i++){
      opos[i] = twpos[shuffle[i] - 1];
    }
    for( int i =0; i < n; i++){
      zpos[i] = opos[shuffle[i] - 1];
    }
    
    for(int i=0 ; i < n ; i++){
      pw.println(zpos[i]);
    }
    pw.close();
  }
}