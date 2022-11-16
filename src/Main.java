import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] sea = new char[11][21];
        char[][] seaIA = new char[11][21];
        System.out.println("Bienvenido a HUNDIR LA FLOTA");
        System.out.println("Pulsa enter para empezar");
        sc.next();
        basicMethods.eraseScreen();
        basicMethods.fillSea(seaIA);
        basicMethods.fillSea(sea);
        basicMethods.showSeaIA(seaIA);
        basicMethods.showSea(sea);
        boats.placeBoats(sea);
    }
}