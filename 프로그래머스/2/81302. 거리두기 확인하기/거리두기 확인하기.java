class Solution {
    
    static int count;
    static boolean[][] visited;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < places.length; i++) {
            boolean followedRule = true;
            count = 0;
            visited = new boolean[5][5];
            for (int j = 0; j < places[0].length; j++) {
                for (int k =0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        visited[j][k] = true;
                        checkAll(i, j, k, places, 1);
                    }
                    if (count > 0) {
                        followedRule = false;
                        break;
                    }
                }
            }
            
            if (followedRule) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    public void checkAll(int i, int j, int k, String[][] places, int depth) {
        check(i, j+1, k, places, depth);
        check(i, j-1, k, places, depth);
        check(i, j, k+1, places, depth);
        check(i, j, k-1, places, depth);
    }
    
    public void check(int i, int j, int k, String[][] places, int depth) {
        if (depth > 2 || count > 0) {
            return;
        }
        
        if (j < 0 || j >= 5 || k < 0 || k>= 5){
            return;
        }
        
        if (visited[j][k]) return;
        
        char current = places[i][j].charAt(k);
        
        if (current == 'X') return;
        
        if (current == 'P') {
            count++;
            return;
        }
        
        // current == 'O'
        visited[j][k] = true;
        checkAll(i, j, k, places, depth + 1);
        visited[j][k] = false;
        
    }
}