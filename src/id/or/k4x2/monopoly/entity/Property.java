package id.or.k4x2.monopoly.entity;

public abstract class Property extends Tile {
    private String name;
    private int basePrice;
    private Player owner;

    /**
     * Property constructor
     * @param name Property name
     * @param basePrice base sell price
     */
    public Property(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.owner = null;
    }

    /**
     * Get rent price
     * @return rent price
     */
    public abstract int getRentPrice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void purchaseProperty(Player buyer) throws PurchaseException {
        // TODO implement
    }

    public static class PurchaseException extends Exception {
        private Error error;

        public PurchaseException(Error error) {
            this.error = error;
        }

        public Error getError() {
            return error;
        }

        public enum Error {
            PROPERTY_OWNED, INSUFFICIENT_FUND
        }
    }
}
