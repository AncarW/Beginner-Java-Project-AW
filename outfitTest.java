import java.util.Scanner;
class ChunLi{

    String Top;
    String Bottom;
    String Head;
    
    void clothes(int Ribbon, int Shirt, int Pants){
    if (Ribbon ==1){
        Head = " Pink Ribbon,";
    }else{
     Head = " Silk Bow,";
                }
    
    if (Shirt ==1){
       Top = " Black Dogi,";
    }else{
     Top = " Blue Dress Shirt,";
                }
    
if (Pants ==1){
       Bottom = " Pink Mini Skirt";
    }else{
     Bottom = " Blue Dress Pants";
                }
    
}
    void grid(){
String table[]=new String[3];
table[0]=Bottom;
table[1]=Top;
table[2]=Head;

System.out.println(table[2]+table[1]+table[0]);
}
    
}
        
public class outfitTest {//main method class object

    public static void main(String[] args) {//main method

        System.out.println("What will you dress Chun Li in?");
        System.out.println("Please Enter a Selection: Press 1 for Ribbon or 2 for Bow");
        Scanner sc1 = new Scanner (System.in);
      int h = sc1.nextInt();

      System.out.println("Please Enter a Selection: Press 1 for Dogi or 2 for Shirt");      
      Scanner sc2 = new Scanner (System.in);
      int i = sc2.nextInt();

      System.out.println("Please Enter a Selection: Press 1 for Pants or 2 for Mini Skirt");      
      Scanner sc3 = new Scanner (System.in);
      int j = sc3.nextInt();
            
       ChunLi outfit= new ChunLi();
       System.out.println("Chun Li has chose to wear:");
        outfit.clothes(j, h, i);
        outfit.grid();
  
    }
    
}