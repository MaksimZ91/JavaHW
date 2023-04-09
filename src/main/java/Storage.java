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
    public void addWinerCargo(Toy item){ //����� ������������ �������� ������� � ������ ������ �� ������
        try{
            int index = cargo.indexOf(item);
            Toy toy = cargo.get(index);  //������� �������� ������� �� ����� ������
            if (winerCargo.contains(item)){ //��������� ���� �� ������� ��� ������ ��� �������
                int winnerIndex = winerCargo.indexOf(item);
                Toy winnerToy = winerCargo.get(winnerIndex); //������� ��
                winnerToy.setCount(winnerToy.getCount()+1); //����������� ���-�� ������� �� 1
                toy.setCount(toy.getCount()-1); //��������� ���-�� ������� �� 1 �� ����� ������
                if(toy.getCount() <= 0) //���� �� ������� ��������� ������� � ������ ������ ������� �� � ������ ������
                    cargo.remove(index);
            } else {
                Toy copyItem = item.clone(); //���� �� ������ ��� ������ ��� �������� ������� ������� �� �����.
                winerCargo.add(copyItem); //��������� �� ����� ��� ������
                toy.setCount(toy.getCount()-1);//��������� ���-�� ������� �� 1 �� ����� ������
                if(toy.getCount() <= 0) //���� �� ������� ��������� ������� � ������ ������ ������� �� � ������ ������
                    cargo.remove(index);
                int winnerIndex = winerCargo.indexOf(copyItem);
                winerCargo.get(winnerIndex).setCount(1); //������������� � � ����� ���������� ������ 1 �����.
            }
        }catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }
    }

    public void getWinnerToy(){  // ����� ��������� ������ � ����������� ������
        ArrayList<Toy> toys = getWinerCargo();
        if (getWinerCargo().isEmpty()){
            System.out.println("����� ����!");
            return;
        }
        Toy toy = toys.get(0); //������ ������ ������� 1 ��������
        String strToys = new StringBuilder()
                .append("id: ")
                .append(toy.getId())
                .append(" ").append("type: ")
                .append(toy.getDescription())
                .append("\n")
                .toString();
        if (toy.getCount() == 1){ //���� ������ ��������� ������ ������ �� ������.
            toys.remove(toy);
            System.out.printf("C �������� ������ ������ ��������� ������� %s c id %s \n", toy.getDescription(), toy.getId());
            Repository.write(strToys); //���������� � ���� �������� �������
            return;
        }
        toy.setCount(toy.getCount()-1); //����� ��������� ���-�� �� 1.
        Repository.write(strToys);
        System.out.printf("������ � ��������� ������ ������� %s c id %s, ������� ����� ���� �������� %d \n",
                toy.getDescription(),
                toy.getId(),
                toy.getCount());
    }
    
    public int getSumWightToys(){ //��������������� ����� ��� ��������� �������, ��������� ����� ��� ���� �������.
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
