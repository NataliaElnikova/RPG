public class Player extends Person {
    int level = 1;
    public Player(String name, int healthPoints, int strength, int agility, int xp, int gold) {
        super(name, healthPoints, strength, agility, xp, gold);
    }


    public void earn(Monster monster) {
        this.gold += monster.getGold();
    }

    public void boostXp(Monster monster) {

        this.xp += monster.getAgility() + monster.getStrength();
    }

    public void spendMoney(int cost) {
        this.gold -= cost;
    }

    public void heal() {
        this.healthPoints = 100;
    }

}
