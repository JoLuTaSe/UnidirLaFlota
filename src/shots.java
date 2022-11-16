public class shots {
        public static void zonaGuerra(char[][] sea, char[][] seaIA){
            int turn = 0;
            while (!winUser(sea,seaIA)||!winIA(sea,seaIA)||turn>100){

                turn++;
            }
        }
}
