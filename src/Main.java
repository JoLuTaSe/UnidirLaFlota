import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mostrarIa;
        boolean answr;
        int firstCount = 0;
        char[][] sea = new char[11][21];
        char[][] seaIA = new char[11][21];
        System.out.println(ANSI_RESET+ANSI_PURPLE+ANSI_BLACK_BACKGROUND+"¡¡¡¡Bienvenido a HUNDIR LA FLOTA!!!!"+ANSI_RESET);
        System.out.println(ANSI_RESET+ANSI_GREEN+ANSI_BLACK_BACKGROUND+"Pulsa enter para empezar"+ANSI_RESET);
        sc.next();
        basicMethods.eraseScreen();
        System.out.println(ANSI_RESET+ANSI_GREEN+ANSI_BLACK_BACKGROUND+"Quieres mostrar el mapa de la IA o no? (escribe (0) para mostrarla o escribe (1) para que no aparezca el mapa"+ANSI_RESET);
        do {
            answr=true;
            mostrarIa = sc.next();
            if (mostrarIa.compareTo("1")!=0 && mostrarIa.compareTo("0")!=0){
                answr=false;
                if (firstCount==0) {
                    System.out.println(ANSI_RESET+ANSI_PURPLE+ANSI_BLACK_BACKGROUND+"Madre mia empezamos bien, que ni darle al 1 o al 0 sabes."+ANSI_RESET);
                    firstCount++;
                }
                System.out.println(ANSI_RESET+ANSI_RED+ANSI_BLACK_BACKGROUND+"error:0.1 valor no valido"+ANSI_RESET);
                System.out.println(ANSI_RESET+ANSI_GREEN+ANSI_BLACK_BACKGROUND+"Dame un 0 para mostrar a la IA o un 1 para no mostrarla"+ANSI_RESET);
            }
        }while (!answr);
        if (mostrarIa.compareTo("0")==0) {
            basicMethods.fillSea(seaIA);
            basicMethods.fillSea(sea);
            basicMethods.showSeaIA(seaIA);
            basicMethods.showSea(sea);
            boats.placeBoats(sea);
            basicMethods.eraseScreen();
            IA.placeBoatsIA(seaIA);
            basicMethods.eraseScreen();
            shots.zonaGuerra(sea, seaIA, mostrarIa);
        } else {
            basicMethods.fillSea(seaIA);
            basicMethods.fillSea(sea);
            basicMethods.showSea(sea);
            boats.placeBoats(sea);
            basicMethods.eraseScreen();
            IA.placeBoatsIA(seaIA);
            basicMethods.eraseScreen();
            shots.zonaGuerra(sea, seaIA, mostrarIa);
        }
    }
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
}