import java.util.List;

public class AutoCompleteMinimal {
    private final static String REGEX_PATTERN = "^%s.*";

    public static void main(String[] args) {

        List<String> list = List.of(
                "aa",
                "aaa",
                "aab",
                "ab",
                "abc",
                "ac",
                "ba",
                "daa",
                "dab",
                "dadba"
        );
        System.out.println(autoMinimal(list, "4 a"));
    }

    static int autoMinimal (List <String> listOfWords, String query){

        String[] str = query.split(" ");
        String regex = String.format(REGEX_PATTERN, str[1]);

        List<String> listOfMatcher = listOfWords.stream().filter(i -> i.matches(regex)).toList();

        try {
            String string = listOfMatcher.get(Integer.parseInt(str[0]) - 1);
            return listOfWords.indexOf(string) + 1;
        }catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }

    }
}
