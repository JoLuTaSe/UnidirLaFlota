import java.util.Scanner;

public class basicMethods {
    public static void eraseScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void fillSea(String[][] sea){
        for (int i = 0; i < sea.length; i++){
            for (int j = 0; j < 10;j++){
                if (i== 11-1 && j>0){
                    sea[i][j]= j + "  ";
                }else if (j==0 && i<11-1) {
                    sea[i][j] = (char)('A' + i) + "  ";
                }else if (j==0 && i == 11-1){
                    sea[i][j] = "   ";
                }else {
                    sea[i][j] = "~  ";
                }
            }
        }
        for (int i = 0; i < sea.length; i++){
            sea[i][10] = "       ";
        }
        for (int i = 0; i < sea.length; i++){
            for (int j = 12; j < sea[i].length;j++){
                if (i== sea.length-1 && j>12){
                    sea[i][j]= j + "  ";
                }else if (j==11 && i<sea.length-1) {
                    sea[i][j] = (char)('A' + i) + "  ";
                }else if (j==11 && i == sea.length-1){
                    sea[i][j] = "   ";
                }else {
                    sea[i][j] = "~  ";
                }
            }
        }
    }
    public static void showSea(String[][] sea){
        for (int i = 0; i < sea.length; i++){
            for (int j = 0; j < sea[i].length;j++){
                System.out.print(sea[i][j]);
            }
            System.out.println();
        }

    }
    public static String askCoordinateboat(String[][] sea, int longitud){
        Scanner sc = new Scanner(System.in);
        int coor1;
        int coor2;
        String coordinate;
        boolean valid;
        do {
            valid = true;
            System.out.println("Dime la coordenada que quieras colocar el barco");
            coordinate = sc.next();
            if (coordinate.length()<2){
                valid = false;
                System.out.println("error:1.1 las coordenadas introducidas no tienen el formato necesario");
            }
            if (valid && coordinate.charAt(0)<'A' || coordinate.charAt(0)>'J'){
                valid = false;
                System.out.println("error:1.2 la coordenada \"y\" esta mal expresada");
            }
            if (valid && Integer.valueOf(coordinate.substring(1))<0||Integer.valueOf(coordinate.substring(1))>9){
                valid = false;
                System.out.println("error:1.3 la coordenada \"x\" esta mal expresada");
            }
            if (valid && sea[((int)(coordinate.charAt(0))-65)][Integer.valueOf(coordinate.substring(1))].compareTo("~  ")!=0){
                valid= false;
                System.out.println("error:1.4 la cordenada ya ha sido expresada");
            }
            if (valid && longitud>1) {
                coor1 = coordinate.charAt(0)-65;
                coor2 = Integer.valueOf(coordinate.substring(1));
                valid = biggboat(coor1,coor2,sea,longitud);
            }

        }while (!valid);


        return coordinate;
    }

    public static boolean biggboat (int coor1, int coor2, String[][] sea, int longitud){
        boolean exit = true;
        boolean vValid = true;
        boolean hValid = true;
        if (((longitud - 1) + coor1) >= 11) {
            vValid = false;
        } else {
            for (int i = coor1; i < longitud+coor1; i++) {
                if (sea[i][coor2].compareTo("~  ") != 0) {
                    vValid = false;
                    break;
                }
            }
        }
        if (((longitud - 1) + coor2) >= 10) {
            hValid = false;
        } else {
            for (int j = 1; j < longitud; j++) {

                if (sea[coor1][coor2 + j].compareTo("~  ") != 0) {
                    hValid = false;
                    break;
                }
            }
        }
        if (!hValid&&!vValid){
            exit = false;
            System.out.println("Error:2.1, El barco ocupa mucho y no podrás colocarlo en esa posición");
        }
        return exit;
    }
}
