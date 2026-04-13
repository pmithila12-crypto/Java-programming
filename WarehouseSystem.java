import java.util.Scanner;

class Item {
    String name;
    int quantity;
    int reorderLevel;

    Item(String name, int quantity, int reorderLevel) {
        this.name = name;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }

    void display() {
        System.out.println("Item: " + name + ", Quantity: " + quantity + ", Reorder Level: " + reorderLevel);
    }

    void checkReorder() {
        if (quantity <= reorderLevel) {
            System.out.println(" Reorder needed for: " + name);
        }
    }
}

public class WarehouseSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Item[] inventory = new Item[10]; 
        int count = 0;
        int choice;

        do {
            System.out.println("\n--- Warehouse Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Check Low Stock");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    if (count < inventory.length) {
                        System.out.print("Enter item name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();

                        System.out.print("Enter reorder level: ");
                        int reorder = sc.nextInt();

                        inventory[count] = new Item(name, qty, reorder);
                        count++;

                        System.out.println(" Item added successfully!");
                    } else {
                        System.out.println("Inventory full!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Inventory List ---");
                    for (int i = 0; i < count; i++) {
                        inventory[i].display();
                    }
                    break;

                case 3:
                    System.out.println("\n--- Low Stock Items ---");
                    for (int i = 0; i < count; i++) {
                        inventory[i].checkReorder();
                    }
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}