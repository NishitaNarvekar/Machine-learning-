
import java.util.ArrayList;

public class myfive
{
    private static final int K = 2;    // Total clusters.
    private static final int n = 20;      // Total data points.
    
    private static final double X[][] = new double[][] {{3.6,79},
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
    
   private static ArrayList<Data> dataSet = new ArrayList<Data>();
   
    private static ArrayList<Centroid> centroids = new ArrayList<Centroid>();
    
    private static void initialize()
    {
       
        centroids.add(new Centroid(3.333,74)); 
        centroids.add(new Centroid(1.8,51)); 

        for(int i=0;i<10;i++)
        {
        	Data newData = new Data(X[i][0], X[i][1]);
            dataSet.add(newData);
            newData.cluster(1);
        }
        
        for(int i=10;i<20;i++)
        {
        	Data newData = new Data(X[i][0], X[i][1]);
            dataSet.add(newData);
            newData.cluster(2);
        }
        
       /* for(int i=0;i<20;i++)
        {
        	
           System.out.println(dataSet.get(i).X());
            
        }
        */
              
        return;
    }
    
    private static void kMeanCluster()
    {
        final double bigNumber = Math.pow(10, 10);    // some big number that's sure to be larger than our data range.
        double minimum = bigNumber;                   // The minimum value to beat. 
        double distance = 0.0;                        // The current minimum value.
        int sampleNumber = 0;
        int cluster = 0;
        boolean isStillMoving = true;
        Data newData = null;
        int cnt=0;
        
        while(cnt<100)
        {
        	for(int j=0;j<K;j++)
        	{
        		
                    int totalX = 0;
                    int totalY = 0;
                    int totalInCluster = 0;
                    for(int i = 0; i < dataSet.size(); i++)
                    {
                        if(dataSet.get(i).cluster() == j){
                            totalX += dataSet.get(i).X();
                            totalY += dataSet.get(i).Y();
                            totalInCluster++;
                        }
                    }
                    if(totalInCluster > 0){
                        centroids.get(j).X(totalX / totalInCluster);
                        centroids.get(j).Y(totalY / totalInCluster);
                    }
                    //System.out.println(centroids.get(j).X());
                
        	}
        	
        	for(int i=0;i<20;i++)
        	{
        		 for(int j = 0; j < K; j++)
                 {
        			 newData = new Data(dataSet.get(i).X(), dataSet.get(i).Y());
        			 //System.out.println(dataSet.get(i).X());
                     distance = dist(newData, centroids.get(j));
                     
                     if(distance < minimum){
                         minimum = distance;
                         cluster = j;
                     }
                 }
        		 dataSet.get(i).cluster(cluster);
        		 minimum=bigNumber;
        		 
        		 
        	}
        	
        	cnt++;
        }
       
        
        
       
        return;
    }

    private static double dist(Data d, Centroid c)
    {
        return Math.sqrt(Math.pow((c.Y() - d.Y()), 2) + Math.pow((c.X() - d.X()), 2));
    }
    
    private static class Data
    {
        private double mX = 0;
        private double mY = 0;
        private int mCluster = 0;
        
        public Data()
        {
            return;
        }
        
        public Data(double x, double y)
        {
            this.X(x);
            this.Y(y);
            return;
        }
        
        public void X(double x)
        {
            this.mX = x;
            return;
        }
        
        public double X()
        {
            return this.mX;
        }
        
        public void Y(double y)
        {
            this.mY = y;
            return;
        }
        
        public double Y()
        {
            return this.mY;
        }
        
        public void cluster(int clusterNumber)
        {
            this.mCluster = clusterNumber;
            return;
        }
        
        public int cluster()
        {
            return this.mCluster;
        }
    }
    
    private static class Centroid
    {
        private double mX = 0.0;
        private double mY = 0.0;
        
        public Centroid()
        {
            return;
        }
        
        public Centroid(double newX, double newY)
        {
            this.mX = newX;
            this.mY = newY;
            return;
        }
        
        public void X(double newX)
        {
            this.mX = newX;
            return;
        }
        
        public double X()
        {
            return this.mX;
        }
        
        public void Y(double newY)
        {
            this.mY = newY;
            return;
        }
        
        public double Y()
        {
            return this.mY;
        }
    }
    
    public static void main(String[] args)
    {
        initialize();
        kMeanCluster();
        
        // Print out clustering results.
        for(int i = 0; i < K; i++)
        {
            System.out.println("Cluster " + i + " includes:");
            for(int j = 0; j < n; j++)
            {
                if(dataSet.get(j).cluster() == i){
                    System.out.println("     (" + dataSet.get(j).X() + ", " + dataSet.get(j).Y() + ")");
                }
            } // j
            System.out.println();
        } // i
        
        // Print out centroid results.
        System.out.println("Centroids finalized at:");
        for(int i = 0; i < K; i++)
        {
            System.out.println("     (" + centroids.get(i).X() + ", " + centroids.get(i).Y());
        }
        System.out.print("\n");
        return;
    }
}