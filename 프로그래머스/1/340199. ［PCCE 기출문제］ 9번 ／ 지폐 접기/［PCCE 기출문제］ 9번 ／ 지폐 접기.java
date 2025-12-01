class Solution {
    public int solution(int[] wallet, int[] bill) {
        int wx = wallet[0];
        int wy = wallet[1];
        
        int bx = bill[0];
        int by = bill[1];
        
        int maxW = Math.max(wx, wy);
        int maxB = Math.max(bx, by);
        
        int minW = Math.min(wx, wy);
        int minB = Math.min(bx, by);
        
        if (maxW >= maxB && minW >= minB) {
            return 0;
        }
        
        int answer = 0;
        do {
            answer++;
            
            if(bx > by){
                bx = bx/2;
            } else {
                by = by/2;
            }
        } while (!(wx >= bx && wy >= by || wx >= by && wy >= bx));
        
        
        return answer;
    }
}