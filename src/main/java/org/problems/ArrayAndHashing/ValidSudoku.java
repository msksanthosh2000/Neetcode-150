package org.problems.ArrayAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);

    }

    private static boolean isValidSudoku(char[][] b){

        Set s = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char ch = b[r][c];

                if(ch != '.'){
                    // sample - [1inB2-1, 1inCol8, 7inRow8, 1inB0-1]

                    if(!s.add(ch + "inRow" + r) || !s.add(ch + "inCol" + c) || !s.add(ch + "inB" + r/3 + "-" + c/3)){
                        return false;
                    }
                }

            }
        }
        System.out.println(s);
        return true;
    }
}
