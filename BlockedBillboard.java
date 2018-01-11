import java.io.*;
import java.util.*;


public class BlockedBillboard{

  
    
  public static void main(String[] args) throws IOException{
    //Save coordinates of all the billboards
    BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
    String[] b1 = br.readLine().split(" ");
    String[] b2 = br.readLine().split(" ");
    String[] t = br.readLine().split(" ");
    br.close();
    int[] BB1 = new int[4];
    int[] BB2 = new int[4];
    int[] truck = new int[4];
    
    for(int i = 0; i<4; i++){
      BB1[i] = Integer.parseInt(b1[i]);
      BB2[i] = Integer.parseInt(b2[i]);
      truck[i] = Integer.parseInt(t[i]);
    }
    
    //make limiters for the 'walls' of the billboard using the coordinates of corners, make sure
    // to check against all points later in the 
    //truck as it can cover 1, 2, neither, or both boards
    int LeftBB1 = BB1[0];
    int BotBB1 = BB1[1];
    int RightBB1 = BB1[2];
    int TopBB1 = BB1[3];
    int LeftBB2 = BB2[0];
    int BotBB2 = BB2[1];
    int RightBB2 = BB2[2];
    int TopBB2 = BB2[3];
    int blockedArea = 0;
    int area = ((RightBB1 - LeftBB1)*(TopBB1-BotBB1)) + ((RightBB2 - LeftBB2)*(TopBB2 - BotBB2));
    // case 0: Doesn't block anything, don't change area
    //Check if BB1 blocks any part of the truck
    if((LeftBB1 <= truck[2] && RightBB1 >= truck[0]) || (TopBB1 <= truck[3] || BotBB1 >= truck[1]))
    {
      int upperbound = Math.min(TopBB1, truck[3]);
      int lowerbound = Math.max(BotBB1, truck[1]);
      int leftbound = Math.max(LeftBB1, truck[0]);
      int rightbound = Math.min(RightBB1, truck[2]);
      blockedArea += (rightbound - leftbound)*(upperbound - lowerbound);
    }
    
    if((LeftBB2 <= truck[2] && RightBB2 >= truck[0]) || (TopBB2 <= truck[3] || BotBB2 >= truck[1]))
    {
      int upperbound = Math.min(TopBB2, truck[3]);
      int lowerbound = Math.max(BotBB2, truck[1]);
      int leftbound = Math.max(LeftBB2, truck[0]);
      int rightbound = Math.min(RightBB2, truck[2]);
      blockedArea += (rightbound - leftbound)*(upperbound - lowerbound);
    }
    pw.println(area - blockedArea);
    pw.close();
    
    
    
    

      
  }
}