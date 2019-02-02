import java.util.HashSet;
import java.util.Set;

public class StringCombinationApplication {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("back");
        s.add("end");
        s.add("front");
        s.add("tree");

        System.out.println(isCombinationPresent(s, "backend"));
        System.out.println(isCombinationPresent(s, "frontyard"));
        System.out.println(isCombinationPresent(s, "frontend"));
    }

    //get all substring and check with the set.
    private static boolean isCombinationPresent(Set<String> list_of_strings, String input_string) {
        int actualLength = input_string.length();
        int unfoundCharactersLength = actualLength;    //To check complete string is present
        for (int i = 0; i < actualLength; i++) {
            for (int j = i + 1; j <= actualLength; j++) {
                unfoundCharactersLength = updatedUnfoundCharacters(list_of_strings, input_string, unfoundCharactersLength, i, j);
                if (unfoundCharactersLength == 0) {
                    break;          //Break when found
                }
            }
        }

        if (unfoundCharactersLength == 0)
            return true;
        else
            return false;
    }

    //pulled out this method for readability
    private static int updatedUnfoundCharacters(Set<String> list_of_strings, String input_string, int unfoundCharactersLength, int i, int j) {
        String word = input_string.substring(i, j);
        if (list_of_strings.contains(word)) {
            unfoundCharactersLength = unfoundCharactersLength - word.length(); // reducing the length to find how many are not found
        }
        return unfoundCharactersLength;
    }
}
