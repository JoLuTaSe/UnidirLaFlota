import java.util.Scanner;

public class boats {

    public static void placeBoats(char[][] sea){
        int[] barcos = { 3, 3, 2, 1, 1};
        int coor1;
        int coor2;
        String coordenada;
        for (int i = barcos.length-1; i>=0; i--) {
            for (int j = 0; j < barcos[i]; j++) {
                System.out.println(ANSI_RESET+ANSI_GREEN+ANSI_BLACK_BACKGROUND+"Coloca el barco de longitud " + (i+1) + ", número (" + (j+1) + "/" + barcos[i] + ")(la coordenada dada sera la parte de la izquierda en caso de colocarlo en horizontal y en en la parte de arriba en caso de vertical"+ANSI_RESET);
                coordenada = basicMethods.askCoordinateboat(sea, (i+1));
                coor1 = coordenada.charAt(0)-65;
                coor2 = Integer.valueOf(coordenada.substring(1));
                if(i==0){
                    sea[coor1][coor2] = 'O';
                }else {
                    orientation(sea, coor1, coor2, (i + 1));
                }
                basicMethods.eraseScreen();
                basicMethods.showSea(sea);
            }
        }
    }






    public static void orientation (char[][] sea, int coor1, int coor2, int longitud) {
        String hov;
        hov = comproveorientation(sea, coor1, coor2, longitud);
        if (hov.equals("h")){
            for (int i= coor2; i<longitud+coor2; i++){
                sea[coor1][i]= 'O';
            }
        }
        if (hov.equals("v")){
            for (int j = coor1; j<longitud+coor1;j++){
                sea[j][coor2] = 'O';
            }
        }
    }









    public static String comproveorientation(char[][] sea,int coor1,int coor2 , int longitud){
        Scanner sc = new Scanner(System.in);
        String hov;
        boolean vValid = true;
        boolean hValid = true;
        boolean hovValid;
        if (((longitud - 1) + coor1) >= 11) {
            vValid = false;
        } else {
            for (int i = coor1; i < longitud + coor1; i++) {
                vValid = spaceBoatBeQuaiet(sea,i,coor2);
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
                hValid = spaceBoatBeQuaiet(sea,coor1,coor2+j);
                if (sea[coor1][coor2 + j] != '~') {
                    hValid = false;
                }
                if (!hValid){
                    break;
                }
            }
        }

        do {
            hovValid = true;
            System.out.println(ANSI_RESET+ANSI_YELLOW+ANSI_BLACK_BACKGROUND+"Como quieres colocarla horizontalmente(h) o verticalmente(v)"+ANSI_RESET);
            hov = sc.next();
            hov = hov.toLowerCase();
            if (hov.compareTo("h")!=0 && hov.compareTo("v")!=0){
                hovValid = false;
                System.out.println(ANSI_RESET+ANSI_RED+ANSI_BLACK_BACKGROUND+"Error: 2.1, valores no conocidos."+ANSI_RESET);
            }
            if (hov.equals("v") && !vValid){
                hovValid = false;
                System.out.println(ANSI_RESET+ANSI_RED+ANSI_BLACK_BACKGROUND+"Error: 2.2, es imposible colocar verticalmente en esas coordenadas"+ANSI_RESET);
            }
            if (hov.equals("h") && !hValid){
                hovValid = false;
                System.out.println(ANSI_RESET+ANSI_RED+ANSI_BLACK_BACKGROUND+"Error: 2.3, es imposible colocar horizontalmente en esas coordenadas"+ANSI_RESET);
            }
        }while (!hovValid);

        return hov.toLowerCase();
    }
    public static boolean spaceBoatBeQuaiet (char[][] sea, int coor1 , int coor2){
        boolean valid = true;
        if ((coor1+1) < (sea.length-1)){
            if (sea[coor1 + 1][coor2] != '~') {
                valid = false;
                //System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.5 posible colision con el barco de abajo deja por lo menos un espacio de agua" + ANSI_RESET);
            }
        }
        if ((coor2 + 1) < (sea[0].length/2)){
            if (sea[coor1][coor2+1] != '~') {
                valid = false;
                //System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.6 posible colision con el barco de la derecha deja por lo menos un espacio de agua" + ANSI_RESET);
            }
        }
        if ((coor1-1)>=0){
            if (sea[coor1 - 1 ][coor2] != '~') {
                valid = false;
                //System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.7 posible colision con el barco de arriba deja por lo menos un espacio de agua" + ANSI_RESET);
            }
        }
        if ((coor2-1)>=1){
            if (sea[coor1][coor2-1] != '~') {
                valid = false;
                //System.out.println(ANSI_RESET + ANSI_RED + ANSI_BLACK_BACKGROUND + "error:1.8 posible colision con el barco de la izquierda deja por lo menos un espacio de agua" + ANSI_RESET);
            }
        }


        return valid;
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
