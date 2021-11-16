package test6205;

import java.security.Key;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(mystery("hello"));
        Comparable[] arr = {65, 435, 76, 34, 76, 9, 35, 46, 67, 234, 75, 11, 19};
        String[] strings={"khd","bfd","mnf","cdv","liu"};
        stringSort(strings,3);
        heapSort(arr);
        for(int i=0;i<strings.length;i++){
        System.out.println(strings[i]);}
    }
    public static String mystery(String s) {int N = s.length();if (N <= 1) return s;String a = s.substring(0, N/2);String b = s.substring(N/2, N);return mystery(b) + mystery(a);}
    public static int BinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (value < arr[mid]) {
                high = mid - 1;
            }
            if (value > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static int bin(int[] arr,int value){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(value==arr[mid]) return mid;
            if(value<arr[mid]) right=mid-1;
            if(value>arr[mid]) left=mid+1;
        }
        return -1;
    }
    public static int rank(int[] arr, int value, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) return -1;
        else if (value > arr[mid]) return rank(arr, value, mid + 1, high);
        else if (value < arr[mid]) return rank(arr, value, low, mid - 1);
        else return mid;
    }

    public static void insertSort(int[] a) {
        for(int i=1;i<a.length;i++){
            for(int j=i-1;j>=0;j--){
                if(a[j]-a[j+1]>0){
                    swap(a,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    public static int[] quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return arr;
        }
        int left = leftIndex;
        int right = rightIndex;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, right + 1, rightIndex);
        quickSort(arr, leftIndex, left - 1);
        return arr;
    }
  public static void qsort(Comparable[] arr){
        qsort(arr,0,arr.length-1);
  }
  public static void qsort(Comparable[] arr,int left,int right){
        if(left>=right) return;
        int j=partition(arr,left,right);
        qsort(arr,left,j-1);
        qsort(arr,j+1,right);
  }
  public static int partition(Comparable[] arr,int left,int right){
        Comparable v=arr[left];
        int i=left;
        int j=right+1;
        while (true){
            while (less(arr[++i],v)) if (i==right) break;
            while (less(v,arr[--j])) if(j==left) break;
            if(i>=j) break;
            swap(arr,i,j);
        }
        swap(arr,left,j);
        return j;
  }
    public static void sort(Comparable[] arr,int left,int right,Comparable[] temp){
        if(left>=right) return;
        int mid=(left+right)/2;
        sort(arr,left,mid,temp);
        sort(arr,mid+1,right,temp);
        if(!less(arr[mid+1],arr[mid])) return;
        merge(arr,left,mid,right,temp);
    }
    public static void merge(Comparable[] arr,int left,int mid,int right,Comparable[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while(i<=mid&&j<=right){
            if(less(arr[j],arr[i])){
                temp[t++]=arr[j++];
            }else{
                temp[t++]=arr[i++];
            }
        }
        while(i<=mid){
            temp[t++]=arr[i++];
        }
        while(j<=right){
            temp[t++]=arr[j++];
        }
        t=0;
        while(left<=right){
            arr[left++]=temp[t++];
        }
    }
    public static void shell(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && arr[j] - arr[j - h] <0; j = j - h) {
                    swap(arr,j,j-h);
                }
            }
            h=h/3;
        }
    }
    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[j-1];
        a[j-1] = a[i-1];
        a[i-1] = temp;
    }
    public static void insertSort(Comparable[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0&&less(arr[j],arr[j-1]);j--){
                    swap(arr,j,j-1);
            }
        }
    }
    public static void selectionSort(Comparable[] arr){
        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(less(arr[j],arr[min])) min=j;
            }
            swap(arr,i,min);
        }
    }
    public static void shell(Comparable[] arr){
        int N=arr.length;
        int h=1;
        while(h<N/3) h=3*h+1;
        while(h>=1){
            for(int i=h;i<arr.length;i++){
                for(int j=i;j>=h&&less(arr[j],arr[j-h]);j=j-h){
                    swap(arr,j,j-h);
                }
            }
            h=h/3;
        }
    }
    public static void heapSort(Comparable[] a){
        int N=a.length;
        for (int k=N/2;k>=1;k--)
            sink(a,k,N);
        while (N>1){
            swap(a,1,N);
            sink(a,1,--N);
        }
    }
    public static void sink(Comparable[] a,int k,int N){
        while(2*k<=N){
            int j=2*k;
            if(j<N&&less(a[j-1],a[j]))j++;
            if(!less(k-1,j-1)) break;
            swap(a,k,j);
            k=j;
        }
    }
        public static void stringSort(String[] a, int W)
        { // Sort a[] on leading W characters.
            int N = a.length;
            int R = 256;
            String[] aux = new String[N];
            for (int d = W-1; d >= 0; d--)
            { // Sort by key-indexed counting on dth char.
                int[] count = new int[R+1]; // Compute frequency counts.
                for (int i = 0; i < N; i++)
                    count[a[i].charAt(d) + 1]++;
                for (int r = 0; r < R; r++) // Transform counts to indices.
                    count[r+1] += count[r];
                for (int i = 0; i < N; i++) // Distribute.
                    aux[count[a[i].charAt(d)]++] = a[i];
                for (int i = 0; i < N; i++) // Copy back.
                    a[i] = aux[i];
            }
        }

    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }


}
