/**
 * GearBox 
 * Utilizes several user parameters to calculate torque.
 * List detailed notes to be used for reference in future exercises.
 * @author ancarwillis
 */
import java.util.Scanner;//Initalizes Scanner utility (used to accept input from terminal)
class gearbox {//Sets Parameters for Object
    double x, y, z;//Gear Radius=x, Number of Gears=y, Force Applied=z 
    double torque, ratio;
    
    void gear(double radius, double force){//Method: Gear
    x=radius;
    z = force;
    }
    
    void numGears(double number){//Method: Number of Gears
    y = number;
    }
    
    void gearRatio(){//Method: Calculations
        ratio = x/y;
        torque = ratio*z;
    }
    void print(){//Method: Output to Terminal
    System.out.print("Torque:" + torque);
    }

}
        
public class GearBox0 {//Main class: Tests object

    public static void main(String[] args) {//main method

        System.out.println("Please Radius of Gear (nearest centimeters):  ");
        Scanner sc1 = new Scanner (System.in);
      double h = sc1.nextInt();
        
      System.out.println("Please Enter Force (nearest pounds): ");
        Scanner sc2 = new Scanner (System.in);
      double i = sc2.nextInt();
        
      System.out.println("Please Enter Number of gears: ");
        Scanner sc3 = new Scanner (System.in);
      double j = sc3.nextInt();  
      
        gearbox test1 = new gearbox();
        test1.gear(h,i);
        test1.numGears(j);
        test1.gearRatio();
        test1.print();
        
  
    }
    
}