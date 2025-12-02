class Solution {
    public int[] solution(String[] park, String[] routes) {
        String[][] realPark = new String[park.length][park[0].length()];
                Location currentLocation = new Location(0,0);

        for (int i = 0; i<park.length; i++) {
            for (int j = 0; j< park[0].length(); j++) {
                realPark[i][j] = String.valueOf(park[i].charAt(j));
                if (realPark[i][j].equals("S")) {
                    currentLocation = new Location(j, i);
                }
            }
        }
        
        for (int k = 0; k < routes.length; k++) {
            String[] command = routes[k].split(" ");
            String direction = command[0];
            int distance = Integer.parseInt(command[1]);
            System.out.println(currentLocation.y + " " + currentLocation.x);
            if (canMove(direction, distance, currentLocation, realPark)) {
                currentLocation.move(direction, distance);
            }
        }
        int[] answer = {currentLocation.y, currentLocation.x};
        return answer;
    }
    
    public boolean canMove(String direction, int distance, Location currentLocation, String[][] realPark) {
        if (direction.equals("E")) {
            if (currentLocation.x + distance > realPark[0].length - 1) {
                return false;
            }
            for (int i = 1; i <=distance; i ++){
                if (realPark[currentLocation.y][currentLocation.x + i].equals("X")) {
                    return false;
                }
            }
        }
        if (direction.equals("W")) {
            if (currentLocation.x - distance < 0) {
                return false;
            }
            for (int i = 1; i <=distance; i ++){
                if (realPark[currentLocation.y][currentLocation.x - i].equals("X")) {
                    return false;
                }
            }
        }
        if (direction.equals("S")) {
            if (currentLocation.y + distance > realPark.length - 1) {
                return false;
            }
            for (int i = 1; i <=distance; i ++){
                if (realPark[currentLocation.y+i][currentLocation.x].equals("X")) {
                    return false;
                }
            }
        }
        if (direction.equals("N")) {
            if (currentLocation.y - distance < 0) {
                return false;
            }
            for (int i = 1; i <=distance; i ++){
                if (realPark[currentLocation.y-i][currentLocation.x].equals("X")) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Location {
    int x;
    int y;
    
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void move(String direction, int distance) {
        if (direction.equals("E")) {
            x = x + distance;
        }
        if (direction.equals("W")) {
            x = x - distance;
        }
        if (direction.equals("S")) {
            y = y + distance;
        }
        if (direction.equals("N")) {
            y = y - distance;
        }
    }
}