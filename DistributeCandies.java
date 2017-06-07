import java.io.*;
import java.util.*;

public class DistributeCandies {

    public static void main(String[] args) {
        
            Scanner s = new Scanner(System.in);
        
            int n = s.nextInt();
        long c = 0;
        int rating[] = new int[n];
           int candies[] = new int[n];
        
        for(int i = 0; i < n ; i++) {
            rating[i]= s.nextInt();
            candies[i] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            
            if(rating[i] > rating[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        
        for(int i = n-2; i >=0 ; i--) {
            
            if(rating[i] > rating[i+1] && candies[i] > candies[i+1])
                continue;
            
            else if (rating[i] > rating[i+1] )
            
            {
                candies[i] = candies[i+1] + 1;
            }
        
      }
        for(int i = 0; i < n; i++)
            c += candies[i];
        System.out.println(c); 
        
        
        
    }
}