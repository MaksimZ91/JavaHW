import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Shop myShop = new Shop();
        int maxCount = 10;
        int minCount = 1;

        System.out.println("Create toys --> ");
        for (int i = 0; i < 10; i++){
            String toyType = getToyType();
            Toy toy = new Toy(toyType, rnd.nextInt(maxCount-minCount)+minCount, getWight(toyType));
            myShop.addToy(toy);
        }

        System.out.println("Игрушки на основном складе: ");
        myShop.getStok().forEach(e -> System.out.println(e.toString()));
        System.out.println("Меняем вес у 3-тий игрушки: ");
        myShop.updateWeigth(20, myShop.getStok().get(2));
        System.out.println(myShop.getStok().get(2).toString());
        System.out.println("Разыгрываем три игрушки");
        for (int j = 0; j < 3; j++) {
            myShop.game();
        }
        System.out.println("Игрушки на основном складе после розыгрыша: ");
        myShop.getStok().forEach(e -> System.out.println(e.toString()));
        System.out.println("Игрушки на складе для выдачи: ");
        myShop.getWinerStok().forEach(e -> System.out.println(e.toString()));
        System.out.println("Выдаем две игрушки: ");
        myShop.getWinnerToy();
        myShop.getWinnerToy();
        System.out.println("Игрушки на складе для выдачи после выдачи игрушкек: ");
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