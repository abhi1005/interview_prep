package string;

import java.util.*;

public class LongestWord {
    public static void main(String[] args) {
        LongestWord longestWord = new LongestWord();
        //String[] str = {"a","banana","app","appl","ap","apply","apple"};
        //String[] str = {"w","world","wor","wo","worl","apply","apple"};
        //String[] str = {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
        String[] str = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        //String[] str = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        //System.err.println(longestWord.longestWordGenerator(str));
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length() == b.length() && a.compareTo(b) < 0)
                    return 1;
                if(a.length() > b.length() && a.compareTo(b) > 0)
                    return -1;
                if(a.compareTo(b) < 0)
                    return 1;
                return -1;
            }
        });
        for(String word: str){
            System.err.println(word);
        }
    }
    public String longestWordGenerator(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words)
            set.add(word);
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length() == b.length() && a.compareTo(b) < 0)
                    return -1;
                return b.compareTo(a);
            }
        });

        for(String word: words){
            //System.err.println(word);
        }

        for(String word: words){
            boolean isPresent = true;
            for(int i=1;i<word.length();i++){
                String sub = word.substring(0,i);
                if(!set.contains(sub)){
                    isPresent = false;
                    break;
                }
            }
            if(isPresent){
                return word;
            }
        }
        return  "";
    }
}
