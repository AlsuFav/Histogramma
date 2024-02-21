import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeMap;

public class Homework1 {
    public static void main(String[] args) throws IOException {
        String input = Files.readString(Paths.get("C:\\Users\\182\\IdeaProjects\\asd\\src\\hw1"));
        ArrayList<Character> chrArr = new ArrayList<>();
        for(char chr: input.toCharArray()){
            if(chr != ' ' && chr != '\n' && chr != '\r'){
                chrArr.add(chr);
            }
        }

        TreeMap<Character, Integer> chrsCount = new TreeMap<>();
        for(char chr: chrArr){
            if(chrsCount.containsKey(chr)){
                chrsCount.put(chr, chrsCount.get(chr) + 1);
            }
            else{
                chrsCount.put(chr, 1);
            }
        }

        int maxValue = 0;
        for(char chr: chrsCount.keySet()){
            if(chrsCount.get(chr) > maxValue){
                maxValue = chrsCount.get(chr);
            }
        }
        Object[] chrs = chrsCount.keySet().toArray();

        char[][] table = new char[maxValue][chrs.length];
        for(int i = 0; i < maxValue; i++){
            for (int j = 0; j < chrs.length; j++){
                if(chrsCount.get(chrs[j]) >= maxValue-i){
                    table[i][j] = '#';
                }
                else{
                    table[i][j] = ' ';
                }
            }
        }

        for(int i = 0; i < maxValue; i++){
            for (int j = 0; j < chrs.length; j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        for(char chr: chrsCount.keySet()){
            System.out.print(chr);
        }
    }
}
