import java.util .*;
import java.io.*;

public class thirteen
{
	
 	public static void main(String args[])
 	{
 		
 		double X[][] = new double[][] {{3.6,79},
 	    	{1.8,54},
 	    	{2.283,62},
 	    	{3.333,74},
 	    	{2.883,55},
 	    	{4.533,85},
 	    	{1.95,51},
 	    	{1.833,54},
 	    	{4.7,88},
 	    	{3.6,85},
 	    	{1.6,52},
 	    	{4.35,85},
 	    	{3.917,84},
 	    	{4.2,78},
 	    	{1.75,62},
 	    	{1.8,51},
 	    	{4.7,83},
 	    	{2.167,52},
 	    	{4.8,84},
 	    	{1.75,47}
 	    };
 		
 	    double mu1[][]={{3},{65}};
 	    
 	    double S1[][]={{1.5,7},{7,150}};
 	    
 	   double mu2[][]={{4},{75}};
	    
	   double S2[][]={{2,12},{12,250}};
	   
	   double tao[]={0.4,0.6};
	   
	   double p[][]=new double[20][20];
	   int cnt=0;
	   
	   while(cnt<100)
	   {
	
	    for(int i=0;i<20;i++)
	    {
	    	for(int j=0;j<2;j++)
	    	{
	    		
	    		if(j == 0)
	    		{
	    			 
	    			p[j][i]=tao[j]*f(X[i],mu1,S1)/(tao[0]*f(X[i],mu1,S1) + tao[1]*f(X[i],mu2,S2));
	    		    System.out.print( "\nP(" + (j) + "," + (i) + ") = " + p[j][i]); 
	    		}
	    		else if(j ==1)
	    		{
	    			
	    			p[j][i]=tao[j]*f(X[i],mu2,S2)/(tao[0]*f(X[i],mu1,S1) + tao[1]*f(X[i],mu2,S2));
	    			 System.out.print( "\nP(" + (j) + "," + (i) + ") = " + p[j][i]); 
	    		}
		    	
	    	
	    	}
	    
	    	
	    
	  }
	    
	    //M step
	    double taosum=0;
	    
	    for(int j=0;j<2;j++)
	    {
	    	for(int i=0;i<20;i++)
	    	{
	    		taosum += p[j][i];
	    	}
	    	tao[j]=taosum/20;
	    	//System.out.println(taosum);
	    	taosum=0;
	    }
	    taosum=0;
	    
	    System.out.print("\n tao[1] =" + tao[0] + " tao[2] =" + tao[1]);
	    
	    double musum=0,musum1=0,musumd=0;
	    
	    for(int j=0;j<2;j++)
	    {
	    	for(int i=0;i<20;i++)
	    	{
	    		musum +=(p[j][i] *X[i][0]);
	    		musumd +=(p[j][i] * X[i][1]);
	    		musum1 +=p[j][i];
	    	}
	    	if(j == 0)
	    	{
	    		mu1[0][0]=musum/musum1;
	    		mu1[1][0]=musumd/musum1;
	    		//System.out.println(mu1[j][0]);
	    	}
	    	else if (j == 1)
	    	{
	    		mu2[0][0]=musum/musum1;
	    		mu2[1][0]=musumd/musum1;
	    	}
	    	//System.out.println(taosum);
	    	musum1=0;
	    	musum=0;
	    	musumd=0;
	    }
	    
	    
	    System.out.print("\n mu1[0] =" + mu1[0][0] + " mu1[1] =" + mu1[1][0]);
	    
	    System.out.print("\n mu2[0] =" + mu2[0][0] + " mu2[1] =" + mu2[1][0]);
 		
	    double ssum=0,ssumd=0;
	    double x[][]=new double[2][1];
	    
	    for(int j=0;j<2;j++)
	    {
	    	double temps [][] = new double[2][2];
	    	for(int i=0;i<20;i++)
	    	{
	    		x[0][0]=X[i][0];
	     		x[1][0]=X[i][1];

	     		double temp [][] = new double[2][1];
	     		double tempT [] = new double[2];
	     		double tempmul[][]=new double[2][2];
	     		
	     		if(j==0)
	     		{
	     		
		     		temp[0][0]=x[0][0]-mu1[0][0];
		     		temp[1][0]=x[1][0]-mu1[1][0];
		     		
		     		tempT[0]=temp[0][0];
		     		tempT[1]=temp[1][0];
		     		
	     		
	     		}
	     		else if(j==1)
	     		{
	     			temp[0][0]=x[0][0]-mu2[0][0];
		     		temp[1][0]=x[1][0]-mu2[1][0];
		     		
		     		tempT[0]=temp[0][0];
		     		tempT[1]=temp[1][0];
	     		}
	     		
	     		tempmul[0][0]=temp[0][0]*tempT[0];
	     		tempmul[0][1]=temp[0][0]*tempT[1];
	     		
	     		tempmul[1][0]=temp[1][0]*tempT[0];
	     		tempmul[1][1]=temp[1][0]*tempT[1];
	     		
	     		double muls [][] = new double[2][2];
	     		
	     		
	     		for(int k=0;k<2;k++)
	     		{
	     			for(int l=0;l<2;l++)
	     			{
	     				muls[k][l]=p[j][i]*tempmul[k][l];
	     			}
	     		}
	     		
	     		for(int k=0;k<2;k++)
	     		{
	     			for(int l=0;l<2;l++)
	     			{
	     				temps[k][l]=temps[k][l]+muls[k][l];
	     			}
	     		}
	     		
	     		ssumd +=p[j][i];
	     		
	     		
	
	    	}
	    	if(j ==0)
	    	{
	    		for(int k=0;k<2;k++)
	     		{
	     			for(int l=0;l<2;l++)
	     			{
	     				S1[k][l]=temps[k][l]/ssumd;
	     			}
	     		}
	    	}
	    	
	    	if(j ==1)
	    	{
	    		for(int k=0;k<2;k++)
	     		{
	     			for(int l=0;l<2;l++)
	     			{
	     				S2[k][l]=temps[k][l]/ssumd;
	     			}
	     		}
	    	}
	    	ssumd=0;
	    }
	    
	    System.out.print("\n S1 = ");
	    for(int k=0;k<2;k++)
 		{
	    	System.out.print("\n");
 			for(int l=0;l<2;l++)
 			{
 				System.out.print(S1[k][l] + ",");
 			}
 		}
	    
	    System.out.print("\n S2 = ");
	    for(int k=0;k<2;k++)
 		{
	    	System.out.print("\n");
 			for(int l=0;l<2;l++)
 			{
 				System.out.print(S2[k][l] + ",");
 			}
 		}
	    cnt++;
	   }
	    
 	}
 
 	public static double f(double x[], double[][] mu, double[][] s) {
 	   
 		double X[][]=new double[2][1];
 		X[0][0]=x[0];
 		X[1][0]=x[1];
 		double inv[][]=new double[s.length][s[0].length];
 		double divf=0;
 		
 		double temp [][] = new double[2][1];
 		double tempT [] = new double[2];
 		
 		temp[0][0]=X[0][0]-mu[0][0];
 		temp[1][0]=X[1][0]-mu[1][0];
 		for(int i=0;i<2;i++)
 		{

 			//System.out.println(temp[i][0]);
 			
 		}
 		tempT[0]=temp[0][0];
 		tempT[1]=temp[1][0];
 		
 		//System.out.println(tempT[0]);
 		
 		divf=s[0][0]*s[1][1]-s[0][1]*s[1][0];
 		
 		double tempinv[][] = new double[2][2];
 		
 		
 	
 		tempinv[0][0] = s[1][1];
 		tempinv[1][1] = s[0][0];

 		tempinv[0][1] = - s[0][1];
 		tempinv[1][0] = - s[1][0];
 		
 		
 		for(int i=0;i<s.length;i++)
 		{
 			for(int j=0;j<s[0].length;j++)
 			{
 				inv[i][j]=(1/divf)*(s[i][j]);
 				//System.out.println(inv[i][j]);
 			}
 		}
 		
 		double tempmul[] = new double[tempT.length];
 		
 		/*for (int i = 0; i < tempT.length; i++) { // aRow
            for (int j = 0; j < inv[0].length; j++) { // bColumn
                for (int k = 0; k < tempT.length; k++) { // aColumn
                	tempmul[i] += tempT[k] * inv[k][j];
                	
                }
            }
        }*/
 		tempmul[0]=tempT[0] *inv[0][0]+tempmul[1] * inv[1][0];
 		tempmul[1]=tempT[0] *inv[0][1]+tempmul[1] * inv[1][1];
 		
 		
 		double powfinal=0;
 		
 		/*for (int i = 0; i < 1; i++) { // aRow
            for (int j = 0; j < 1; j++) { // bColumn
                for (int k = 0; k < 2; k++) { // aColumn
                	powfinal= tempmul[i][k] * temp[k][j];
                }
            }
        }*/
 		powfinal=tempmul[0] * temp[0][0] + tempmul[1] * temp[1][0];
 		
 		/*for(int i=0;i<powfinal.length;i++)
 		{
 			for(int j=0;j<powfinal[0].length;j++)
 			{
 				System.out.print("\n powfinal = " + powfinal[i][j]);
 			}
 		}*/
 		//System.out.print("\n powfinal = "+ powfinal);
 		double pow=0;
 		pow=(-0.5)*powfinal;
 		
 		double e= Math.exp(pow);
 		//System.out.print("\n e = "+ e);
 		double dets=s[0][0]*s[1][1]-s[0][1]*s[1][0];
 		
 		
 		
 		double res=0;
 		
 		res=(1/(2*(22/7) * Math.sqrt(dets)))*e;
 		
 		return res;
 	}
 	

}

