/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enc;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Enc  {

   
    public static void main(String[] args) {
 
       new work(); 
  
    }
  
}

class work extends JFrame{
 Character rot11[]={'c','m','p','l','f','a','t','y','w','z','d','k','i','n','b','e','v','u','j','x','g','q','h','r','s','o'};
 Integer rot22[]={3,9,10,21,17,5,12,8,25,16,13,2,11,15,4,14,20,18,6,7,22,24,1,19,23,0};  
 Character rot33[]={'k','o','m','q','t','v','a','e','z','r','b','x','l','p','c','h','i','s','y','f','u','j','w','d','g','n'};
       
     ArrayList <Character> FirstRot = new ArrayList<>(Arrays.asList(rot11));
     ArrayList <Integer> SecondRot = new ArrayList<>(Arrays.asList(rot22));
     ArrayList <Character> thirdRot3 = new ArrayList<>(Arrays.asList(rot33)); 
        
     ArrayList <Character> dFirstRot = new ArrayList<>(Arrays.asList(rot11));
     ArrayList <Integer> dSecondRot = new ArrayList<>(Arrays.asList(rot22));
     ArrayList <Character> dthirdRot3 = new ArrayList<>(Arrays.asList(rot33)); 
        
     JButton b1; JButton b2;  JTextArea t1; JTextField f; JButton b3; JButton b4; 
     JPanel p1,p2;
  work(){  
p1=new JPanel(new BorderLayout());     
f=new JTextField ("Enter the word you want to encrypt");
f.setFont(new Font("", Font.PLAIN, 15));
t1=new  JTextArea();
t1.setFont(new Font("", Font.PLAIN, 30));
p1.add(f,BorderLayout.NORTH);
p1.add(t1,BorderLayout.CENTER);
p2=new JPanel(new FlowLayout());
b1=new JButton("Encrypt");
b2=new JButton("Decrypt");
b3=new JButton("Reset");
b4=new JButton("Skip");
p2.add(b1);
p2.add(b2);
p2.add(b3);
p2.add(b4);
  f.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
  f.setText("");
  t1.setText("");
  }
});   
b1.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae) {
        String s=f.getText();
        char word[]=s.toCharArray();
        StringBuilder wor= arrange(word);
        t1.setText(wor.toString());
    }
});
b2.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae) {
        String s=f.getText();
        char word[]=s.toCharArray();
        StringBuilder wor= dec(word);
        t1.setText(wor.toString());
    }
  
});

b3.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae) {
    FirstRot = new ArrayList<>(Arrays.asList(rot11));
    SecondRot = new ArrayList<>(Arrays.asList(rot22));
    thirdRot3 = new ArrayList<>(Arrays.asList(rot33)); 
    dFirstRot = new ArrayList<>(Arrays.asList(rot11));
    dSecondRot = new ArrayList<>(Arrays.asList(rot22));
    dthirdRot3 = new ArrayList<>(Arrays.asList(rot33)); 
    
    }
});
b4.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae) {
       String n=f.getText();
       int skip=Integer.parseInt(n);
       skip(skip);
    
    }
});
 
 add(p1,BorderLayout.CENTER);
 add(p2,BorderLayout.SOUTH);
 setSize(350,250);
 setLocationRelativeTo(null);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setVisible(true);    }
        
  public  StringBuilder arrange(char [] text){
     StringBuilder word=new StringBuilder();
     char neww;
     
        int cr1=0; int cr2=0; 
        for(int i=0;i<text.length;i++){
        neww=thirdRot3.get(getindexofnum(SecondRot,getindex(FirstRot,text[i])));
        word.append(neww);
      
          cr1++;
          FirstRot.add(0,FirstRot.remove(25));
          if(cr1==26)
          { cr2++; cr1=0;
        SecondRot.add(0,SecondRot.remove(25));
          }
        if(cr2==26)
        {  cr2=0;
           thirdRot3.add(0,thirdRot3.remove(25));
         }   
         }
        return word;
  }
    
   public  int getindex(ArrayList <Character>rot,Character letter){ int i=0;
       for( ;i<rot.size();i++){
        if(letter.equals(rot.get(i))) 
            return i;
       }
     return i;  
   }
   
    public  int getindexofnum(ArrayList <Integer> arr,int num){ int i=0;
       for( ;i<arr.size();i++){
        if(arr.get(i)==num) 
            return i;
       }
     return i;  
   }
public StringBuilder dec(char [] text){ 

    StringBuilder word=new StringBuilder();
    char neww;

        int cr1=0; int cr2=0; 
        for(int i=0;i<text.length;i++){
          neww=dFirstRot.get(dSecondRot.get(getindex( dthirdRot3,text[i])));
          word.append(neww);
         
          cr1++;
         dFirstRot.add(0,dFirstRot.remove(25));
          if(cr1==26)
          { cr2++; cr1=0;
       dSecondRot.add(0,dSecondRot.remove(25));
          }
        if(cr2==26)
        {   cr2=0;
             dthirdRot3.add(0, dthirdRot3.remove(25));            
  } }
        return word;
  }
void skip(int skip){ 
int cr1=0; int cr2=0; int  dcr1=0; int dcr2=0;
for(int i=1;i<=skip;i++){  
 cr1++;
 FirstRot.add(0,FirstRot.remove(25));
 if(cr1==26)
 { cr2++; cr1=0;
 SecondRot.add(0,SecondRot.remove(25));
 }
 if(cr2==26)
 {  cr2=0;
 thirdRot3.add(0,thirdRot3.remove(25));
     }    
 dcr1++;
 dFirstRot.add(0,dFirstRot.remove(25));
 if( dcr1==26)
 { dcr2++;  dcr1=0;
 dSecondRot.add(0,dSecondRot.remove(25));
 }
 if(dcr2==26)
 {   dcr2=0;
 dthirdRot3.add(0,dthirdRot3.remove(25));            
 }
 }                 }


}
//class rules extends JFrame{JLabel l1; JLabel l2; JLabel l3;
//    rules(){ this.setTitle("Rules");
//        this.setLayout(new GridLayout(3,1,0,0));
//       this.getContentPane().setBackground(Color.WHITE);
//        l1=new JLabel ("• Letters have to be small");
//        l2=new JLabel ("•There shoud not be any spaces betwen the words you typed");
//        l3=new JLabel ("•you have to decrypt every encrypted message to get correct results");
//        this.add(l1);  this.add(l2); this.add(l3);
//        setSize(420,250);
//  setLocationRelativeTo(null);
//  setVisible(true);  
//  
//    }
//}