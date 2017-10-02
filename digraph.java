import java.util .*;
import java.io.*;

public class digraph
{
	
 	public static void main(String args[]) throws IOException
 	{
 		Scanner input=new Scanner(System.in);
 		double digraph[][] = new double[26][26];
 		 int charcount=0,maxchar;
 		System.out.println("Enter Maximum Number of characters");
		
		maxchar=input.nextInt();
			char textarr[]=new char[maxchar+100];
			char textbuff[]=new char[maxchar+100];
			int startingpos=0;
			 
			
			  
			  
			   System.out.println("Enter Starting position");
			   startingpos=input.nextInt();
			   BufferedReader br = null;
 		
 		String str="abcabc";
 		
 		String alphabet = "abcdefghijklmnopqrstuvwxyz";
	 	   int alen = alphabet.length();
	 	   int T;
	 	    
	 	   HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();

	 	  try
			{
				
			     br = new BufferedReader(new FileReader("/Users/Nishita/Documents/Stamp/BrownCorpus.txt"));
			    
			
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
			    char temp[]= new char[maxchar+100];   
			    
			    
			    T=0;
			    String line="";
			    StringBuilder sb = new StringBuilder();
			   // String line = br.readLine();
			   // System.out.println(line);
			    int count=0;
			    
			    while((line=br.readLine())!=null)
			    {
			    	
			    	line=line.toLowerCase();
			    	// System.out.println(line);
			    	
			    	temp=line.toCharArray();
			    	count++;
			    	int length1=temp.length;
			    	//int pos=16;
			    	/*while(temp[pos]==' ')
			    	{
			    		pos++;
			    	}*/
			    	for(int i=0;i<length1;i++)
			    	{

			    			if((temp[i]<='z' && temp[i]>='a'))
			    			{
			    					textbuff[charcount]=temp[i];
			    					charcount++;
			    			}
			    			
			    			if(charcount>maxchar)
								break;
			    			
			    	}
			    	if(charcount>maxchar)
						break;
			    	System.out.println("\n");
			    }
			    System.out.println(textbuff);
			    System.out.println(charcount);
			    
	 	    Random r = new Random();
	 	    int letter=97;
	 	    for (int i = 0; i < 26; i++) 
	 	    {
	 	    	
	 	    	if(letter<=122)
	 	    	{
		 	    	hmap.put((char)letter,i);
		 	    	System.out.print(" ");
		 	        System.out.print(i);
		 	        letter++;
	 	    	}
	 	    }
	 	   System.out.print(" \n");
	 		for(int i=97;i<=122;i++)
	 		{
	 			System.out.print(" ");
	 			System.out.print("key: ");
	 	        System.out.print((char)i);
	 			System.out.print(" value: ");
	 			System.out.print(hmap.get((char)i));
	 			System.out.print("\n");
	 		}
	 		
	 		System.out.println(hmap.get('m'));
	 		
	 		char[] strarr=textbuff;
	 		
	 		for(int i=0;i<charcount-1;i++)
	 		{
	 			
	 					digraph[hmap.get(strarr[i])][hmap.get(strarr[i+1])] += 1;
	 		}
	 		double disum=0;
	 		double rowdisum[] = new double[26];
	 		
	 		//normalising matrix 
	 		
	 		for(int i=0;i<26;i++)
	 		{
	 			for(int j=0;j<26;j++)
	 			{
	 				
	 				digraph[i][j] += 5;
	 				disum = disum+digraph[i][j];
	 				
	 			}
	 			rowdisum[i]=disum;
	 			
	 			
	 			
	 			System.out.print( "\n" );
	 		}
	 		
	 		for(int i=0;i<26;i++)
	 		{
	 			for(int j=0;j<26;j++)
	 			{
	 				
	 				digraph[i][j]=digraph[i][j]/rowdisum[i];
	 				
	 			}
	 			System.out.print( "\n" );
	 		}
	 		
	 		for(int i=0;i<26;i++)
	 		{
	 			for(int j=0;j<26;j++)
	 			{
	 				
	 				System.out.print(digraph[i][j]);
	 				System.out.print( " " );
	 			}
	 			System.out.print( "\n" );
	 		}
 		
 		
 	}
 	
 	

}

