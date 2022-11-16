import java.util.Scanner;

public class boats {
    public static void placeBoats(char[][] sea){
        int[] barcos = { 3, 3, 2, 1, 1};
        int coor1;
        int coor2;
        String coordenada;
        for (int i = 0; i<barcos.length; i++) {
            for (int j = 0; j < barcos[i]; j++) {
                System.out.println("Coloca el barco de longitud " + (i+1) + ", número (" + (j+1) + "/" + barcos[i] + ")(la coordenada dada sera la parte de la izquierda en caso de colocarlo en horizontal y en en la parte de arriba en caso de vertical");
                coordenada = basicMethods.askCoordinateboat(sea, (i+1));
                coor1 = coordenada.charAt(0)-65;
                coor2 = Integer.valueOf(coordenada.substring(1));
                if(i==0){
                    sea[coor1][coor2] = 'O';
                }else {
                    orientation(sea, coor1, coor2, (i + 1));
                }
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
        if (longitud-1+coor1>= 11){
            vValid = false;
        }else {
            for (int i = 1; i < longitud; i++){

                if (sea[i + coor1][coor2]!='~') {
                    vValid = false;
                    break;
                }
            }
        }
        if (longitud-1+coor2>= 10){
            hValid = false;
        }else {
            for (int j = 1; j < longitud; j++){

                if (sea[coor1][coor2+j]!='~') {
                    hValid = false;
                    break;
                }
            }
        }

        do {
            hovValid = true;
            System.out.println("Como quieres colocarla horizontalmente(h) o verticalmente(v)");
            hov = sc.next();
            if (hov.compareTo("h")!=0 && hov.compareTo("v")!=0){
                hovValid = false;
                System.out.println("Error: 2.1, valores no conocidos.");
            }
            if (hov.equals("v") && !vValid){
                hovValid = false;
                System.out.println("Error: 2.2, es imposible colocar verticalmente en esas coordenadas");
            }
            if (hov.equals("h") && !hValid){
                hovValid = false;
                System.out.println("Error: 2.3, es imposible colocar horizontalmente en esas coordenadas");
            }
        }while (!hovValid);

        return hov;
    }
}
