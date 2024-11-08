package model;

public class Flora extends Species {

    private boolean hasFlowers;
    private boolean hasFruits;
    private double maxHeight;

    public Flora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
        super(name, scientificName);
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maxHeight = maxHeight;
    }

    public boolean hasFlowers() {
        return hasFlowers;
    }

    public void setHasFlowers(boolean hasFlowers) {
        this.hasFlowers = hasFlowers;
    }

    public boolean hasFruits() {
        return hasFruits;
    }

    public void setHasFruits(boolean hasFruits) {
        this.hasFruits = hasFruits;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public String toString() {
        return super.toString() + ", Has Flowers: " + hasFlowers + ", Has Fruits: " + hasFruits + ", Max Height: " + maxHeight + " meters";
    }
}
