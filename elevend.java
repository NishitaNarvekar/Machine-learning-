import java.util .*;
import java.io.*;

public class elevend
{
	
 	public static void main(String args[]) throws IOException
 	{
 	
 		int N=3,maxchar,T=0,minIters,startingpos,seed;
		  Scanner input=new Scanner(System.in);
		  int M=26;
		  
		  
		
		  System.out.println("Enter the value for N");
		  N=input.nextInt();
		  
		  double A[][] = new double[N][N];
		  double B[][] = new double[N][M];
		  double pi[] = new double[N];
		  double oldlogProb = -999999999;
		  double iters=0;
		  
		  //-------------Initialising pi matrix
		  
		  double initpi=(1.0 / N);
		  

		  
		  System.out.println(initpi);
		  Random randomGenerator = new Random(5);
		  double randompi=0;
		  double sumpi=0;
		
				  for(int i=0;i<N;i=i+2)
				  {
					  randompi=randomGenerator.nextDouble()/100;
					  //System.out.println(random);
					  if(i+1 < N)
					  {
						  //System.out.println(i);
						  pi[i] = initpi + randompi;
						  
						  pi[i] = initpi - randompi;
						  
						  //sumpi=sumpi+pi[i]+pi[i+1];
						  
					  }
					  
				  }
				  System.out.println(sumpi);
				  
				  if(N == 2)
					  sumpi=pi[0];
				  
				  /*if(sumpi<1)
					  pi[N-1]=1-sumpi; 
				  else
					  pi[N-1]=sumpi-1;
				  
				  sumpi=0;*/
				  System.out.printf("\n cell value pi[N-1] %f",pi[N-1]);
					  
		  
		  
		  double rowsumpi=0.0;
		  System.out.println("\n Pi Matrix ");
		  for(int i=0;i<N;i++)
		  {
			 
			   System.out.print(" ");
				  System.out.print(pi[i]);
				  rowsumpi=rowsumpi + pi[i];
				  
			  
			 
			  
		  }
		  System.out.print("\n rowsum: ");
		  System.out.print(rowsumpi);
		 // rowsum=0.0;
		  System.out.print("\n");
		  
		  //---Initialising B matrix---------
		  double init=1.0/M;
		  
		  System.out.println(init);
		 // Random randomGenerator = new Random();
		  double random=0;
		  double sum1=0,sum2=0;
		  for(int i=0;i<N;i++)
		  {
				  for(int j=0;j<M;j=j+2)
				  {
					  random=randomGenerator.nextDouble()/100;
					  //System.out.println(random);
					  if(j+1 < M)
					  {
						 // System.out.println(j);
						  B[i][j] = init + random;
						  
						  B[i][j+1] = init - random;
						  
						//  sum1=sum1+B[i][j]+B[i][j+1];
						  //System.out.println(sum1);
					  }
					  
				  }
				  
				 /* if(sum1<1)
					  B[i][M-1]=1-sum1; 
				  else
					  B[i][M-1]=sum1-1;
				  sum1=0;*/
				  System.out.printf("\n cell value B[i][M-1] %f",B[i][M-1]);
					  
		  }
		  
		  double rowsum=0.0;
		  System.out.println("\n B Matrix ");
		  for(int i=0;i<N;i++)
		  {
			  rowsum=0.0;
			  for(int j=0;j<M;j++)
			  {
				  System.out.print(" ");
				  System.out.print(B[i][j]);
				  rowsum=rowsum + B[i][j];
				  
			  }
			  System.out.print("\n rowsum: ");
			  System.out.print(rowsum);

			  System.out.print("\n");
			  
		  }
		  
		 // System.out.println(sum1);
		  //System.out.println(sum2);
		  
		  
		 // B[1][M-1]=1-sum2;
		  
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
			    
	 	    Random r = new Random(5);
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
	 			System.out.print(rowdisum[i]);
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
		 
		  System.out.println("Enter Minimum Number of re-estimation iteration");
		  minIters=input.nextInt();
		  
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
		 	    		System.out.println("I am in else");
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
		 		
		 		
		 		char[] secret1=textbuff;
		 		char[] code1;
		 		String code = "";
		 		
		 		for(int i=0;i<charcount;i++)
		 		{
		 			code = code + hmap.get(textbuff[i]);
		 		}
		 		//System.out.println(code);
		 		textarr = code.toCharArray();
		 		System.out.println("The encoded string is : ");
		 		//System.out.println(text\arr);
			
		  System.out.println(charcount);
		  
//encrypted key processing	end-----------------------------------------------	  
		  T=1000;
//			System.out.println(count);
			int O[]=new int[T];
			for(int i=0;i<T;i++)
			{
				if(textarr[i] >= 'a' && textarr[i] <= 'z')
					O[i]=(int)textarr[i]-97;
				
				
			}
			double oldLogProb,logProb;
			double alpha[][] = new double [T][N];
			
			
		    double pr,f1,f12;	    
		    
		    
		    System.out.println(T);
		    int iteration = 0;
			logProb = 0;
			oldLogProb = -999999999;
			double c[]= new double[T];
			
			
			
			double threshold = 0.001;
			while(iters < minIters || Math.abs(logProb - oldLogProb) > threshold)
			{
				//compute alpha[0][i]
				//System.out.println(iters);
				oldLogProb=logProb;
				c[0]=0;
				for (int i = 0; i < N; i++) 
				{
					alpha[0][i] = pi[i] * B[i][O[0]];
					c[0] = c[0] + alpha[0][i];
				}
				
				//scale the alpha[0][i]
				c[0] = 1 / c[0];
				for (int i = 0; i < N; i++) 
				{
					alpha[0][i] = c[0] * alpha[0][i]; 
				}
				
				//compute alpha[t][i]

				for (int t = 1; t < T; t++) 
				{
					c[t] = 0;
					for (int i = 0; i < N; i++) 
					{
						alpha[t][i] = 0;
						for (int j = 0; j < N; j++) 
						{
							alpha[t][i] = alpha[t][i] + alpha[t - 1][j] * A[j][i];
						}
						alpha[t][i] = alpha[t][i]*B[i][O[t]];
						c[t] = c[t]+alpha[t][i];
					}
					
					//scale alpha[t][i]

					c[t] = 1/ c[t];
					for (int i = 0; i < N; i++) 
					{
						alpha[t][i] = c[t] *alpha[t][i] ;
					}
				}

				// Backward algorithm or beta-pass
				
				//Let beta[T-1][i] = 1 scaled by C[T-1]
				double beta[][] = new double[T][N];
				
				for (int i = 0; i < N; i++) 
				{
					beta[T - 1][i] = c[T - 1];
				}

				for (int t = T - 2; t >= 0; t--) 
				{
					for (int i = 0; i < N; i++) 
					{
						beta[t][i] = 0;
						for (int j = 0; j < N; j++) 
						{
							beta[t][i] =beta[t][i]+A[i][j]*B[j][O[t+1]]*beta[t+1][j];
						}
						beta[t][i] = c[t] * beta[t][i]; 
					}
				}
				//compute the gammas and di-gammas
				double gammas[][]=new double[T][N];
				double digammas[][][] = new double[T][N][N];
				double denom=0;
				
				for (int t = 0; t < T - 1; t++) 
				{
					denom = 0;
					for (int i = 0; i < N; i++) 
					{
						for (int j = 0; j < N; j++) 
						{
							denom = denom + alpha[t][i] * A[i][j] * B[j][O[t + 1]] * beta[t + 1][j];
						}
					}

					for (int i = 0; i < N; i++) 
					{
						gammas[t][i] = 0;
						for (int j = 0; j < N; j++) 
						{
							digammas[t][i][j] = (alpha[t][i] * A[i][j] * B[j][O[t + 1]] * beta[t + 1][j]) / denom;
							gammas[t][i] = gammas[t][i] + digammas[t][i][j];
						}
					}
				}

				//Special case for gammas[T-1][i]
				denom = 0;
				for (int i = 0; i < N; i++) 
				{
					denom = denom + alpha[T - 1][i];
				}
				for (int i = 0; i < N; i++) 
				{
					gammas[T - 1][i] = alpha[T - 1][i] / denom;
				}
				
				//Re-estimate the model lamda = (A,B,pi)
				
				
				//re-estimate pi
				for (int i = 0; i < N; i++) 
				{
					pi[i] = gammas[0][i]; 
				}

				//re-estimate A
				
				double numer = 0;
				/*
				for (int i = 0; i < N; i++) 
				{
					for (int j = 0; j < N; j++) 
					{
						numer = 0;
						denom = 0;
						for (int t = 0; t < T - 1; t++) 
						{
							numer = numer + digammas[t][i][j];
							denom = denom + gammas[t][i];
						}
						
						A[i][j] = numer / denom;
					}
				}*/

				//re-estimate B
				
				for (int i = 0; i < N; i++) 
				{
					for (int j = 0; j < M; j++) 
					{
						numer = 0;
						denom = 0;
						for (int t = 0; t < T; t++) 
						{
							if (O[t] == j)
							{
								numer = numer + gammas[t][i];
							}
								
							denom = denom + gammas[t][i];
						}
						B[i][j] = numer / denom;
					}
				}

				//Compute log(P(O|Lamda))
				
				logProb = 0;
				for (int i = 0; i < T; i++) 
				{
					logProb = logProb + Math.log(c[i]);
				}
				logProb = -logProb;
				//System.out.println(logProb);
				
				
				//Calculating if required to iterate 
				
				//if(iteration%100==0)
				//System.out.println("PASS "+iteration+ "= "+ logProb);
				iters=iters+1;
			}
			System.out.println("\n");
			
			double ans=0.0,ans1=0.0;
			System.out.println("\n\nB Matrix");
			int alphabets=97;
			int k=0;
			float [][] Bans= new float[26][26];
			for(int i=0;i<M;i++)
			{
				System.out.print((char)alphabets);
				System.out.print("\t");
				alphabets++;
				for(int j=0;j<N;j++)
				{
					Bans[i][j]=(float)B[j][i];
						System.out.printf("%f",B[j][i]);
						System.out.print("\t");
						
						
				}
				
				
				System.out.println(" ");
			}
			double maxval=0.0,maxindex=0.0;
			double key[]= new double[30];
			int kl=0;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					
							if(Bans[j][i] > maxval)
							{
								
								maxindex=j;
								
								maxval=Bans[j][i];
							}

							System.out.println("");
							
							
							
					}
				key[kl]=maxindex;
				kl++;
				maxindex=0;
				maxval=0;
			}
			
				
				
				
				
				System.out.println(" ");
			
				
			for(int i=0;i<26;i++)
			{
				//System.out.print((char)(97+key[i]));
				System.out.print(" ");
			}
			
			for(int i=0;i<26;i++)
			{
				char temp1=(char) (97+i);
				//System.out.print(hmap.get(temp1));
				System.out.print(" ");
				
				if(hmap.get(temp1) == ((char)97+key[i]))
				{
					ans= ans+1;
				}
			}
			System.out.println("Putative value is : ");
			System.out.print(ans/26*100);
			
			
			
			/*System.out.print("z  ");
			for(int j=0;j<N;j++)
			{
				System.out.printf("%f",B[j][M-1],"\t\t");
			}*/
			
			
			input.close();

 	}
 	
 	

}

