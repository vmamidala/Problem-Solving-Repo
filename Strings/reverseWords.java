// reverse a words in string

import java.util.Scanner;
public class ReverseWords { 

public static void main(String[] args) { 
    Scanner str = new Scanner(System.in);
    String s = str.nextLine();
    
	String arr[] = s.split(" ");
	String res = "";
	for(int i=arr.length-1; i>=0; i--)
	{
	    res = res+arr[i]+" ";
	    
	}
	
	System.out.println(res);
	
} 
} 
