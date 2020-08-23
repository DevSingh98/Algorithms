import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MergeSort {
    public static List<Integer> mergeSort(List<Integer> a){
        //base case for recursion
        if(a.size()==1){
            return a;
        }
        //making list to split the input list in half
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();

        //separating the input list in half
        for(int i=0; i<a.size();i++){
            if(i< a.size()/2){
                arr1.add(a.get(i));
            }
            else{
                arr2.add(a.get(i));
            }
        }

        //recursively dividing the input list in half
        arr1 = (ArrayList<Integer>) mergeSort(arr1);
        arr2 = (ArrayList<Integer>) mergeSort(arr2);

        return merge(arr1,arr2);
    }

    public static List<Integer> merge(List<Integer> arr1, List<Integer> arr2){
        //list to hold the sorted list
        ArrayList<Integer> arr3 = new ArrayList<Integer>();

        //sorting the two halves one element at a time until one list is empty
        while(!arr1.isEmpty() && !arr2.isEmpty()){
            if(arr1.get(0) < arr2.get(0)){
                arr3.add(arr1.get(0));
                arr1.remove(0);
            }
            else{
                arr3.add(arr2.get(0));
                arr2.remove(0);
            }
        }

        //only one of these while loops will run depending on which list is not empty
        while(!arr1.isEmpty()){
            arr3.add(arr1.get(0));
            arr1.remove(0);
        }

        while(!arr2.isEmpty()){
            arr3.add(arr2.get(0));
            arr2.remove(0);
        }

        //return the sorted list
        return arr3;
    }

    public static void main (String[] args){
        //initial test case
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        arr.add(2);
        arr.add(29);
        arr.add(332);
        arr.add(1);
        arr.add(6);

        System.out.println(arr);
        System.out.println(mergeSort(arr));

        //random test case
        Random rand = new Random();
        int n = rand.nextInt(100);
        ArrayList<Integer> testarr = new ArrayList<>();

        for(int i=0;i<n;i++){
            testarr.add(rand.nextInt());
        }

        System.out.println(testarr);
        System.out.println(mergeSort(testarr));
    }
}
