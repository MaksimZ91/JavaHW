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

    public void getWinnerToy(){
        stok.getWinnerToy();
    }

    public void updateWeigth(int newWeigth, Toy toy){
        ArrayList<Toy> toys = stok.getCargo();
        int index = toys.indexOf(toy);
        Toy currentToy = toys.get(index);
        currentToy.setWeight(newWeigth);
    }

    public void game(){
        if (stok.getCargo().isEmpty()){
            System.out.println("Склад пуст!");
            return;
        }
       int sumWeigth = stok.getSumWightToys();
       int rnd = new Random().nextInt(sumWeigth);
        for (Toy toy: stok.getCargo()) {
            rnd = rnd  - toy.getWeight();
            if (rnd <= 0 ){
               stok.addWinerCargo(toy);
               return;
            }
        }
    }

}
