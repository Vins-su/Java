import java.io.*;
import java.util.*;

public class Crudex {

    static ArrayList<String> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE = "data.txt";

    public static void main(String[] args) {
        loadFile();
        int choice;

        do {
            System.out.println("\n1 Add  \n2 View  \n3 Update  \n4 Delete  \n5 Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) add();
            else if (choice == 2) view();
            else if (choice == 3) update();
            else if (choice == 4) delete();
            else if (choice == 5) saveFile();

        } while (choice != 5);
    }

    
    static void add() {
        System.out.print("Enter text: ");
        list.add(sc.nextLine());
    }

    
    static void view() {
        for (int i = 0; i < list.size(); i++)
            System.out.println((i + 1) + ". " + list.get(i));
    }

    
    static void update() {
        view();
        System.out.print("Number to update: ");
        int i = sc.nextInt() - 1;
        sc.nextLine();

        System.out.print("New text: ");
        list.set(i, sc.nextLine());
    }

    
    static void delete() {
        view();
        System.out.print("Number to delete: ");
        list.remove(sc.nextInt() - 1);
    }

    
    static void saveFile() {
        try (PrintWriter pw = new PrintWriter(FILE)) {
            for (String s : list) pw.println(s);
        } catch (Exception e) {
            System.out.println("File error");
        }
    }

    
    static void loadFile() {
        try (Scanner f = new Scanner(new File(FILE))) {
            while (f.hasNextLine()) list.add(f.nextLine());
        } catch (Exception e) {
            
        }
    }
}