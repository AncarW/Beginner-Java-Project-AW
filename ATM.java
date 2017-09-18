/*
*CMIS 242 Project 2
*@author Ancar Willis
*/
//Import Data
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

//ATM GUI class creates JFrame Window
public class ATM extends JFrame implements ActionListener{
    
    //Variable Declaration
    private JButton withdrawl;
    private JButton deposit;
    private JButton transfer;
    private JButton balance;
    private JRadioButton checking;
    private JRadioButton savings;
    private JTextField textbar;
    private ButtonGroup group;
    private double[] BalanceInAccount;   
    int meatloaf;//couldnt think of a better name holds variable for accounts
    int surecharge =0;
    
    //ATM Constructor Declares interfaces within window
    public ATM(){
        super("ATM Machine");
        setLayout(new FlowLayout());
    //adds buttons Withdrawl, deposit,transfer,balance
        withdrawl =new JButton("Withdrawl");
        add(withdrawl);
        withdrawl.addActionListener(this);
        deposit =new JButton("Deposit");
        add(deposit);  
        deposit.addActionListener(this);
        transfer =new JButton("Transfer");
        add(transfer);  
        transfer.addActionListener(this);
        balance =new JButton("Balance");
        add(balance);
        balance.addActionListener(this);
                
     //adds radios checking and savings   
        checking = new JRadioButton("Checking",true);
        checking.addActionListener(this);
        add(checking);
        savings = new JRadioButton("Savings",false);
        savings.addActionListener(this);
        add(savings);
     //groups checking and savings radios only one selected at a time   
        group = new ButtonGroup();
        group.add(checking);
        group.add(savings);
    //adds text input field    
        textbar = new JTextField(20);
        add(textbar);
    //creates an array to hold checking and savings account balances   
        BalanceInAccount = new double[2];
        
        }
 //Accounts Class details mechanics associated with each action   
   class Accounts{
       //performs balance calculations
       public void balanceCalc(){
           double b;
       b = BalanceInAccount[meatloaf];
       textbar.setText(String.valueOf(b));
       System.out.println(b);
        }
       //performs deposit calculations
       public void depositCalc(){
           double a,b;
           try{
            a = Double.parseDouble(textbar.getText());
           
            BalanceInAccount[meatloaf]= a +BalanceInAccount[meatloaf];
            b =  BalanceInAccount[meatloaf]; 
           textbar.setText(String.valueOf(b));
            System.out.println(b);
           }
           //catches error for non numerical entries
           catch(NumberFormatException nfe){
             JOptionPane.showConfirmDialog(null,"Only Numerical Values Authorized");
                                      
           }
       
       }
       //performs transfer calculations
       public void transferCalc(){
       double a,b;
       a = Double.parseDouble(textbar.getText());
        if (meatloaf ==0) {
            BalanceInAccount[0] = BalanceInAccount[0] -a;
            BalanceInAccount[1] = BalanceInAccount[1] +a;
        }else if (meatloaf ==1){
             BalanceInAccount[1] = BalanceInAccount[1] -a;
            BalanceInAccount[0] = BalanceInAccount[0] +a;                        
        }
       }
       //performs withdrawl calculations
       public void withdrawCalc(){
           double a,b;
           a = Double.parseDouble(textbar.getText());
        surecharge++;//increments each withdrawl
        if(a % 20 == 0){//requires withdrawls be a multiple of 20
        
        //logic which prevents withdraws in excess of available balance    
        if(BalanceInAccount[meatloaf]-a<0){
            insufficentfunds error = new insufficentfunds();
        error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        error.setSize(0,0);
        error.setVisible(true);
            
        }else{
        BalanceInAccount[meatloaf]= BalanceInAccount[meatloaf] -a;
        if(surecharge>4){
       //adds surecharge of 1.50 if over than 4 withdraws are made
            BalanceInAccount[meatloaf]= BalanceInAccount[meatloaf] -1.50;
        }
        //creates windows stating success once action is completed
        success actionsucced = new success();
        actionsucced.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        actionsucced.setSize(0,0);
        actionsucced.setVisible(true);
        }}else{
            //creates window stating failure if action fails
        withdrawlincr error = new withdrawlincr();
        error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        error.setSize(0,0);
        error.setVisible(true);
        }
        b = BalanceInAccount[meatloaf];    
        
        textbar.setText(String.valueOf(b));
        System.out.println(b);
       
       }
    
   }
   //responses to buttons    
   public void actionPerformed(ActionEvent e) {
            
            
           //calls withdraw method when button is pressed
        if(e.getSource()==withdrawl){
            new Accounts().withdrawCalc();
         
        }
        //calls deposit method when button is pressed
        else if(e.getSource()==deposit){
            new Accounts().depositCalc();
            
        //calls balance method when button is pressed  
        }else if(e.getSource()==balance){
           new Accounts().balanceCalc();
           
        }
        //calls transfer method when button is pressed
        if(e.getSource()==transfer){
        new Accounts().transferCalc();
               
        }
        
        //Associates checking account to checking variable
        if(e.getSource()==checking){
         meatloaf = 0;
            }
        //Associates checking account to savings variable
        else if(e.getSource()==savings){
            meatloaf = 1;
        }
    
    }
        
        
    //creates insufficent funds window and response
       class insufficentfunds extends JFrame{
       
           public insufficentfunds(){                             
               JOptionPane.showMessageDialog(null,"Insufficent Funds");
               
           }                         
       } 
    //creates success funds window and response   
       class success extends JFrame{
       
           public success(){                             
               JOptionPane.showMessageDialog(null,"Success");
               
           }                         
       }
       
    //creates withdraw error window and response   
       class withdrawlincr extends JFrame{
       
           public withdrawlincr(){                             
               JOptionPane.showMessageDialog(null,"Only Dispenses Increments of 20");
               
           }                         
       }
         
        
        public static void main(String[] args) {
        // main method creates new ATM action
        
        ATM visit = new ATM();
        visit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visit.setSize(250,175);
        visit.setVisible(true);
    } 
        
        
        
        
    }
   
    
    
    
   
    
    