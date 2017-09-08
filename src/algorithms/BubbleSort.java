package algorithms;

/**
 * Created by Mirco Baalmans on 8/21/2017.
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] list){
        int i,j,temp;

        for(j = 0;j < list.length;j++){
            for(i = 1;i < list.length - j;i++){
                if(list[i-1] > list[i]){
                    temp = list[i];
                    list[i] = list[i-1];
                    list[i-1] = temp;
                }
            }
        }




        return list;
    }


}
