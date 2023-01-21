import java.util.Random;

public class FightAction implements Actionable {
    private Player player;
    private Monster monster;

    FightAction(Player player) {
        this.player = player;
        Random rand = new Random();
        int monsterType = rand.nextInt(2);
        if (monsterType == 0) {
            this.monster = new Goblin(100, (new Random(5)).nextInt(9), (new Random(6)).nextInt(9), rand.nextInt(250));

        } else {
            this.monster = new Skeleton(100, (new Random(6)).nextInt(9), (new Random(5)).nextInt(9), rand.nextInt(350));

        }
        System.out.println("Сила монстра:" + monster.getStrength());
        System.out.println("Ловкость монстра:" + monster.getAgility());
    }

    @Override
    public void doAction() throws InterruptedException {
        Random rand = new Random();
        Person assaulter = rand.nextInt(2) == 0 ? this.player : this.monster;
        Person assaulty = assaulter == this.player ? this.monster : this.player;

        while (!player.isDead() && !monster.isDead()) {
            assert assaulter != null;
            if (assaulter.getAgility() * 3 > rand.nextInt(100)) {
                assaulter.attack(assaulty);
            } else {
                System.out.println(assaulter.getName() + " промахнулся!");
            }


            System.out.println(assaulter.getName() + " атаковал!");

            assaulter = assaulter == this.player ? this.monster : this.player;
            assaulty = assaulty == this.player ? this.monster : this.player;

            System.out.println("Остаток жизни " + this.player.getName() + ": " + this.player.healthPoints);
            System.out.println("Остаток жизни " + this.monster.getName() + ": " + this.monster.healthPoints);
            Thread.sleep(500);
        }
        Person winner = player.isDead() ? monster : player;
        System.out.println("Победил: " + winner.getName());

        if (winner == player) {
            player.earn(monster);
            player.boostXp(monster);
            System.out.println("Добавлен опыт! Новое значение: " + player.xp);

            System.out.println("Добавлено " + monster.getGold() + " злотых.");
            System.out.println("Всего злотых: " + player.getGold());
        }
    }
}
