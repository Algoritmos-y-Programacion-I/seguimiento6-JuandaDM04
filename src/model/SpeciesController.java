package model;

import java.util.Scanner;

public class SpeciesController {

    private Species[] species;

    public SpeciesController() {
        this.species = new Species[80]; // Capacidad de 80 especies
    }

    // Registra una nueva especie de flora
    public boolean registerFlora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                species[i] = new Flora(name, scientificName, hasFlowers, hasFruits, maxHeight);
                return true;
            }
        }
        return false;
    }

    // Registra una nueva especie de fauna
    public boolean registerFauna(String name, String scientificName, boolean isMigratory, double maxWeight) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                species[i] = new Fauna(name, scientificName, isMigratory, maxWeight);
                return true;
            }
        }
        return false;
    }

    // Muestra la lista de especies registradas
    public String showSpeciesList() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < species.length; i++) {
            if (species[i] != null) {
                msg.append("\n").append(i + 1).append(". ").append(species[i].getName());
            }
        }
        return msg.toString();
    }

    // Elimina una especie
    public boolean deleteSpecies(int index) {
        if (index >= 0 && index < species.length && species[index] != null) {
            species[index] = null;
            return true;
        }
        return false;
    }

    // Edita el nombre de una especie
    public void editSpeciesName(int index, String newName) {
        if (species[index] != null) {
            species[index].setName(newName);
        }
    }

    // Edita el nombre científico de una especie
    public void editSpeciesScientificName(int index, String newScientificName) {
        if (species[index] != null) {
            species[index].setScientificName(newScientificName);
        }
    }

    // Edita los atributos específicos de una especie
    public void editSpeciesSpecificAttributes(int index, Scanner reader) {
        if (species[index] instanceof Flora) {
            Flora flora = (Flora) species[index];
            System.out.println("Does it have flowers? (true/false): ");
            boolean hasFlowers = reader.nextBoolean();
            System.out.println("Does it have fruits? (true/false): ");
            boolean hasFruits = reader.nextBoolean();
            System.out.println("Type the maximum height: ");
            double maxHeight = reader.nextDouble();
            flora.setHasFlowers(hasFlowers);
            flora.setHasFruits(hasFruits);
            flora.setMaxHeight(maxHeight);
        } else if (species[index] instanceof Fauna) {
            Fauna fauna = (Fauna) species[index];
            System.out.println("Is it migratory? (true/false): ");
            boolean isMigratory = reader.nextBoolean();
            System.out.println("Type the maximum weight: ");
            double maxWeight = reader.nextDouble();
            fauna.setMigratory(isMigratory);
            fauna.setMaxWeight(maxWeight);
        }
    }

    // Obtiene la información de una especie específica
    public String getSpeciesInfo(int index) {
        if (species[index] != null) {
            return species[index].toString();
        }
        return "Species not found.";
    }
}
