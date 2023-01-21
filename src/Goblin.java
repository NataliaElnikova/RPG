public class Goblin extends Monster {

    public Goblin(int healthPoints, int strength, int agility, int gold) {
        super("Гоблин", healthPoints, strength, agility, gold);
    }

    @Override
    public String introduce() {
        return this.name;
    }
}
