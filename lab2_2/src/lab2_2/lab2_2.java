package lab2_2;

import java.io.*;
import java.util.Random;

public class lab2_2 {
	public static void main (String[] args) throws IOException {
		// COMPARE SEARCH PART
		int N = 100;
        int[] arr1 = createTestArray(N);
        searchTimeCompare (arr1, N);
        
        N = 10000;
        int[] arr2 = createTestArray(N);
        searchTimeCompare (arr2, N);
        
        N = 100000;
        int[] arr3 = createTestArray(N);
        searchTimeCompare (arr3, N);
        
        N = 10000000;
        int[] arr4 = createTestArray(N);
        searchTimeCompare (arr4, N);
        
        N = 30000000;
        int[] arr5 = createTestArray(N);
        searchTimeCompare (arr5, N);

        int[] arr6 = createTestArray(N);
        searchTimeCompare (arr6, N);
        
        N = 70000000;
        int[] arr7 = createTestArray(N);
        searchTimeCompare (arr7, N);

        N = 100000000;
        int[] arr8 = createTestArray(N);
        searchTimeCompare (arr8, N);

        N = 120000000;
        int[] arr9 = createTestArray(N);
        searchTimeCompare (arr9, N);
        // END OF COMPARE SEARCH PART
	}
	
	/* 
	 * input: N - size of desired array;
	 * output: sorted array of size N.
	 */
    private static int[] createTestArray(int N){

        int[] arr = new int[N];
		Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            //arr[i] = rand.nextInt(N);
        	arr[i] = i;
        }
        //quicksort (arr);
    	return arr;
    }
   
    public static void searchTimeCompare (int [] arr, int el)
    {
    	int key;
		double before;
		double after;
		double res;
		// 4 THE PRESENT VALUE
    	//key = getPresentingKey(arr);
		key = 2;
        before = System.nanoTime();
        interpolationSearch(arr, key);
		after = System.nanoTime();
		System.out.printf("Time of interpolationSearch *present value* (%d el):", el);
		res = after-before;
		System.out.print(res);
		System.out.println("");
		
		before = System.nanoTime();
		binarySearch(arr, key);
		after = System.nanoTime();
		System.out.printf("Time of binarySearch *present value* (%d el):", el);
		res = after-before;
		System.out.print(res);
		System.out.println("\n");
		
    	// 4 MISSING VALUE
    	//key = getAbsentKey (arr);
		key = arr.length / 8;
        before = System.nanoTime();
        interpolationSearch(arr, key);
		after = System.nanoTime();
		System.out.printf("Time of interpolationSearch *missing value* (%d el):", el);
		res = after-before;
		System.out.print(res);
		System.out.println("");
		
		before = System.nanoTime();
		binarySearch(arr, key);
		after = System.nanoTime();
		System.out.printf("Time of binarySearch *missing value* (%d el):", el);
		res = after-before;
		System.out.print(res);
		System.out.println("\n");
    }
    
    public static int getPresentingKey (int [] arr){
    	Random rand = new Random();
    	int key = arr[rand.nextInt(arr.length)];
    	
    	return key;
    }
    
    public static int getAbsentKey (int [] arr){
    	Random rand = new Random();
    	int key;
    	do{
    		key = rand.nextInt(arr.length);
    	} while (interpolationSearch(arr, key) != -1);
    	
    	return key;
    }
    
    public static int interpolationSearch(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (int) (lo + (hi - lo) * ((key - arr[lo]) / (arr[hi] - arr[lo])));
			if (key == arr[mid]) {
				return mid;
			} else {
				if (key < arr[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
		}
		return -1;
	}
	
    private static int binarySearch(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key == arr[mid]) {
				return mid;
			} else {
				if (key < arr[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
		}
		return -1;
	}
	
	public static void quicksort(int[] a) {
		quicksort(a, 0, a.length - 1);
	}

	private static int rand(int lo, int hi) {
		Random rn = new Random();
		int n = hi - lo + 1;
		int i = rn.nextInt(n);
		return lo + i;
	}

	public static void quicksort(int[] ar, int lo, int hi) {
		if (lo < hi) {
			int iPivot = rand(lo, hi);
			ArrayAssistant.swap(ar, iPivot, hi);
			int q = partition(ar, lo, hi);
			quicksort(ar, lo, q - 1);
			quicksort(ar, q + 1, hi);
		}
	}

	public static int partition(int[] ar, int p, int r) {
		int pivot = ar[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (ar[j] <= pivot) {
				i++;
				ArrayAssistant.swap(ar, i, j);
			}
		}
		ArrayAssistant.swap(ar, i + 1, r);
		return i + 1;
	}
}

