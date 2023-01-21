public class Skeleton extends Monster {

    public Skeleton(int healthPoints, int strength, int agility, int gold) {
        super("Скелет", healthPoints, strength, agility, gold);
    }

    @Override
    public String introduce() {
        return this.name;
    }
}
