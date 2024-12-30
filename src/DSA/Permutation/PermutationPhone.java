package Permutation;

import java.util.List;
import java.util.ArrayList;

public class PermutationPhone {
    public static void main(String[] args) {
        String digit = "78";
        List<String> combination = getcombination("", digit);
        System.out.println(combination);
    }

    static List<String> getcombination(String p , String digit){
        List<String> res = new ArrayList<>();
        if(digit.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }


        int digi = digit.charAt(0) - '0';
        int start = (digi - 2) * 3;
        int letterCount = 3;

        if (digi == 7 || digi == 9) {
            letterCount = 4;
        }
        if (digi > 7) {
            start += 1;
        }

        for (int i = 0; i < letterCount; i++) {
            char ch = (char) ('a' + start + i);
            res.addAll(getcombination(p + ch, digit.substring(1)));
        }

        return res;
    }
}