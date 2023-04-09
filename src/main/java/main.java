import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Shop myShop = new Shop();
        int maxCount = 10;
        int minCount = 1;

        for (int i = 0; i < 10; i++){
            String toyType = getToyType();
            Toy toy = new Toy(toyType, rnd.nextInt(maxCount-minCount)+minCount, getWight(toyType));
            myShop.addToy(toy);
        }



        myShop.getStok().forEach(e -> System.out.println(e.toString()));
        myShop.updateWeigth(1, myShop.getStok().get(2));
        System.out.println("---------------------");

        for (int j = 0; j < 10; j++) {
            myShop.game();
        }
        myShop.getStok().forEach(e -> System.out.println(e.toString()));
        System.out.println("---------------------");
        myShop.getWinerStok().forEach(e -> System.out.println(e.toString()));

        myShop.getWinnerToy();
        myShop.getWinnerToy();
        myShop.getWinerStok().forEach(e -> System.out.println(e.toString()));

        Repository.read();
    }



    private static String getToyType(){
        Random rnd = new Random();
        return String.valueOf(Toylist.values()[rnd.nextInt(Toylist.values().length)]);
    }

    private static int getWight(String toy){
        return switch (toy) {
            case "supercar" -> 10;
            case "robot" -> 20;
            case "car" -> 50;
            case "chess" -> 70;
            default  -> 80;
        };
    }
}
