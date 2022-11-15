import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] sea = new String[11][21];
        String[][] seaIA = new String[11][21];
        System.out.println("Bienvenido a HUNDIR LA FLOTA");
        System.out.println("Pulsa enter para empezar");
        sc.next();
        basicMethods.eraseScreen();
        basicMethods.fillSea(sea);
        basicMethods.fillSea(seaIA);
        basicMethods.showSea(sea);
        boats.placeBoats(sea);
    }
}