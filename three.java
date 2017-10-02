import java.util .*;
import java.io.*;
import org.apache.commons.lang3.StringUtils;

public class three
{
	
 	public static void main(String args[])
 	{
 		
 		String[] MSA = new String[]{"A-AB-BAFCD-B-AAEA0ACEDA-EQ---A-ABCDBALF4-BBASB---AAAAFB",
 		 "A-ABNBAFCD-B-AAEAABCEDA-EQ-CDABAB--BA-F4NBBM-BTYBAAAA--",
 		 "A-AB-BAFCDAB-A-EAA-CEDCDEQA--ABFBAN---F4-BBAFBTYBAAAA--",
 		"2AAB-BAFCDAB-A-EAABCEDCDEQFCDABA-APAL-F4-BBA--SBAAAAA--",
 		"CDAB-BAFCDB1-AAEAA-CEDA-EQ-CDABABABAL-F4LBBAFBSBAAAAA--",
 		"CDABAAA----B-A-EA-ACEDCDEQ---A-ABCD-A-F4-BBASB---AAAAFB",
 		"CDAB--A-CDAB-A-EAA-CEDA-EQ-CDABCDCDAA-F4MBB--ATYBAAAA--",
 		"--AA-BA-CDB--AAEAA-CEDCDEQ-CDABPBA-AB-F4-BBAFBSBMAAAA--",
 		"CDAB--RBAFABPAAEA-ACEDCDEQAABCDAFAL---F4NBBASB---AAAAMB",
 		"A-ABAA-----B-AAEA-ACEDCDEQAABAFA------F4BNBASB---AAAAFB"
 		};
 		int statecount=0;
 		int count=0;
 		int state[]= new int[55];
 		int countmatch=0,countinster=0;
 		
 	
 		for(int i=0;i<53;i++)
 		{
 			
 			for(int j=0;j<10;j++)
 			{
 				if(MSA[j].charAt(i)== '-')
 				count += 1;
 			}
 			if(count>5)
 			{
 				System.out.print("\nColumn "+i+" is a insert state");
 				state[i]=1;
 				
 			}
 			else
 			{
 				System.out.print("\nColumn "+i+" is a match state");
 				state[i]=0;
 				
 			}
 			count=0;
 		}
 		
 		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
 		
 		
 			hmap.put('A',0);
 			hmap.put('B',0);
 			hmap.put('C',0);
 			hmap.put('D',0);
 			hmap.put('E',0);
 			hmap.put('F',0);
 			hmap.put('L',0);
 			hmap.put('M',0);
 			hmap.put('N',0);
 			hmap.put('P',0);
 			hmap.put('Q',0);
 			hmap.put('R',0);
 			hmap.put('S',0);
 			hmap.put('T',0);
 			hmap.put('Y',0);
 			hmap.put('0',0);
 			hmap.put('1',0);
 			hmap.put('2',0);
 			hmap.put('4',0);
 			
 		
 		count=0;
 		for(int i=0;i<53;i++)
 		{
 			if(state[i] == 0)
		    	statecount=statecount+1;
 			for(int j=0;j<10;j++)
 			{
 				if(MSA[j].charAt(i) != '-')
 				{
 					hmap.put(MSA[j].charAt(i), hmap.get(MSA[j].charAt(i)) + 1);
 					count++;
 					
 				}
 				
 				
 			}
 			//add one rule
 			hmap.put('A',hmap.get('A') + 1);
			hmap.put('B',hmap.get('B') + 1);
			hmap.put('C',hmap.get('C') + 1);
			hmap.put('D',hmap.get('D') + 1);
			hmap.put('E',hmap.get('E') + 1);
			hmap.put('F',hmap.get('F') + 1);
			hmap.put('L',hmap.get('L') + 1);
			hmap.put('M',hmap.get('M') + 1);
			hmap.put('N',hmap.get('N') + 1);
			hmap.put('P',hmap.get('P') + 1);
			hmap.put('Q',hmap.get('Q') + 1);
			hmap.put('R',hmap.get('R') + 1);
			hmap.put('S',hmap.get('S') + 1);
			hmap.put('T',hmap.get('T') + 1);
			hmap.put('Y',hmap.get('Y') + 1);
			hmap.put('0',hmap.get('0') + 1);
			hmap.put('1',hmap.get('1') + 1);
			hmap.put('2',hmap.get('2') + 1);
			hmap.put('4',hmap.get('4') + 1);
 		
			
 		count=count+19;
			Iterator it = hmap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        
		        if(state[i] == 0)
		        {
		        	System.out.print("\nE M" + statecount+ " ("+ pair.getKey() + ") = " + pair.getValue() + "/" + count);
		        	
		        }
		        else
		        	System.out.print("\nE I" + statecount+ " ("+ pair.getKey() + ") = " + pair.getValue() + "/" + count);
		    }
		    System.out.println("\n----------------");
		    Iterator it1 = hmap.entrySet().iterator();
		    while (it1.hasNext()) {
		        Map.Entry pair = (Map.Entry)it1.next();
		       
		        hmap.put((Character) pair.getKey(),0);
		       
		    }
		    
		    count=0;
 			
 			
 			
 			
 			
 	 	 }
 		
 		
 		
 		
 		//merging last two insert states 
 		
 		
 		count=0;
 		for(int i=53;i<55;i++)
 		{
 			count=0;
 			for(int j=0;j<10;j++)
 			{
 				if(MSA[j].charAt(i) != '-')
 				{
 					hmap.put(MSA[j].charAt(i), hmap.get(MSA[j].charAt(i)) + 1);
 					count++;
 					
 				}
 				
 				
 			}
 			
 		}
 			//add one rule
 			hmap.put('A',hmap.get('A') + 1);
			hmap.put('B',hmap.get('B') + 1);
			hmap.put('C',hmap.get('C') + 1);
			hmap.put('D',hmap.get('D') + 1);
			hmap.put('E',hmap.get('E') + 1);
			hmap.put('F',hmap.get('F') + 1);
			hmap.put('L',hmap.get('L') + 1);
			hmap.put('M',hmap.get('M') + 1);
			hmap.put('N',hmap.get('N') + 1);
			hmap.put('P',hmap.get('P') + 1);
			hmap.put('Q',hmap.get('Q') + 1);
			hmap.put('R',hmap.get('R') + 1);
			hmap.put('S',hmap.get('S') + 1);
			hmap.put('T',hmap.get('T') + 1);
			hmap.put('Y',hmap.get('Y') + 1);
			hmap.put('0',hmap.get('0') + 1);
			hmap.put('1',hmap.get('1') + 1);
			hmap.put('2',hmap.get('2') + 1);
			hmap.put('4',hmap.get('4') + 1);
 		
			
 		count=count+19;
			Iterator it = hmap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        
		       
		        	System.out.print("\nE I" + statecount+ " ("+ pair.getKey() + ") = " + pair.getValue() + "/" + count);
		    }
		    Iterator it1 = hmap.entrySet().iterator();
		    while (it1.hasNext()) {
		        Map.Entry pair = (Map.Entry)it1.next();
		       
		        hmap.put((Character) pair.getKey(),0);
		       
		    }
		    
		    count=0;
 			
 			
 			
 			
 		System.out.println("\n\nFor rest of the insert states the emission probablities would be 1/19");	
 	 	 
 		
 		
 		
 			
 		
 		
 	}
 	
 	

}

