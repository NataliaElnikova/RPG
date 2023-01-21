abstract public class Person {
    protected String name;
    protected int healthPoints = 100;
    private int strength;
    private int agility;
    protected int xp;
    protected int gold;


    public Person(String name, int healthPoints, int strength, int agility, int xp, int gold) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.agility = agility;
        this.xp = xp;
        this.gold = gold;
    }

    public void attack(Person person) {
        person.receive(this);
    }

    public void receive(Person person) {
        this.healthPoints -= person.getStrength();
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }
    public int getGold() {
        return this.gold;
    }

    public boolean isDead() {
        return this.healthPoints <= 0;
    }

    public String getName() {
        return this.name;
    }
}