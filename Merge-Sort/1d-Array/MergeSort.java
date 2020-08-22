import java.util.Random;


public class MergeSort {

    public static int[] mergeSort(int a[]){
        //base case for recursion
        if(a.length==1) {
            return a;
        }
        //making arrays to split the input in half
        int array1[] = new int[a.length/2];
        int array2[];

        //to check if the input size is an odd number
        if(a.length%2==1)
            array2 = new int[(a.length/2)+1];
        else
            array2 = new int[a.length/2];

        //splitting the input array into two separate arrays
        int i=0,j=0;
        while(i<a.length){
            if(i<a.length/2){
                array1[i] = a[i];
            }
            else{
                array2[j]=a[i];
                j++;
            }
            i++;
        }

        //recursive call on the split arrays
        array1 = mergeSort(array1);
        array2 = mergeSort(array2);

        //merging the split arrays
        return merge(array1,array2);
    }

    public static int[] merge(int arr1[], int arr2[]) {
        //making the array to hold the sorted outcome
        int size = arr1.length + arr2.length;
        int arr3[] = new int[size];

        //making the code easier to read
        int pos1 =0, pos2=0, pos3=0;
        int end1 = arr1.length,end2=arr2.length;

        //while both of the arrays have elements
        while(pos1<end1 && pos2 <end2){
            if(arr1[pos1]<arr2[pos2]){
                arr3[pos3] = arr1[pos1];
                pos1++;
            }
            else{
                arr3[pos3] = arr2[pos2];
                pos2++;
            }
            pos3++;
        }

        //only 1 of these while loops will run depending on which one is not empty
        while(pos1<end1){
            arr3[pos3] = arr1[pos1];
            pos1++;
            pos3++;
        }
        while (pos2 <end2){
            arr3[pos3] = arr2[pos2];
            pos2++;
            pos3++;
        }

        //return the sorted array :)
        return arr3;
    }

    //To avoid using excessive for-loops, and to print the array in a neat format
    public static void print(int arr[]){
        String ans = new String("[");
        for(int i=0; i< arr.length;i++){
            ans+=" "+arr[i];
        }
        ans+=" ]";
        System.out.println(ans);
    }


    public static void main (String[] args){
        //initial test case
        int arr[] = {1,4,7,3,5,8,2,9,12,4675,66,34,99,1234,-20,100000};
        print(arr);
        print(mergeSort(arr));

        //random test case
        Random rand = new Random();
        int n = rand.nextInt(1000);
        int testarr[] = new int[n];

        for(int i=0;i<n;i++){
            testarr[i] = rand.nextInt();
        }

        print(testarr);
        print(mergeSort(testarr));
    }
}
