package model;

public abstract class Species {

    private String name;
    private String scientificName;

    public Species(String name, String scientificName) {
        this.name = name;
        this.scientificName = scientificName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Scientific Name: " + scientificName;
    }
}
