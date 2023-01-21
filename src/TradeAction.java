import java.util.Scanner;

public class TradeAction implements Actionable {
    private final Player player;
    private final Seller seller;

    @Override
    public void doAction() {
        System.out.println("Купить зелье за three hundred bucks?");
        System.out.println(" + Купить");
        System.out.println(" - Да не");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("+")) {
            try {
                this.seller.sellElixir(this.player);
                this.player.heal();
                System.out.println("Здоровье восстановлено! Осталось " + player.gold + " злотых");
            }
            catch (NotEnoughMoneyException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    TradeAction(Player player, Seller seller) {
        this.player = player;
        this.seller = seller;

    }
}
