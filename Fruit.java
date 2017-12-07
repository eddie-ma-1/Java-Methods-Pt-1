public class Fruit { 
  private int Cal;
  private double pH;
  private String name; 
  
  public Fruit(int c, double p, String n){
    Cal = c;
    pH = p;
    name = n;
  }
  
  public String getName(){
    return name;
  }
  
  public int getCalories(){
    return Cal;
  }
  
  public double getPH(){
    return pH;
  }
  
}
