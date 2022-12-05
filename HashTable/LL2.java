package HashTable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class LL2{
	public static final int MAX_LETTER = 20;
	
	
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
	
	
	public void insert(String word, int l) 

    {    
        //Creating a new node   

        Node1 newNode = new Node1(word);  
        
        //Check if the word has appeared in the existing List
        
        Node1 current = head;
        
        
        while (current != null) {
			if(current.word.toLowerCase().equals(word.toLowerCase())){
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
	
	public void sort(Node1 node) {
		node  = head;
		
		Node1 index = null;
		String temp = null;
		int tmp = 0;
		LL3 tm = null;
		
		
		if(head == null) {
			return;
		}
		else {
			while(node != null) {
				index = node.next;
				while(index != null) {
					if(node.word.toLowerCase().compareTo(index.word.toLowerCase()) > 0) {
						temp = node.word;
						node.word = index.word;
						index.word = temp;
						tmp = node.count;
						node.count = index.count;
						index.count = tmp;
						tm = node.ln;
						node.ln = index.ln;
						index.ln = tm;
					}
					index = index.next;
				}
				node = node.next;
			}
		}
	}
	
	public void displaylist() 

    {    

        //Pointing the head to the node called current    
        Node1 current = head;  
        
        //sort(current);

        if(head == null)

        {     
            return;    
        }       

        while(current != null) 

        {    

            //printing each data in the list and next pointer pointing to the next node   
        	
            System.out.print(current.word + " "); 
            System.out.print(" " + current.count + " ");
            current.ln.showLine();
            current = current.next;    
            System.out.println();
        }        

    }
}
