import java.io.*;
import java.util.*;
import java.util.Arrays.*;

public class LoadBalancing {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
    String[] s = br.readLine().split(" ");
    int cowNum = Integer.parseInt(s[0]);
    int maxCow = Integer.parseInt(s[1]);
    
    int[] cowsX = new int[cowNum];
    int[] cowsY = new int[cowNum];
    
    for(int i = 0; i < cowNum; i++){
      String[] t = br.readLine().split(" ");
      cowsX[i] = Integer.parseInt(t[0]);
      cowsY[i] = Integer.parseInt(t[1]);
    }
    
    br.close();

    int sumX = Arrays.stream(cowsX).sum();
    int sumY = Arrays.stream(cowsY).sum();    
    float fltX = (float) sumX/cowNum;
    float fltY = (float) sumY/cowNum;
    int avgX = Math.round(fltX);
    int avgY = Math.round(fltY);
    
    //if(avgX % 2 == 1){
      //avgX += -1;}
    
    //if(avgY % 2 == 1){
      //avgY += -1;}
    
    
    int[] quad = {0,0,0,0}; 
    
    for( int i = 0; i < cowNum; i++){
      if(cowsX[i] > avgX){
        if(cowsY[i] > avgY){
          quad[0] += 1;
        }
        else if(cowsY[i] < avgY){
          quad[3] += 1;
        }
      }
      
      else if(cowsX[i] < avgX){
        if(cowsY[i] > avgY){
          quad[1] += 1;
        }
        else if(cowsY[i] < avgY){
          quad[2] += 1;
        }
      }
    }
    int max = 0;
    for (int i=0; i<4;i++){
      if (quad[i] > max){
        max = quad[i];
      }
    }
    
    pw.println(max);
    pw.close();
    System.out.println(max);
  }
}