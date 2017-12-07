public class Banana extends Fruit implements Named{
  private int length;
  public Banana(){
    super(120,4.8,"Banana");
    length = 8;
  }
  
  public Banana(int l){
    super((120/8)*(l),4.8,"Banana");
    length = l;
  }
  
  public int getLength(){
    return length;
  }
  
  
  public static void main(String[] args) { 
    Banana test = new Banana(10);
    System.out.println( test.getCalories());
  }
}
  
  