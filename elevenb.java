import java.util .*;
import java.io.*;

public class elevenb
{
	
 	public static void main(String args[]) throws IOException
 	{
 		

 		int N=2,maxchar,T=0,minIters,startingpos,seed;
		  Scanner input=new Scanner(System.in);
		  int M=26;
		  
		
		  System.out.println("Enter the value for N");
		  N=input.nextInt();
		  
		  double A[][] = new double[N][N];
		  double B[][] = new double[N][M];
		  double pi[] = new double[]{0.00000,1.00000};
		  double oldlogProb = -999999999;
		  double iters=0;
		  
		  //---Initialising B matrix---------
		  double init=1.0/M;
		  
		  System.out.println(init);
		  Random randomGenerator = new Random();
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
						  System.out.println(j);
						  B[i][j] = init + random;
						  
						  B[i][j+1] = init - random;
						  
						  sum1=sum1+B[i][j]+B[i][j+1];
						  System.out.println(sum1);
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
		  
		 
		  
		  double initA=(1.0 / N);
		  

		  
		  System.out.println(initA);
		  
		  double randomA=0;
		  double sumA=0;
		  for(int i=0;i<N;i++)
		  {
				  for(int j=0;j<N;j=j+2)
				  {
					  randomA=randomGenerator.nextDouble()/100;
					  //System.out.println(random);
					  if(j+1 < N)
					  {
						  System.out.println(j);
						  A[i][j] = initA + randomA;
						  
						  A[i][j+1] = initA - randomA;
						  
						  sumA=sumA+A[i][j]+A[i][j+1];
						  System.out.println(sumA);
					  }
					  
				  }
				  
				  if(N == 2)
					  sumA=A[i][0];
				  
				  if(sumA<1)
					  A[i][N-1]=1-sumA; 
				  else
					  A[i][N-1]=sumA-1;
				  
				  sumA=0;
				  System.out.printf("\n cell value A[i][N-1] %f",A[i][N-1]);
					  
		  }
		  
		  double rowsumA=0.0;
		  System.out.println("\n A Matrix ");
		  for(int i=0;i<N;i++)
		  {
			  rowsumA=0.0;
			  for(int j=0;j<N;j++)
			  {
				  System.out.print(" ");
				  System.out.print(A[i][j]);
				  rowsumA=rowsumA + A[i][j];
				  
			  }
			  System.out.print("\n rowsum: ");
			  System.out.print(rowsumA);
			 // rowsum=0.0;
			  System.out.print("\n");
			  
		  }
		 //step 2c. Initialization
		 
		  System.out.println("Enter Minimum Number of re-estimation iteration");
		  minIters=input.nextInt();
		  

		   int charcount=0;
			char textarr[]=new char[50000];
			char textbuff[]=new char[50000];
			
			  System.out.println("Enter Maximum Number of characters");
			  maxchar=input.nextInt();
			  
			   System.out.println("Enter Starting position");
			   startingpos=input.nextInt();
			   BufferedReader br = null;
			   
			try
			{
				
			     br = new BufferedReader(new FileReader("/Users/Nishita/Documents/Stamp/Ass2/potter.txt"));
			    
			
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

			    			if((temp[i]<='z' && temp[i]>='a') || temp[i]==' ')
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

		 	    Random r = new Random();
		 	    int letter=97;
		 	    for (int i = 0; i < 26; i++) 
		 	    {
		 	    	
		 	    	if(letter<=122)
		 	    	{
			 	    	hmap.put((char)letter,alphabet.charAt(r.nextInt(alen)));
			 	    	System.out.print(" ");
			 	        System.out.print(alphabet.charAt(r.nextInt(alen)));
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
		 		//System.out.println(textarr);
			
		  System.out.println(charcount);
	  
		  T=charcount;

			int O[]=new int[T];
			for(int i=0;i<charcount;i++)
			{
				if(textarr[i] >= 'a' && textarr[i] <= 'z')
					O[i]=(int)textarr[i]-97;
				else if(textarr[i] == ' ')
					O[i]=26;
				
			}
			double oldLogProb,logProb;
			double alpha[][] = new double [T][N];
	
		    double pr,f1,f12;	    
	    
		    System.out.println(T);
		    int iteration = 0;
			logProb = 0;
			oldLogProb = -999999999;
			double c[]= new double[T];
	
			double threshold = 0.1;
			while(iters < minIters || Math.abs(logProb - oldLogProb) > threshold)
			{
				//compute alpha[0][i]
				//System.out.println(logProb - oldLogProb);
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
				}

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
				
				//Calculating if required to iterate 
				
				//if(iteration%100==0)
				//System.out.println("PASS "+iteration+ "= "+ logProb);
				iters=iters+1;
			}
			System.out.println("\n");
			System.out.printf("A Matrix Row Stochastic: %f",A[0][0]+A[0][1]);
			
			System.out.println("\n\nB Matrix");
			int alphabets=97;
			for(int i=0;i<M-1;i++)
			{
				System.out.print((char)alphabets);
				System.out.print(" ");
				alphabets++;
				for(int j=0;j<N;j++)
				{
					System.out.print(B[j][i]+"       ");
				}
				System.out.println(" ");
			}
			System.out.print("z  ");
			for(int j=0;j<N;j++)
			{
				System.out.print(B[j][M-1]+"       ");
			}		
			input.close();

 	}
}
