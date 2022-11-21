import java.util.Scanner;

public class basicMethods {


    public static void eraseScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void fillSea(char[][] sea) {
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < (sea[i].length / 2); j++) {
                if (i == (sea[i].length / 2) && j > 0) {
                    sea[i][j] = Integer.toString(j).charAt(0);
                } else if (j == 0 && i < (sea[i].length / 2)) {
                    sea[i][j] = (char) ('A' + i);
                } else if (j == 0 && i == (sea[i].length / 2)) {
                    sea[i][j] = ' ';
                } else {
                    sea[i][j] = '~';
                }
            }
        }
        for (int i = 0; i < sea.length; i++) {
            sea[i][10] = ' ';
        }
        for (int i = 0; i < sea.length; i++) {
            for (int j = 11, x = 0; j < sea[i].length; j++, x++) {
                if (i == sea.length - 1 && j > 11) {
                    sea[i][j] = Integer.toString(x).charAt(0);
                } else if (j == 11 && i < sea.length - 1) {
                    sea[i][j] = (char) ('A' + i);
                } else if (j == 11 && i == sea.length - 1) {
                    sea[i][j] = ' ';
                } else {
                    sea[i][j] = '~';
                }
            }
        }
    }


    public static void showSea(char[][] sea) {
        System.out.println();
        System.out.println();
        System.out.println(ANSI_RESET + ANSI_GREEN + ANSI_BLACK_BACKGROUND + "Mapa-Usuario" + ANSI_RESET + "                            " + ANSI_GREEN + ANSI_BLACK_BACKGROUND + "Mapa-Disparo-Usuario" + ANSI_RESET);
        System.out.println();
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[i].length; j++) {
                if ((j == 11 && i < sea.length - 1) || (j == 0 && i < (sea[i].length / 2))) {
                    System.out.print(ANSI_RESET + ANSI_BLACK_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                } else if ((j == 11 && i == sea.length - 1) || (j == 0 && i == (sea[i].length / 2))) {
                    System.out.print(ANSI_RESET + ANSI_BLACK_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                } else if ((i == (sea[i].length / 2) && (j > 0 && j < 10)) || (i == sea.length - 1 && j > 11)) {
                    System.out.print(ANSI_RESET + ANSI_BLACK_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                } else if (j == 10) {
                    System.out.print(sea[i][j] + "      ");
                } else {
                    if (sea[i][j]=='~') {
                        System.out.print(ANSI_RESET + ANSI_CYAN_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                    }else if(sea[i][j]=='O'){
                        System.out.print(ANSI_RESET + ANSI_WHITE_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                    }else if (sea[i][j]=='X'){
                        System.out.print(ANSI_RESET + ANSI_RED_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                    }else{
                        System.out.print(ANSI_RESET + ANSI_CYAN_BACKGROUND + ANSI_BLACK+ " " + sea[i][j] + " " + ANSI_RESET);
                    }
                }
            }
            System.out.println();
        }
        System.out.println();

    }


    public static void showSeaIA(char[][] sea) {
        System.out.println();
        System.out.println(ANSI_RESET + ANSI_GREEN + ANSI_BLACK_BACKGROUND + "Mapa-IA" + ANSI_RESET + "                                 " + ANSI_GREEN + ANSI_BLACK_BACKGROUND + "Mapa-Disparo-IA" + ANSI_RESET);
        System.out.println();
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[i].length; j++) {
                if ((j == 11 && i < sea.length - 1) || (j == 0 && i < (sea[i].length / 2))) {
                    System.out.print(ANSI_RESET + ANSI_BLACK_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                } else if ((j == 11 && i == sea.length - 1) || (j == 0 && i == (sea[i].length / 2))) {
                    System.out.print(ANSI_RESET + ANSI_BLACK_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                } else if ((i == (sea[i].length / 2) && (j > 0 && j < 10)) || (i == sea.length - 1 && j > 11)) {
                    System.out.print(ANSI_RESET + ANSI_BLACK_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                } else if (j == 10) {
                    System.out.print(sea[i][j] + "      ");
                } else {
                    if (sea[i][j]=='~') {
                        System.out.print(ANSI_RESET + ANSI_CYAN_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                    }else if(sea[i][j]=='O'){
                        System.out.print(ANSI_RESET + ANSI_WHITE_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                    }else if (sea[i][j]=='X'){
                        System.out.print(ANSI_RESET + ANSI_RED_BACKGROUND + " " + sea[i][j] + " " + ANSI_RESET);
                    }else{
                        System.out.print(ANSI_RESET + ANSI_CYAN_BACKGROUND + ANSI_BLACK+ " " + sea[i][j] + " " + ANSI_RESET);
                    }
                }
            }
            System.out.println();
        }

    }


    public static String askCoordinateboat(char[][] sea, int longitud) {
        Scanner sc = new Scanner(System.in);
        int coor1;
        int coor2;
        String coordinate;
        boolean valid;
        do {
            valid = true;
            System.out.println(ANSI_RESET + ANSI_GREEN + ANSI_BLACK_BACKGROUND + "Dime la coordenada que quieras colocar el barco" + ANSI_RESET);
            coordinate = sc.next();
            coordinate = coordinate.toUpperCase();
            if (coordinate.length() != 2) {
                valid = false;
                System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.1 las coordenadas introducidas no tienen el formato necesario" + ANSI_RESET);
            }
            if (valid) {
                if (coordinate.charAt(1) < '1' || coordinate.charAt(1) > '9') {
                    valid = false;
                    System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.5 el segundo valor no es un numero." + ANSI_RESET);
                }
            }
            if (valid && coordinate.charAt(0) < 'A' || coordinate.charAt(0) > 'J') {
                valid = false;
                System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.2 la coordenada \"y\" esta mal expresada" + ANSI_RESET);
            }
            if (valid) {
                if (Integer.valueOf(coordinate.substring(1)) < 1 || Integer.valueOf(coordinate.substring(1)) > 9) {
                    valid = false;
                    System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.3 la coordenada \"x\" esta mal expresada" + ANSI_RESET);
                }
            }
            if (valid) {
                if (sea[((int) (coordinate.charAt(0)) - 65)][Integer.valueOf(coordinate.substring(1))] != '~') {
                    valid = false;
                    System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.4 la cordenada ya ha sido expresada" + ANSI_RESET);
                }
            }
            if (valid){
                coor1 = coordinate.charAt(0) - 65;
                coor2 = Integer.valueOf(coordinate.substring(1));
                valid = spaceBoat(sea, coor1 , coor2);
            }
            if (valid && longitud > 1) {
                coor1 = coordinate.charAt(0) - 65;
                coor2 = Integer.valueOf(coordinate.substring(1));
                valid = biggboat(coor1, coor2, sea, longitud);
            }

        } while (!valid);


        return coordinate;
    }

    public static boolean spaceBoat (char[][] sea, int coor1 , int coor2){
        boolean valid = true;
        if ((coor1+1) < (sea.length-1)){
            if (sea[coor1 + 1][coor2] != '~') {
                valid = false;
                System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.5 posible colision con el barco de abajo deja por lo menos un espacio de agua" + ANSI_RESET);
            }
        }
        if ((coor2 + 1) < (sea[0].length/2)){
            if (sea[coor1][coor2+1] != '~') {
                valid = false;
                System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.6 posible colision con el barco de la derecha deja por lo menos un espacio de agua" + ANSI_RESET);
            }
        }
        if ((coor1-1)>=0){
            if (sea[coor1 - 1 ][coor2] != '~') {
                valid = false;
                System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.7 posible colision con el barco de arriba deja por lo menos un espacio de agua" + ANSI_RESET);
            }
        }
        if ((coor2-1)>=1){
            if (sea[coor1][coor2-1] != '~') {
                valid = false;
                System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.8 posible colision con el barco de la izquierda deja por lo menos un espacio de agua" + ANSI_RESET);
            }
        }


        return valid;
    }

    public static boolean biggboat(int coor1, int coor2, char[][] sea, int longitud) {
        boolean exit = true;
        boolean vValid = true;
        boolean hValid = true;
        if (((longitud - 1) + coor1) >= 11) {
            vValid = false;
        } else {
            for (int i = coor1; i < longitud + coor1; i++) {
                vValid = boats.spaceBoatBeQuaiet(sea,i,coor2);
                if (sea[i][coor2] != '~') {
                    vValid = false;
                }
                if (!vValid){
                    break;
                }
            }
        }
        if (((longitud - 1) + coor2) >= 10) {
            hValid = false;
        } else {
            for (int j = 1; j < longitud; j++) {
                hValid = boats.spaceBoatBeQuaiet(sea,coor1,coor2+j);
                if (sea[coor1][coor2 + j] != '~') {
                    hValid = false;
                }
                if (!hValid){
                 break;
                }
            }
        }
        if (!hValid && !vValid) {
            exit = false;
            System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "Error:2.1, El barco ocupa mucho y no podrás colocarlo en esa posición" + ANSI_RESET);
        }
        return exit;
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
