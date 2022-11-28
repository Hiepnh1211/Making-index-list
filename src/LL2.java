import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.sampled.Line;



public class LL2 extends LL3{
	public static final int MAX_LETTER = 12;
	public static int l = 1;
	
	
	class Node1{
		String word;
		int count = 1;
		LL3 ln = new LL3();
		Node1 next;
		public Node1(String word) {
			this.word = word;
			this.next = null;
		}
	}
	public Node1 head = null;    

    public Node1 tail = null;
	
	
	public void insert(String word) 

    {    
        //Creating a new node   

        Node1 newNode = new Node1(word);  
        
        //Check if the word has appeared in the existing List
        
        Node1 current = head;
        
        
        while (current != null) {
			if(current.word.equals(word)){
				current.count++;
				current.ln.add(l);
				return;
			}
			current = current.next;
		}
        
        
        //checking of the list is empty   

        if(head == null) 

        {    

//if the given list is empty, making the two nodes head and tail to point to the newly created node newNode    

            head = newNode;    

            tail = newNode; 
            
            newNode.ln.add(l);
            
        }    

        else 

        {    

//otherwise the newNode will be added after tail so that the next pointer of tail points to    the newNode   

            tail.next = newNode;    

            tail = newNode;  
            
            newNode.ln.add(l);

        }   
        
    }
	
	public void displaylist() 

    {    

        //Pointing the head to the node called current    
        Node1 current = head;   

        if(head == null)

        {    

            System.out.println("The given list is empty");    

            return;    

        }    

        System.out.println("The data in the given list are: ");    

        while(current != null) 

        {    

            //printing each data in the list and next pointer pointing to the next node   
        	
            System.out.print(current.word + " "); 
            System.out.print(" " + current.count + " ");
            current.ln.showLine();
            current = current.next;    
            System.out.println();
        }    
        
        System.out.println();    

    }
	
	
	public static void main(String[] args) throws IOException {
		
		char[] wrd = new char[12];
		int i = 0;
		String w = null ; 
		
		LL stopW  = new LL();
		stopW.readStopW("stopW.txt", stopW);
		
		LL3 dong = new LL3();
		
		LL2 VBList = new LL2();
		File VanBan = new File("VanBan.txt");
	    // Create the File Reader object
	    FileReader vb = new FileReader(VanBan);
	    // Create the BufferedReader object
	    BufferedReader brvb = new BufferedReader(vb);  
	    int c = 0;             
	    // Read character by character
	    while((c = brvb.read()) != -1)
	    {
	        // convert the integer to char
	        char ch = (char) c;   
	        if(ch == '\n') {
	        	l++;
	        }
	        if(Character.isAlphabetic(ch)) {
	        	wrd[i] = (char) c;
	        	i++;
	        }
	        else{
	        	w = String.valueOf(wrd, 0,i);
	        	
	        	//Blank w for the next input
	        	for(int j = 0; j < i; j++) {
	    	    	wrd[j] = '\0';
	    	    }
	        	i=0;
	        	if(!w.isBlank() && !stopW.check1(w)) {
		        	VBList.insert(w);
		        }
	        	
	        } 
	    }
	    VBList.displaylist();
	    dong.showLine();
	}
}
