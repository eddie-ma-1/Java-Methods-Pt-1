import java.io.*;
import java.util.*;
import java.util.Arrays.*;

public class MilkMeasurement{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
    int n = Integer.parseInt(br.readLine());
    System.out.println(n);
    String[] fin = new String[n];
    for (int i = 0; i < n; i++){
    String temp = br.readLine();
    String temp1 = temp.replaceAll(" ", "");
    String temp2 = temp1.replace("Mildred",":2").replace("Bessie",":1").replace("Elsie",":1");
    fin[i] = temp2;
  
  }
    System.out.println(n);
    Arrays.sort(fin);
    int[] milk = {7,7,7};
    int count = 0;
    int originalSame = 3;
    System.out.println(n);
    for (int i = 0; i < n; i++){
      System.out.println(i);
      int add , sign;
      int colonLoc = fin[i].indexOf(":");
      if (fin[i].contains("+")){
        sign = fin[i].indexOf("+") +1;
        add = Integer.parseInt(fin[i].substring((sign)));
      }
      else{
        sign = fin[i].indexOf("-") +1;
        add = -1 * Integer.parseInt(fin[i].substring(sign));
      }
      int cowD = Integer.parseInt((fin[i].substring((colonLoc+1),(colonLoc+2))));
      milk[cowD] = milk[cowD] + add;
      int max = Arrays.stream(milk).max().getAsInt();
      int newSame = 0;
      for(i =0; i<3; i++){
        if (milk[i] == max){
          newSame += 1;
        }
      }
      
      if (newSame != originalSame){
        count +=1;
      }
      originalSame = newSame;
    }
    pw.println(count);
    pw.close();
  }
}
         
          
        
      
        
         

        
         
          
          
          
            
      
       
                                  
        
    
  