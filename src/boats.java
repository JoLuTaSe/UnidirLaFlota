import java.util.Scanner;

public class boats {
    public static void placeBoats(String[][] sea){
        Scanner sc = new Scanner(System.in);
        int[] barcos = { 3, 3, 2, 1, 1};
        int[] coordenada = new int[2];
        for (int i = 0; i<barcos.length; i++) {
            System.out.println("Vamos a colocar barcos de longitud " + (i+1));
            for (int j = 0; j < barcos[i]; j++) {
                System.out.println("Coloca el barco de longitud " + (i+1) + ", número (" + (j+1) + "/" + barcos[i] + ")(la coordenada dada sera la parte de la izquierda en caso de colocarlo en horizontal y en en la parte de arriba en caso de vertical");
                coordenada = basicMethods.askCoordinateboat(sea, (i+1));
                if(i==0){
                    sea[coordenada[0]][coordenada[1]] = "O  ";
                }else {
                    orientation(sea, coordenada, (i + 1));
                }
            }
        }
    }
    public static void orientation (String[][] sea, int[] coor, int longitud) {
        String hov;
        hov = comporveorientation(sea, coor, longitud);
    }
    public static String comporveorientation(String[][] sea,int[] coor, int longitud){
        Scanner sc = new Scanner(System.in);
        String hov="";
        int coor1 = coor[0];
        int coor2 = coor[1];
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
                    hValid = false;
                    break;
                }
            }
        }

        do {
            System.out.println("Como quieres colocarla horizontalmente(h) o verticalmente(v)");
            hov = sc.next();
            if (hov.compareTo("h")!=0 || hov.compareTo("v")!=0){
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
