import java.util .*;
import java.io.*;

public class fourteena
{
	
 	public static void main(String args[]) throws IOException
 	{

 		int N=3,maxchar,T=0,minIters,startingpos,seed;
		  Scanner input=new Scanner(System.in);
		  int M=26;
		  
		  
		
		  System.out.println("Enter the value for N");
		  N=input.nextInt();
		  
		  double A[][] = new double[N][N];
		  
		  
		  
		  
		  
		  
		  //-----Initializing A Matrix------------------------------------------
		  BufferedReader brA = null;
		  //int digraph[][] = new int[26][26];
		  HashMap<Character, Integer> hmapA = new HashMap<Character, Integer>();
		  int charcountA=0,maxcharA=1000000;
		  char textarrA[]=new char[maxcharA+100];
			char textbuffA[]=new char[maxcharA+100];
		  try
			{
				
			     brA = new BufferedReader(new FileReader("/Users/Nishita/Documents/Stamp/BrownCorpus.txt"));
			    
			
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
			    char temp[]= new char[maxcharA+100];   
			    
			    
			    T=0;
			    String line="";
			    StringBuilder sb = new StringBuilder();
			   // String line = br.readLine();
			   // System.out.println(line);
			    int count=0;
			    
			    while((line=brA.readLine())!=null)
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
			    					textbuffA[charcountA]=temp[i];
			    					charcountA++;
			    			}
			    			
			    			if(charcountA>maxcharA)
								break;
			    			
			    	}
			    	if(charcountA>maxcharA)
						break;
			    	System.out.println("\n");
			    }
			    System.out.println(textbuffA);
			    System.out.println(charcountA);
			    
	 	    Random r = new Random();
	 	    int letter=97;
	 	    for (int i = 0; i < 26; i++) 
	 	    {
	 	    	
	 	    	if(letter<=122)
	 	    	{
		 	    	hmapA.put((char)letter,i);
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
	 			System.out.print(hmapA.get((char)i));
	 			System.out.print("\n");
	 		}
	 		
	 		//System.out.println(hmapA.get('m'));
	 		
	 		//char[] strarr=textbuffA;
	 		
	 		for(int i=0;i<charcountA-1;i++)
	 		{
	 			
	 					A[hmapA.get(textbuffA[i])][hmapA.get(textbuffA[i+1])] += 1;
	 		}
	 		/*for(int i=0;i<26;i++)
	 		{
	 			for(int j=0;j<26;j++)
	 			{
	 				
	 				System.out.print(A[i][j]);
	 				System.out.print( " " );
	 			}
	 			System.out.print( "\n" );
	 		}*/
	 		double disum=0;
	 		double rowdisum[] = new double[26];
	 		
	 		//normalising matrix 
	 		
	 		for(int i=0;i<26;i++)
	 		{
	 			for(int j=0;j<26;j++)
	 			{
	 				
	 				A[i][j] += 5;
	 				rowdisum[i] = rowdisum[i]+A[i][j];
	 				
	 			}
	 			//System.out.print(rowdisum[i]);
	 			System.out.print(" ");
	 			
	 			
	 			
	 			
	 			//System.out.print( "\n" );
	 		}
	 		
	 		for(int i=0;i<26;i++)
	 		{
	 			for(int j=0;j<26;j++)
	 			{
	 				
	 				A[i][j]=A[i][j]/rowdisum[i];
	 				
	 			}
	 			//System.out.print( "\n" );
	 		}
	 		
	 		System.out.println("\n");
	 		System.out.println("A digraph matrix: ");
	 		
	 		
	 		for(int i=0;i<26;i++)
	 		{
	 			for(int j=0;j<26;j++)
	 			{
	 				
	 				System.out.print(A[i][j]);
	 				System.out.print( " " );
	 			}
	 			System.out.print( "\n" );
	 		}
		  
		//-----Initializing A Matrix end--------------------------------------
		 //step 2c. Initialization
		 
		
		  
		  System.out.println("Enter Maximum Number of characters");
		  maxchar=input.nextInt();

		   int charcount=0;
			char textarr[]=new char[maxchar+100];
			char textbuff[]=new char[maxchar+100];
			

			  
			   System.out.println("Enter Starting position");
			   startingpos=input.nextInt();
			   BufferedReader br = null;
//encrypted key processing			   
			try
			{
				
			     br = new BufferedReader(new FileReader("/Users/Nishita/Documents/Stamp/BrownCorpus.txt"));
			    
			
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
			temp=null;
			    
			    
			    T=0;
			     line="";
			     sb=null;
			   // StringBuilder sb = new StringBuilder();
			   // String line = br.readLine();
			   // System.out.println(line);
			    count=0;
			    
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
			    	textbuff[charcount]=' ';
			    	charcount++;
			    }
			    
			   
			    
			
			
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
		 	   int alen = alphabet.length();
		 	    
		 	   HashMap<Character, Character> hmap = new HashMap<Character, Character>();

		 	    //Random r = new Random();
		 	   int shift=1;
		 	    for (int i = 97; i <= 122; i++) 
		 	    {
		 	    	
		 	    	System.out.print(" ");
		 	        System.out.print(i);
		 	    	if(i+shift<=122)
		 	    	{
			 	    	hmap.put((char)i,(char)(i+shift));
			 	    	System.out.print(" ");
			 	        System.out.print((char)(i+shift));
			 	        
		 	    	}
		 	    	else
		 	    	{
		 	    		//System.out.println("I am in else");
		 	    		hmap.put((char)i,(char)(i+shift-26));
		 	    		System.out.print((char)(i+shift-26));
		 	    	}
		 	    }
		 	   System.out.print(" \n Encryption key is as follows: ");
		 		for(int i=97;i<=122;i++)
		 		{
		 			System.out.print(" ");
		 			System.out.print("key: ");
		 	        System.out.print((char)i);
		 			System.out.print(" value: ");
		 			System.out.print(hmap.get((char)i));
		 			System.out.print("\n");
		 		}
		 		
		 		System.out.println("\n\nOriginal text is as follows");
		 		System.out.println(textbuff);
		 		
		 		char[] secret1=textbuff;
		 		char[] code1;
		 		String code = "";
		 		
		 		for(int i=0;i<charcount;i++)
		 		{
		 			code = code + hmap.get(textbuff[i]);
		 		}
		 		//System.out.println(code);
		 		textarr = code.toCharArray();
		 		System.out.println("\n\nThe encoded string is : ");
		 		System.out.println(textarr);
			
		  System.out.println(charcount);
		  
//encrypted key processing	end-----------------------------------------------	  

 	}
 	
 	

}

