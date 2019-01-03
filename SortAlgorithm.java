public class SortAlgorithm{
    public static void mergeSort(int[] ints, int leftStart, int rightEnd){
        // base case
        if(leftStart == rightEnd){
            return;
        }
        // sort left half
        int leftEnd = (rightEnd - leftStart)/2 + leftStart;
        mergeSort(ints, leftStart, leftEnd);
        mergeSort(ints, leftEnd + 1, rightEnd);
        merge(ints, leftStart, leftEnd, rightEnd);
    }
    public static void merge(int[] ints, int leftStart, int leftEnd, int rightEnd){
        int[] tmp = new int[rightEnd - leftStart + 1];
        int l = leftStart;
        int r = leftEnd + 1;
        int index = 0;
        while(l <= leftEnd && r <= rightEnd){
            if(ints[l] < ints[r]){
                tmp[index] = ints[l];
                index++;
                l++;
            }
            else if(ints[r] < ints[l]){
                tmp[index] = ints[r];
                index++;
                r++;
            }
            else{
                tmp[index] = ints[l];
                index++;
                l++;
            }
        }
        while(l <= leftEnd){
            tmp[index] = ints[l];
            index++;
            l++;
        }
        while(r <= rightEnd){
            tmp[index] = ints[r];
            index++;
            r++;
        }
        for(int i = 0; i < tmp.length; i++){
            ints[leftStart + i] = tmp[i];
        }
    }
    public static void print(int[] ints){
        for(int e : ints){
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args){
        int[] ints = {1, 3, -1, 5};
        //            0  1   2  3
        merge(ints, 0, 1, 3);
        print(ints);
    }
}
