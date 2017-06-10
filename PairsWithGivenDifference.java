

import java.util.Arrays;

//[0, -1, -2, 2, 1], k = 1

//-2 -1 0 1 2
//[-1, -2], [0, -1], [1,0] [2,1]



//[1, 7, 5, 3, 32, 17, 12], k = 17

//[1  ,3  ,5  , 7  , 12  ,17  , 32  ]

class PairsWithGivenDifference {

  static int[][] findPairsWithGivenDifference(int[] arr, int k) {

  Arrays.sort(arr);
    
  int l = arr.length;
    
  if(arr.length <= 1)  // 0 & 1
    return new int[][]{{}};
    
   int p = 0, q = 1;
    
    int result[][] = new int[l-1][2];
    
    int index = 0;
   while(p < l && q < l) {
     
     if(arr[q]-arr[p] == k) {
       result[index][0] = arr[q];
       result[index++][1] = arr[p];
       p++; q++;
     }
     else if (arr[q]-arr[p] < k) {
       q++;     
   }
     else
       p++;  
  }
    if(index == 0)    // no solution exists
        return new int[][]{{}};
    return result;
  }
  public static void main(String[] args) {
    
    int result[][] = findPairsWithGivenDifference(new int[]{1  ,3  ,5  , 7  , 12  ,17  , 32 } , 17);
    
    for(int i = 0; i < result.length; i++) {
      for(int j = 0; j < result[0].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }

  }

}


       
             
     