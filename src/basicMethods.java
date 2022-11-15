import java.util.Scanner;

public class basicMethods {
    public static void eraseScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void fillSea(String[][] sea){
        for (int i = 0; i < sea.length; i++){
            for (int j = 0; j < sea[i].length;j++){
                if (i== sea.length-1 && j>0){
                    sea[i][j]= j + "  ";
                }else if (j==0 && i<sea.length-1) {
                    sea[i][j] = (char)('A' + i) + "  ";
                }else if (j==0 && i == sea.length-1){
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
    public static int[] askCoordinateboat(String[][] sea, int longitud){
        Scanner sc = new Scanner(System.in);
        int[] coordenada = new int[2];
        int coor1=0;
        int coor2=0;
        boolean vValid = true;
        boolean hValid = true;
        String coordinate;
        boolean valid;
        do {
            valid = true;
            System.out.println("Dime la coordenada que quieras disparar");
            coordinate = sc.next();
            if (coordinate.length()!=2){
                valid = false;
                System.out.println("error:1.1 las coordenadas introducidas no tienen el formato necesario");
            }
            if (coordinate.charAt(0)<'A' || coordinate.charAt(0)>'J'){
                valid = false;
                System.out.println("error:1.2 la coordenada \"y\" esta mal expresada");
            }
            if ((int)(coordinate.charAt(1))>0||(int)(coordinate.charAt(1))<10){
                valid = false;
                System.out.println("error:1.3 la coordenada \"x\" esta mal expresada");
            }
            if (coordinate.length() == 2 && sea[((int)(coordinate.charAt(0))-65)][coordinate.charAt(1)].compareTo("~  ")!=0){
                valid= false;
                System.out.println("error:1.4 la cordenada ya ha sido expresada");
            }
            if (valid && longitud>1) {
                coor1 = coordinate.charAt(0)-65;
                coor2 = coordinate.charAt(1);
                if (longitud - 1 + coor1 >= sea.length) {
                    vValid = false;
                } else {
                    for (int i = 1; i < longitud; i++) {

                        if (sea[i + coor1][coor2].compareTo("~  ") != 0) {
                            vValid = false;
                            break;
                        }
                    }
                }
                if (longitud - 1 + coor2 >= sea[coor1].length) {
                    vValid = false;
                } else {
                    for (int j = 1; j < longitud; j++) {

                        if (sea[coor1][coor2 + j].compareTo("~  ") != 0) {
                            hValid = false;
                            break;
                        }
                    }
                }
                if (!hValid&&!vValid){
                    System.out.println("Error:2.1, El barco ocupa mucho y no podrás colocarlo en esa posición");
                }
            }

        }while (!valid);

        coordenada[0] = coor1;
        coordenada[1] = coor2;
        return coordenada;
    }
}
