package lab2;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class lab2 {

	public static void main (String[] args) throws IOException {
		/*
		private static final int N = 10;
		int[] arr = new int[N];
		Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(N);
        }
        
        String num = String.valueOf(N);
        String filename = "inputWith"+num+".txt";
        writeArray(filename, arr);
        */
		
		// READ PART
		
		// N == 100
		measureTime (100);
		
        // N == 1000
		measureTime (1000);
		
	    // N == 10000
		measureTime (10000);
		
	    // N == 200000
		measureTime (200000);
		
	    // N == 500000
		measureTime (500000);
		
	    // N == 700000
		measureTime (700000);
		
	    // N == 1000000
		measureTime (1000000);
		
        // N == 2000000
		measureTime (2000000);
		
        // N == 5000000
		measureTime (5000000);
        
        // N == 7000000
		measureTime (7000000);
        
        // N == 10000000
        measureTime (10000000);
	}
	
	private static void measureTime (int N){
        int [] arr = readArray("inputWith" + N + ".txt", N);
        
        // best case;
        quicksort (arr);
        
        // worst case
        for (int i = 0; i < N / 2; i++) {
        	ArrayAssistant.swap (arr, i, N - 1 - i);
		}
        
        double before = System.currentTimeMillis();
		insertionSort (arr);
		double after = System.currentTimeMillis();
		System.out.printf("Time of sorting (%d el):", N);
		double res = after-before;
		System.out.print(res);
		System.out.println("");
	}
	
    private static int[] readArray(String file, int n){
        try{
            String buff;
            Scanner s = new Scanner(new File(file));
            int[] array = new int[n];
            for (int i = 0; i < n; i++){
                buff = s.next();
                array[i] = Integer.parseInt(buff);
            }
            s.close();
            return array;
        }
        catch (FileNotFoundException e){

        }
        return null;
    }
	
	public static void writeArray (String filename, int[] arr) throws IOException{
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < arr.length; i++) {
            outputWriter.write(arr[i]+"\n");
        }
        outputWriter.flush();
        outputWriter.close();
    }
	
	public static void insertionSort (int[] arr) {
		int N = arr.length;
		for (int i = 1; i < N; i++) {
			int j = i - 1;
			int key = arr[i];
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
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

