import java.util.Scanner;

public class boats {
    public static void placeBoats(String[][] sea){
        Scanner sc = new Scanner(System.in);
        int[] barcos = { 3, 3, 2, 1, 1};
        int[] coordenada = new int[2];
        for (int i = 0; i<barcos.length; i++) {
            System.out.println("Vamos a colocar barcos de longitud " + (i+1));
            for (int j = 0; j < barcos[i]; j++) {
                System.out.println("Coloca el barco de longitud " + (i+1) + ", número (" + (j+1) + "/" + barcos[i] + ")");
                coordenada = basicMethods.askCoordinate(sea);
                if(i==0){
                    sea[coordenada[0]][coordenada[1]] = "O  ";
                }else {
                    orientation(sea, coordenada, (i + 1));
                }
            }
        }
    }
    public static void orientation (String[][] sea, int[] coor, int longitud) {
        int coor1= coor[0];
        int coor2= coor[1];
        String hov;
        hov = comporveorientation(sea, coor1, coor2, longitud);
    }
    public static String comporveorientation(String[][] sea,int coor1,int coor2, int longitud){
        Scanner sc = new Scanner(System.in);
        String hov="";
        boolean vValid = true;
        boolean hValid = true;
        boolean hovValid = true;
        if (longitud-1+coor1>= sea.length){
            vValid = false;
        }else {
            for (int i = 1; i < longitud; i++){

                if (sea[i + coor1][coor2].compareTo("~  ") != 0) {
                    vValid = false;
                    break;
                }
            }
        }
        if (longitud-1+coor2>= sea[coor1].length){
            vValid = false;
        }else {
            for (int j = 1; j < longitud; j++){

                if (sea[coor1][coor2+j].compareTo("~  ") != 0) {
                    vValid = false;
                    break;
                }
            }
        }

        do {
            System.out.println("Como quieres colocarla horizontalmente(h) o verticalmente(v)");
            hov = sc.next();

        }while (hovValid);

        return hov;
    }
}
