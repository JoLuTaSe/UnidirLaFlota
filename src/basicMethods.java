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
    public static int[] askCoordinate(String[][] sea){
        Scanner sc = new Scanner(System.in);
        int[] coordenada = new int[2];
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

        }while (!valid);

        coordenada[0] = ((int)(coordinate.charAt(0))-65);
        coordenada[1] = (int)(coordinate.charAt(1));
        return coordenada;
    }
}
