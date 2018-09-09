import java.lang.*;

 interface Gender {
    public void isMale();
    
    public void isFemale();
    
}

 interface WorkPlace{
    public void isSafe();
    
}



   abstract class Person implements Gender,WorkPlace{
    String name;
    int age;
    
    public abstract void eat();
    
    
    public abstract void work();
    
    public String name()
    {
        return name;
    }
    
}

class Teacher extends Person{
    
    class TA {
    
        final int HourlieSalary=10;
    
        public int HourlieSalary()
        {
            return HourlieSalary;
        }
        
    }
    
    public void eat()
    {
        System.out.println("Teacher eats");
    }
    
    public void work()
    {
        System.out.println("Teacher works");
    }
    public void isMale(){
        System.out.println("Yes!!");
    }
    
    public void isFemale(){
        System.out.println("No!!");
    }
    public void isSafe(){
        System.out.println("YEs!!");
    }

    
}
public class HelloWorld{

     public static void main(String []args){
      Teacher p= new Teacher();
      p.eat();
      
     }
}
 

