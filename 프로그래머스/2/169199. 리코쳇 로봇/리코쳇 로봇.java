import java.util.*;

class Solution {

    public int solution(String[] board) {

        int h = board.length;
        int w = board[0].length();

        String[][] realBoard = new String[h][w];
        int rx = 0, ry = 0, gx = 0, gy = 0;

        // 보드 파싱 + 시작점/목표점 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char c = board[i].charAt(j);
                realBoard[i][j] = String.valueOf(c);

                if (c == 'R') {
                    rx = j;
                    ry = i;
                }
                if (c == 'G') {
                    gx = j;
                    gy = i;
                }
            }
        }

        // BFS
        Deque<Location> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][w];

        q.add(new Location(rx, ry, 0));
        visited[ry][rx] = true;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}}; // 우, 좌, 하, 상

        while (!q.isEmpty()) {

            Location cur = q.poll();

            // 목표 도달
            if (cur.x == gx && cur.y == gy) {
                return cur.level;
            }

            // 4방향으로 미끄러지기
            for (int[] d : directions) {
                Location next = slide(cur.x, cur.y, d[0], d[1], realBoard);

                if (!visited[next.y][next.x]) {
                    visited[next.y][next.x] = true;
                    next.level = cur.level + 1;
                    q.add(next);
                }
            }
        }

        return -1; // 도달 불가
    }

    // 미끄러지는 함수
    private Location slide(int x, int y, int dx, int dy, String[][] board) {
        int nx = x;
        int ny = y;

        while (true) {
            int tx = nx + dx;
            int ty = ny + dy;

            // 벽 또는 장애물에 부딪히면 stop
            if (tx < 0 || tx >= board[0].length || ty < 0 || ty >= board.length) break;
            if (board[ty][tx].equals("D")) break;

            nx = tx;
            ny = ty;
        }

        return new Location(nx, ny, 0);
    }
}

class Location {
    int x;
    int y;
    int level;

    public Location(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }

    public Location(int x, int y) {
        this(x, y, 0);
    }
}