import java.util.ArrayList;
import java.util.Random;

public class Shop {

    private Storage stok;


    public Shop() {
        this.stok = new Storage();
    }

    void addToy(Toy toy){
        stok.addCargo(toy);
    }

    public ArrayList<Toy> getStok() {
        return stok.getCargo();
    }

    public ArrayList<Toy> getWinerStok() {
        return stok.getWinerCargo();
    }

    public void getWinnerToy(){ //Метод выдачи игрушки со склада
        stok.getWinnerToy();
    }


    public void updateWeigth(int newWeigth, Toy toy){  //Обновление веса игрушки.
        ArrayList<Toy> toys = stok.getCargo();
        int index = toys.indexOf(toy);
        Toy currentToy = toys.get(index);
        currentToy.setWeight(newWeigth);
    }

    public void game(){    //Метод розыграша игрушек
        if (stok.getCargo().isEmpty()){ //Если склад не пуст.
            System.out.println("Склад пуст!");
            return;
        }

       int sumWeigth = stok.getSumWightToys(); //Получаем общий вес всхе игрушек
       int rnd = new Random().nextInt(sumWeigth); //Генерируем рандомное число в пределах веса.
        for (Toy toy: stok.getCargo()) {
            rnd = rnd  - toy.getWeight(); //Отнимаем от сгенерированого числа вес игршки, пока число не станет равно 0 или меньше 0
            if (rnd <= 0 ){
               stok.addWinerCargo(toy); //Игрушка на которой сгенерированое число упало до 0 или меньше считаеться выпавшей
               return;
            }
        }
    }

}
