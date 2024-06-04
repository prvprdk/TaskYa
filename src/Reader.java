import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Reader {

    //reading Tasks description
    public static void main(String[] args) {

        int[] ar;
        int[] ar2;
        int size;
        List<String> lines;

        // path to file
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()))) {
            lines = bufferedReader.lines().toList();
            size = Integer.parseInt(lines.get(0));

            ar = new int[size];
            ar2 = new int[size];


            IntStream.range(1, lines.size()).forEach(i ->
            {
                String[] split = lines.get(i).split(" ");
                ar[i - 1] = Integer.parseInt(split[0]);
                ar2[i - 1] = Integer.parseInt(split[1]);
            });
            System.out.println(Arrays.toString(ar));

            // next step we`ll might call method
            // Segments.nonIntersecting(ar, ar2);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
