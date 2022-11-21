import java.util.Scanner;

public class shots {
    public static void zonaGuerra(char[][] sea, char[][] seaIA, String mostrarIA) {
        int turn = 0;
        System.out.println(ANSI_RESET+ANSI_YELLOW+ANSI_BLUE_BACKGROUND+"¡¡¡¡¡¡¡¡ VAMOS A DISPARAR !!!!!!!"+ANSI_RESET);
        while (!winUser(seaIA) && !winIA(sea) && turn < 70) {
            if (mostrarIA.compareTo("0")==0) {
                basicMethods.showSeaIA(seaIA);
            }
            basicMethods.showSea(sea);
            System.out.println("                                                      " + ANSI_RESET + ANSI_BLACK_BACKGROUND + "Turno: " + turn + "de 70" + ANSI_RESET);
            System.out.println();
            System.out.println(ANSI_RESET+ANSI_GREEN+ANSI_BLACK_BACKGROUND+"Donde quieres disparar CAMARADA"+ANSI_RESET);
            shotUser(sea,seaIA);
            shotIA(sea,seaIA);
            turn++;
            basicMethods.eraseScreen();
        }
        if (winUser(seaIA)&&winIA(sea)){
            System.out.println(ANSI_RESET+ANSI_GREEN+ANSI_BLACK_BACKGROUND+"Las probabilidades de que pase esto son bajisimas pero habeis empatado mira:"+ANSI_RESET);
            basicMethods.showSeaIA(seaIA);
            basicMethods.showSea(sea);
        }else if (winUser(seaIA)){
            System.out.println(ANSI_RESET+ANSI_GREEN+ANSI_BLACK_BACKGROUND+"¡¡¡¡¡DIOSSSS ERES EL MEJORRR HAS GANADO A UN IA QUE DISPARA SIN BASARSE EN NADA CON RELACIÓN AL JUEGO!!!!!"+ANSI_RESET);
        }else {
            System.out.println(ANSI_RESET+ANSI_GREEN+ANSI_BLACK_BACKGROUND+"No me lo puedo creer te ha ganado un pc sin intención de ganarte"+ANSI_RESET);
        }

    }

    public static boolean winUser(char[][] seaIA) {
        int contacertShots = 0;
        for (int i = 0; i < seaIA.length; i++) {
            for (int j = 0; j < seaIA[i].length/2; j++) {
                if (seaIA[i][j] == 'X') {
                    contacertShots++;
                }
            }
        }
        if (contacertShots > 23) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean winIA(char[][] sea) {
        int contacertShots = 0;
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < (sea[i].length/2); j++) {
                if (sea[i][j] == 'X') {
                    contacertShots++;
                }
            }
        }
        if (contacertShots > 23) {
            return true;
        } else {
            return false;
        }
    }

    public static void shotUser(char[][] sea, char [][] seaIA){
        String coordenada= askCoordinateShot(sea);
        int coor1 = coordenada.charAt(0)-65;
        int coor2 = (Integer.valueOf(coordenada.substring(1)));
        if(Heat(seaIA, coor1, coor2)){
            sea[coor1][(coor2+11)] = 'X';
            seaIA[coor1][coor2] = 'X';
        }else {
            sea[coor1][coor2+11] = 'A';
            seaIA[coor1][coor2] = 'A';
        }

    }
    public static void shotIA(char[][] sea, char[][] seaIA){
        String coordenada= aleatoryCoordinateShot(seaIA);
        int coor1 = coordenada.charAt(0)-65;
        int coor2 = (Integer.valueOf(coordenada.substring(1)));
        if(Heat(sea, coor1, coor2)){
            seaIA[coor1][(coor2+11)] = 'X';
            sea[coor1][coor2] = 'X';
        }else {
            seaIA[coor1][coor2+11] = 'A';
            sea[coor1][coor2] = 'A';
        }

    }

    public static String askCoordinateShot(char[][] sea){
        Scanner sc = new Scanner(System.in);
        int coor1;
        int coor2;
        String coordinate;
        boolean valid;
        do {
            valid = true;
            System.out.println(ANSI_RESET+ANSI_GREEN+ANSI_BLACK_BACKGROUND+"Dime la coordenada que quieras Disparar"+ANSI_RESET);
            coordinate = sc.next();
            coordinate = coordinate.toUpperCase();
            if (coordinate.length()!=2){
                valid = false;
                System.out.println(ANSI_RESET+ANSI_RED+ANSI_BLACK_BACKGROUND+"error: 3.1 las coordenadas introducidas no tienen el formato necesario"+ANSI_RESET);
            }
            if (valid){
                if (coordinate.charAt(1)<'1' || coordinate.charAt(1)> '9' ){
                    valid = false;
                    System.out.println(ANSI_RESET+ANSI_RED+ANSI_BLACK_BACKGROUND+"error:3.4 el segundo valor no es un numero."+ANSI_RESET);
                }
            }
            if (valid && coordinate.charAt(0)<'A' || coordinate.charAt(0)>'J'){
                valid = false;
                System.out.println(ANSI_RESET+ANSI_RED+ANSI_BLACK_BACKGROUND+"error: 3.2 la coordenada \"y\" esta mal expresada"+ANSI_RESET);
            }
            if (valid ){

                if (Integer.valueOf(coordinate.substring(1))<1||Integer.valueOf(coordinate.substring(1))>9) {
                    valid = false;
                    System.out.println(ANSI_RESET+ANSI_RED+ANSI_BLACK_BACKGROUND+"error: 3.3 la coordenada \"x\" esta mal expresada"+ANSI_RESET);
                }
            }
            if (valid){
                coor1 =((int)(coordinate.charAt(0))-65);
                coor2 = Integer.valueOf(coordinate.substring(1))+11;
                if (sea[coor1][coor2] != '~') {
                    valid = false;
                    System.out.println(ANSI_RESET+ANSI_RED+ANSI_BLACK_BACKGROUND+"error: 3.4 la cordenada ya ha sido disparada"+ANSI_RESET);
                }
            }
        }while (!valid);


        return coordinate;
    }
    public static boolean Heat(char[][] sea, int coor1, int coor2){
        if (sea[coor1][coor2] != '~'){
            return true;
        }
        return false;
    }
    public static String aleatoryCoordinateShot(char[][] seaIA){
        Scanner sc = new Scanner(System.in);
        int coor1;
        int coor2;
        String coordinate;
        boolean valid;
        do {
            coordinate = "";
            valid = true;
            //System.out.println("Dime la coordenada que quieras colocar el barco");
            coordinate += (char)(Math.random()*('J'-'A')+'A');
            coordinate += (int)(Math.random()*9+1);
            if (valid){
                coor1 =((int)(coordinate.charAt(0))-65);
                coor2 = Integer.valueOf(coordinate.substring(1))+11;
                if (seaIA[coor1][coor2] != '~') {
                    valid = false;
                    //System.out.println("error: 3.4 la cordenada ya ha sido disparada");
                }
            }

        }while (!valid);


        return coordinate;
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
