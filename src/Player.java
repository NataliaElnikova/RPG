public class Player extends Person {
    public Player(String name, int healthPoints, int strength, int agility, int xp, int gold) {
        super(name, healthPoints, strength, agility, xp, gold);
    }


    public void earn(Monster monster) {
        this.gold += monster.getGold();
    }

    public void boostXp(Monster monster) {

        this.xp += monster.getAgility() + monster.getStrength();
        if (this.isLevelUpAvailable()) {
            this.levelUp();
            System.out.println("Новый уровень: " + level);
        }

    }

    public void spendMoney(int cost) {
        this.gold -= cost;
    }

    public void heal() {
        this.healthPoints = 100;
    }

    public boolean isLevelUpAvailable() {
        return this.xp > level * 100;
    }

    public void levelUp() {
        if (isLevelUpAvailable()) {
            this.level++;
            this.strength = this.strength + 3;
            this.agility = this.agility + 3;
        }
    }
}
