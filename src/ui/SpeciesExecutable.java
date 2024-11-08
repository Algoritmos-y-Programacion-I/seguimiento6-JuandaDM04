package ui;

import java.util.Scanner;
import model.SpeciesController;

public class SpeciesExecutable {

    private Scanner reader;
    private SpeciesController speciesController;

    public static void main(String[] args) {
        SpeciesExecutable exe = new SpeciesExecutable();
        exe.showMainMenu();
    }

    public SpeciesExecutable() {
        reader = new Scanner(System.in);
        speciesController = new SpeciesController();
    }

    public void showMainMenu() {
        System.out.println("Welcome to Icesi Species");

        boolean stopFlag = false;
        while (!stopFlag) {
            System.out.println("\nType an option");
            System.out.println("1. Register a Species");
            System.out.println("2. Edit a Species");
            System.out.println("3. Delete a Species");
            System.out.println("4. Show a Species");
            System.out.println("0. Exit");

            int mainOption = reader.nextInt();
            reader.nextLine(); // Limpiar el buffer de entrada

            switch (mainOption) {
                case 1:
                    registerSpecies();
                    break;
                case 2:
                    editSpecies();
                    break;
                case 3:
                    deleteSpecies();
                    break;
                case 4:
                    showSpecies();
                    break;
                case 0:
                    System.out.println("Thanks for using our system");
                    stopFlag = true;
                    break;
                default:
                    System.out.println("You must type a valid option");
                    break;
            }
        }
    }

    public void registerSpecies() {
        System.out.println("Type the new Species' name: ");
        String name = reader.nextLine();

        System.out.println("Type the new Species' scientific name: ");
        String scientificName = reader.nextLine();

        System.out.println("Is it Flora or Fauna? (1 for Flora, 2 for Fauna): ");
        int type = reader.nextInt();
        reader.nextLine();

        boolean success;
        if (type == 1) {  // Flora
            System.out.println("Does it have flowers? (true/false): ");
            boolean hasFlowers = reader.nextBoolean();

            System.out.println("Does it have fruits? (true/false): ");
            boolean hasFruits = reader.nextBoolean();

            System.out.println("Type the maximum height (in meters): ");
            double maxHeight = reader.nextDouble();
            reader.nextLine();

            success = speciesController.registerFlora(name, scientificName, hasFlowers, hasFruits, maxHeight);

        } else if (type == 2) {  // Fauna
            System.out.println("Is it migratory? (true/false): ");
            boolean isMigratory = reader.nextBoolean();

            System.out.println("Type the maximum weight (in kg): ");
            double maxWeight = reader.nextDouble();
            reader.nextLine();

            success = speciesController.registerFauna(name, scientificName, isMigratory, maxWeight);

        } else {
            System.out.println("Invalid type selected.");
            success = false;
        }

        if (success) {
            System.out.println("Species registered successfully");
        } else {
            System.out.println("Error, Species couldn't be registered");
        }
    }

    public void editSpecies() {
        System.out.println("Which Species do you want to edit?");
        String query = speciesController.showSpeciesList();

        if (!query.equals("")) {
            System.out.println(query);

            System.out.println("Enter the number of the species you want to edit: ");
            int index = reader.nextInt() - 1;
            reader.nextLine();

            System.out.println("Editing options: ");
            System.out.println("1. Name");
            System.out.println("2. Scientific Name");
            System.out.println("3. Specific Attributes (flowers, fruits, height for Flora / migratory, weight for Fauna)");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter the new name: ");
                    String newName = reader.nextLine();
                    speciesController.editSpeciesName(index, newName);
                    break;
                case 2:
                    System.out.println("Enter the new scientific name: ");
                    String newSciName = reader.nextLine();
                    speciesController.editSpeciesScientificName(index, newSciName);
                    break;
                case 3:
                    speciesController.editSpeciesSpecificAttributes(index, reader);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } else {
            System.out.println("There aren't any species registered yet");
        }
    }

    public void deleteSpecies() {
        System.out.println("Which Species do you want to delete?");
        String query = speciesController.showSpeciesList();

        if (!query.equals("")) {
            System.out.println(query);

            System.out.println("Enter the number of the species you want to delete: ");
            int index = reader.nextInt() - 1;
            reader.nextLine();

            if (speciesController.deleteSpecies(index)) {
                System.out.println("Species deleted successfully");
            } else {
                System.out.println("Error, Species couldn't be deleted");
            }
        } else {
            System.out.println("There aren't any species registered yet");
        }
    }

    public void showSpecies() {
        System.out.println("Which Species do you want to review?");
        String query = speciesController.showSpeciesList();

        if (!query.equals("")) {
            System.out.println(query);

            System.out.println("Enter the number of the species you want to view: ");
            int index = reader.nextInt() - 1;
            reader.nextLine();

            String speciesInfo = speciesController.getSpeciesInfo(index);
            System.out.println(speciesInfo);
        } else {
            System.out.println("There aren't any species registered yet");
        }
    }
}
