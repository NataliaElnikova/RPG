import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class World extends Thread {
    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        out.println("Как тебя зовут?");
        String username = in.nextLine();
        out.println("Привет, " + username);
        Player player = new Player(username, 100, 12, 12, 1, 100);
        Seller seller = new Seller(100);
        while (true) {
            out.println("Куда вы хотите пойти?");
            MenuChoice[] menuChoices = MenuChoice.values();

            try {
                if (player.getGold() < Seller.ELIXIR_PRICE && player.isDead()) {
                    System.out.println("1. Денег нет, иди на завод");
                    if (in.nextInt() == 1) {
                        out.println("GAME OVER!");
                        break;
                    } else {
                        continue;
                    }
                } else {
                    for (MenuChoice menuChoice : menuChoices) {
                        System.out.println(menuChoice.getDisplayName());
                    }
                }
                int userChoice = in.nextInt();

                MenuChoice choice = MenuChoice.values()[userChoice - 1];
                switch (choice) {
                    case GO_SELLER:
                        TradeAction tradeAction = new TradeAction(player, seller);
                        tradeAction.doAction();
                        continue;
                    case GO_FOREST:
                        System.out.println(MenuChoice.GO_FOREST.getDisplayName());
                        FightAction fightAction = new FightAction(player);
                        fightAction.doAction();
                        continue;
                    case GO_AWAY:
                        System.out.println(MenuChoice.GO_AWAY.getDisplayName());
                        break;
                    default:
                        continue;
                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException | InterruptedException exception) {
                out.println("Wrong choice!");
                continue;
            }

            break;
        }
    }
}