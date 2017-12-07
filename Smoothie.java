public class Smoothie implements Named{
  private Fruit fruit1,fruit2;
  
  public Smoothie(Fruit f1, Fruit f2){
    fruit1 = f1;
    fruit2 = f2;
  }
  
  public String getName(){
    return fruit1.getName() + "and" + fruit2.getName();
  }
  
  public int getCalories(){
    return fruit1.getCalories() + fruit2.getCalories();
  }
  
}