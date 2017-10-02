import java.util .*;
import java.io.*;

public class four
{
	
 	public static void main(String args[])
 	{
 		
 		//int X[] = new int[]{0,3,1};
 		//int X[] = new int[]{1,0,0,2,1};
 		//int X[] = new int[]{2,1,3,0,0};
 		int X[] = new int[]{3,3,1,0,2,2,1};

 		//int Y[] = new int[]{0,3,1};
 		//int Y[] = new int[]{1,0,0,2,1};
 		int Y[] = new int[]{2,1,3,0,0};
 		//int Y[] = new int[]{3,3,1,0,2,2,1};
 		


 		int n = X.length;
 		int m = Y.length;
 		int[][] F = new int[n+1][m+1];
 		int[][] G = new int[n+1][m+1];
 		int sum=0;
 		int s[][]= new int[][]{{9,-4,2,2},
 								{-4,9,-5,-5},
 								{2,-5,10,7},
 								{2,-5,7,10}};
 	
 		//initializations
 		for(int i=0;i<n+1;i++)
 		{
 			for(int j=0;j<m+1;j++)
 			{
 				G[i][0]=0;
 				F[i][0]=0;
 				G[0][j]=j;
 				
 				F[0][j]=(-3*j);
 				
 				
 			}
 			F[i][0]=(-3*i);
 		}
 		System.out.println("G:");
 		for(int i=0;i<n+1;i++)
 		{
 			for(int j=0;j<m+1;j++)
 			{
 				System.out.print(" "+G[i][j]+",");
 				
 			}
 			System.out.print("\n");
 			
 			
 		}
 		System.out.println("F:");
 		for(int i=0;i<n+1;i++)
 		{
 			for(int j=0;j<m+1;j++)
 			{
 				System.out.print(" "+F[i][j]+",");
 				
 			}
 			System.out.print("\n");
 			
 			
 		}
 		//Initializations end
 		int a=0,b=0,c=0;
 		for(int i=1;i<n;i++)
 		{
 			for(int j=1;j<m;j++)
 			{
 				a=F[i-1][j-1] + s[X[i]][Y[j]];
 				b= F[i-1][j] + (-3 *(G[i-1][j] + 1));
 				c=F[i][j-1] + (-3 *(G[i][j-1] + 1));
 				
 				//System.out.println(a);
 				//System.out.println(b);
 				//System.out.println(c);
 				
 				if(a>b && a>c)
		 		{
 					//System.out.println("A max");
		 				F[i][j]=a;
		 				G[i][j]=0;
		 			
		 		}
 				else if(b>a && b>c)
 				{
 					//System.out.println("B max");
 					F[i][j]=b;	
 					G[i][j]=G[i-1][j]+1;
 					
 				}
 				else if(c>a && c>b)
 				{
 					//System.out.println("C max");
 					F[i][j]=c;
 					G[i][j]=G[i][j-1]+1;
 				}
 				
 			}
 		}
 		
 		System.out.println("F:");
 		for(int i=0;i<n+1;i++)
 		{
 			for(int j=0;j<m+1;j++)
 			{
 				System.out.print(" "+F[i][j]+",");
 				
 			}
 			System.out.print("\n");
 			
 			
 		}
 		
 		
 		
 		
 		
 	}
 	
 	
 	

}

