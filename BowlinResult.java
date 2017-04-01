/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rakesh;

/**
 *
 * @author rakesh
 */


import java.util.Scanner;
public class BowlingResult {

   
    public static void main(String[] args) {
    
       Scanner si=new Scanner(System.in);
       int a,tv=0,input;
       
       System.out.println("How many players want to play");
       a=si.nextInt();
       
       Player p[]=new Player[a];
       
        for (int i = 0; i < a; i++) {
            System.out.println("Enter the name of player "+(i+1));
            p[i]=new Player(si.next());          
        }
        
    
        for (int f = 0; f < 10; f++) {
            
            for (int ab = 0; ab < a; ab++) {
                
                for (int s = 0; s < 2; s++) {
                    
                    
                    System.out.println("enter the score for "+p[ab].getPlayer()+ "  frame "+(f+1)+"  turn " +(s+1));
                    input=si.nextInt();
                    if(input>10 || input< 0)
                    {
                        System.out.println("Enter Valid number between 0 and 10");
                        input=si.nextInt();
                    }
                    if(s==1 && f<9)
                    {
                        if((input+p[ab].getScore(f, 0))>10)
                        {
                            System.out.println("Enter the number between 0 and "+(10-p[ab].getScore(f, 0)));
                            input=si.nextInt();
                        }
                    }
                    p[ab].setScore(input,f,s);
                   
                    if(s==0 && p[ab].getScore(f, 0)==10 )
                    {
                       if(f!=9)
                        break;
                    }
                }
               
                if(f==9)
                {
                    int count=p[ab].getScore(f, 0)+p[ab].getScore(f, 1);
                    if(count>=10)
                    {
                   System.out.println("enter the score for "+p[ab].getPlayer()+ "  frame "+(f+1)+" extra chance"); 
                   p[ab].extra_chance=si.nextInt();                    
                    }
                  p[ab].total_score();  
                }
            }
        }
        
        System.out.println("");
        
        Player temp1=new Player("rakesh");
        int count=0;
        
        System.out.println("Score Display");
   
        for (int i = 0; i < a; i++) {
        System.out.println("******************************************************************************************");
        System.out.println("Game score for "+p[i].getPlayer()+" is "+p[i].total_score()); 
        System.out.println("******************************************************************************************");
        p[i].display_score_player();
       p[i].frame_score();
      
            System.out.println(" ");
       
       if(count<p[i].total_score())
       {
           count=p[i].total_score();
           temp1=p[i];         
               
       }
       
        }
        
        System.out.println("Congratulations!!!! The Winner is "+ temp1.getPlayer());
        
        
    }
    
}
