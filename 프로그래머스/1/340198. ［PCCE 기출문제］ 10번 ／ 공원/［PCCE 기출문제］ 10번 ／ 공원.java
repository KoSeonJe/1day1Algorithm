import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {

        Arrays.sort(mats);
        
        for (int i = mats.length - 1; i>=0; i --) {
            int size = mats[i];
            if (canPut(size, park)) {
                return size;
            }
        }
        return -1;
    }
    
    private boolean canPut(int size, String[][] park) {
        int rPark = park.length;
        int cPark = park[0].length;
        
        for (int i = 0; i <= rPark - size; i ++) {
            for (int j = 0; j<= cPark - size; j++){
                if (canPut(size, i, j, park)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean canPut(int size, int i, int j, String[][] park) {
        for (int k = i; k < i + size; k ++) {
            for (int z = j; z<j+size; z++) {
                if (!park[k][z].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}