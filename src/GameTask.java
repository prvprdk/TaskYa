import java.util.*;
import java.util.stream.IntStream;

public class GameTask {

    public static void main(String[] args) {

        // task platform game
        char[] str = new char[]{'L', 'R', 'F', 'F', 'L', 'R'};

        List<String> list = new ArrayList<>();
        //unique positions
        Set<Integer> set = new HashSet<>();

        IntStream.range(0, str.length).forEach(i -> {

            char[] ch = str.clone();

            switch (str[i]) {
                case 'L':
                    swap(ch, i, 'F', list);
                    swap(ch, i, 'R', list);
                   break;
                case 'R':
                    swap(ch, i, 'L', list);
                    swap(ch, i, 'F', list);
                    break;
                case 'F':
                    swap(ch, i, 'R', list);
                    swap(ch, i, 'L', list);
                    break;
            }
            ch = str.clone();

        });

        for (String s : list) {
            int position = 0;
            boolean isRight = true;

            for (int x = 0; x < s.length(); x++) {

                if (s.charAt(x) == 'L') isRight = false;
                if (s.charAt(x) == 'R') isRight = true;

                if (s.charAt(x) == 'F' && isRight) {
                    position++;
                    set.add(position);
                }
                if (s.charAt(x) == 'F' && !isRight) {
                    position--;
                    set.add(position);
                }

            }
        }
        System.out.printf("number of different positions: %d", set.size());
    }

   static void swap (char [] array, int index, char ch, List<String> list){
        array[index] = ch;
        list.add(Arrays.toString(array));
    }
}
