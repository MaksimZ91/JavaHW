import java.util.ArrayList;


public class Storage {



    private ArrayList<Toy> cargo;

    private ArrayList<Toy> winerCargo;

    public Storage() {
        this.cargo = new ArrayList <Toy>();
        this.winerCargo = new ArrayList <Toy>();
    }


    public void addCargo(Toy item){
        cargo.add(item);
    }

    public void addWinerCargo(Toy item){ //ћетод перекидывает выпавшую игрушку с одного скалда на другой
        try{
            int index = cargo.indexOf(item);
            Toy toy = cargo.get(index);  //Ќаходим выпавшую игрущку на общем складе
            if (winerCargo.contains(item)){ //провер€ем если на склладе дл€ выдачи эта игрушка
                int winnerIndex = winerCargo.indexOf(item);
                Toy winnerToy = winerCargo.get(winnerIndex); //находим ее
                winnerToy.setCount(winnerToy.getCount()+1); //увеличеваем кол-во игрушек на 1
                toy.setCount(toy.getCount()-1); //уменьшаем кол-во игрушек на 1 на общем складе
                if(toy.getCount() <= 0) //если мы забрали последнию игрушку с обшего склада удал€ем ее с общего склада
                    cargo.remove(index);
            } else {
                Toy copyItem = item.clone(); //если на складе дл€ выдачи нет выпавшей игрушки создаем ее копию.
                winerCargo.add(copyItem); //добавл€ем на склад дл€ выдачи
                toy.setCount(toy.getCount()-1);//уменьшаем кол-во игрушек на 1 на общем складе
                if(toy.getCount() <= 0) //если мы забрали последнию игрушку с обшего склада удал€ем ее с общего склада
                    cargo.remove(index);
                int winnerIndex = winerCargo.indexOf(copyItem);
                winerCargo.get(winnerIndex).setCount(1); //устанавливаем в в копии количество равное 1 штуки.
            }
        }catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }
    }

    public void getWinnerToy(){  // метод подучение игршки с выигрышного склада
        ArrayList<Toy> toys = getWinerCargo();
        if (getWinerCargo().isEmpty()){
            System.out.println("—клад пуст!");
            return;
        }
        Toy toy = toys.get(0); //всегда выдаем игрушку 1 позициию
        String strToys = new StringBuilder()
                .append("id: ")
                .append(toy.getId())
                .append(" ").append("type: ")
                .append(toy.getDescription())
                .append("\n")
                .toString();
        if (toy.getCount() == 1){ //если отдали последнию уда€ем игршку со склада.
            toys.remove(toy);
            System.out.printf("C пизового скалда выдана последн€€ игрушка %s c id %s \n", toy.getDescription(), toy.getId());
            Repository.write(strToys); //«аписываем в файл выданную игрушку
            return;
        }
        toy.setCount(toy.getCount()-1); //иначе уменьшаем кол-во на 1.
        Repository.write(strToys);
        System.out.printf("¬ыдана с призового склада игрушка %s c id %s, игрушек этого типа осталось %d \n",
                toy.getDescription(),
                toy.getId(),
                toy.getCount());
    }
    
    public int getSumWightToys(){ //вспомогательный метод дл€ розогрыша игрушек, суммирует общий вес всех игрушек.
        int sumWight = 0;
        for (Toy toy: cargo ) {
            sumWight += toy.getWeight();
        }
        return sumWight;
    }

    public ArrayList<Toy> getCargo() {
        return cargo;
    }

    public ArrayList<Toy> getWinerCargo() {
        return winerCargo;
    }
}
