// 8 1
// 10 2
// 12 3
// 14 4, 12 4
// 16 5,
// 18 6, 14 6
// 20 7
// 22 8, 16 8

import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        for (int height = 1; height <= Math.sqrt(yellow); height++) {
            if (yellow % height == 0) {
                int width = yellow / height;
                
                // 전체 카펫 크기
                int totalWidth = width + 2;
                int totalHeight = height + 2;
                
                // 갈색 타일 개수 확인
                int brownCount = totalWidth * totalHeight - yellow;
                
                if (brownCount == brown) {
                    return new int[]{totalWidth, totalHeight};
                }
            }
        }
        
        return new int[]{0, 0};
    }
}