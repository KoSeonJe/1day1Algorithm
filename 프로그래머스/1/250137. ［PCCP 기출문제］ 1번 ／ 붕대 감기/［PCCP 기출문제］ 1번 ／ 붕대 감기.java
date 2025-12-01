class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int techTime = bandage[0];
        int secondHealth = bandage[1];
        int addHealth = bandage[2];
        
        int lastTime = attacks[attacks.length-1][0];
        int time = 0;
        int currentHealth = health;
        int attackCount = 0;

        for (int i = 0; i<lastTime; i++) {
            time++;
            if (attacks[attackCount][0] == i + 1) {
                currentHealth = currentHealth - attacks[attackCount][1];
                if(currentHealth <= 0) return -1;
                time = 0;
                attackCount = attackCount + 1;
            } else {
                currentHealth = currentHealth + secondHealth > health ? health : currentHealth + secondHealth;
                
                if (time == techTime) {
                    currentHealth = currentHealth + addHealth > health ? health : currentHealth + addHealth;
                    time = 0;
                }
            }
        }
        
        return currentHealth;
    }
}