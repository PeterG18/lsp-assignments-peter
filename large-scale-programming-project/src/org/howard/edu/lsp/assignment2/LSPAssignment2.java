package org.howard.edu.lsp.assignment2;
import java.util.Arrays;
import java.util.Scanner;

public class LSPAssignment2 {

	public static void main(String[] args) 
	{
		int summ = 0;
		int productt = 1;
		while(true) {
		System.out.println("String?");
		Scanner input  = new Scanner(System.in);
		String[] tokens = input.nextLine().split(" ");
		if (tokens[0].equals("Goodbye")) {
			break;
		}
		System.out.println("Tokens: ");
		
		for (int x = 0; x < tokens.length; x++)
			
		{
			System.out.println(tokens[x]);
			productt *=  Integer.parseInt(tokens[x]);
			summ += Integer.parseInt(tokens[x]);
			
		}
		System.out.println("Sum: "+summ);
		System.out.println("Product: "+productt);
	}

}
}
