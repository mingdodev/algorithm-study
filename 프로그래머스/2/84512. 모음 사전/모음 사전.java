import java.util.List;
import java.util.ArrayList;

class Solution {
    private static final char[] VOWELS = "AEIOU".toCharArray();
    
    public int solution(String word) {

        List<String> dictionary = new ArrayList<>();
        generate("", dictionary);
        
        return dictionary.indexOf(word);
    }
    
    private void generate(String word, List<String> words) {
        words.add(word);
        
        if (word.length() == 5) return;
        
        for (char v : VOWELS) {
            generate(word + v, words);
        }
    }
}