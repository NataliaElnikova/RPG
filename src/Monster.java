public abstract class Monster extends Person{
    public Monster(String name, int healthPoints, int strength, int agility, int gold) {
        super(name, healthPoints, strength, agility, 0, gold);
    }

    public int getGold() {
        return this.gold;
    }
    abstract public String introduce();
}

