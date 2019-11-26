package map;

import common.Constants;
import java.lang.*;
public class Map {
    private static Map instance = null;
    private int[][] map;
    private int row;
    private int col;


    Map (int row, int column) {
        this.map = new int[row][column];
        this.row = row;
        this.col = column;
    }
    public static Map getInstance(int row, int column) {
        instance = new Map(row, column);
        return instance;
    }
    public static Map getInstance() {
        return instance;
    }

    public int[][] getMap() {
        return map;
    }
    public void setLocation(String location, int curr_row) {
        char[] lArray = location.toCharArray();
//        System.out.println(lArray.length);
//        System.out.println(lArray[0]);
        int curr_col = 0;
        for(char c : lArray){
         //   System.out.println(c);
            if (c == 'L') {
                this.map[curr_row][curr_col++] = Constants.Land_type;
            } else if (c == 'V') {
                this.map[curr_row][curr_col++] = Constants.Volcanic_type;
            } else if (c == 'D') {
                this.map[curr_row][curr_col++] = Constants.Desert_type;
            } else {
                this.map[curr_row][curr_col++] = Constants.Woods_type;
            }

        }
    }

    public void display() {
        for (int i = 0; i < row; i++) {
            for (int j = 0 ;j < col; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
