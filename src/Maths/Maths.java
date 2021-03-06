package Maths;
import java.util.*;

public class Maths {
    public static void main(String[] args) {
        RandomPick rp = new RandomPick(new int[]{1,3,5,8});
    }
}

class RandomPick {
    int[] weights;
    int[] prefSum;
    int sum;
    Random rand;
    public RandomPick(int[] w) {
        this.weights = w;
        initial_pref_sum(w);
        rand = new Random();
    }

    public int pickIndex() {
        int number = rand.nextInt(this.sum);
        int index = binarySearch(number+1);
        //System.out.println(this.sum + " "+ number + " " + index);
        return index;
    }

    public int binarySearch(int number){
        int index = -1;
        int start = 0;
        int end = this.weights.length - 1;

        //for(int i=0; i<=end; i++) System.out.print(this.prefSum[i] + " ");
        //System.out.println();
        while(start <= end){
            int mid = start + ( (end - start)/2 );
            //System.out.println("start = " + start+ " mid = " + mid + " end = "+ end);
            if(this.prefSum[mid] >= number){
                index = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        index = index == -1 ? this.weights.length - 1 : index;
        return index;
    }

    public void initial_pref_sum(int[] w){
        int len = w.length;
        this.prefSum = new int[len];
        this.sum = 0;
        for(int i=0; i<len; i++){
            this.sum += w[i];
            prefSum[i] = this.sum;
        }
    }
}

class ModulerArithmatics{

}

class GCD{

    public static void main(String[] args) {
        System.out.println(gcd(246, 342));
    }


    public static int gcd(int a, int b){
        if(b < 1) return a;
        return gcd(b, a%b);
    }
}

