public class Seller extends Person {
    static int ELIXIR_PRICE = 300;

    public Seller(int gold) {
        super("Baryiga", 0, -14,1,7000, gold);
    }

    public void sellElixir(Player player) {
        if (player.getGold()< ELIXIR_PRICE) {
            throw new NotEnoughMoneyException("Недостаточно злотых!");
        }

        player.spendMoney(ELIXIR_PRICE);
        this.gold += ELIXIR_PRICE;
    }
}
