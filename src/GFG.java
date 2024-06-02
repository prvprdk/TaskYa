import java.util.Arrays;
import java.util.stream.IntStream;

public class GFG {

    public static void main(String[] args) {

        //
        permutation("abc", "");
        //Heap
        permutationHeap(new Number[]{1, 2, 3}, 3);
        //shift array to left
        permutationShift(new int[]{0, 1, 2});
    }


    static void permutation(String str, String ans) {

        if (str.isEmpty()) {
            System.out.println(ans + " ");
            return;
        }
        IntStream.range(0, str.length()).forEach(i -> {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permutation(ros, ans + ch);
        });
    }

    static <T> void permutationHeap(T[] array, int n) {

        if (n == 1) System.out.println(Arrays.toString(array));
        else {

            IntStream.range(0, n - 1).forEach(i -> {
                permutationHeap(array, n - 1);

                if (n % 2 == 0) swap(array, n - 1, i);
                else swap(array, 0, n - 1);

                System.out.println(Arrays.toString(array));

            });
        }
    }

    static void permutationShift(int[] array) {

        int key = array.length - 1;
        int ch = key;

        System.out.println(Arrays.toString(array));

        while (key > 0) {
            shift(array, key);
            if (array[key] != key) {
                System.out.println(Arrays.toString(array));
                key = ch;

            } else key--;

        }


    }

    static <T> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    static void shift(int[] array, int key) {
        int temp = array[0];

        IntStream.range(0, key).forEach(i -> array[i] = array[i + 1]);
        array[key] = temp;

    }


}
