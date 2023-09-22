package task2;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //инициализация списка игрушек разными методами
        ToyList toys1 = new ToyList();
        toys1.addToy(new Toy(25,"мишка",3));
        toys1.addToyList(List.of(
                new Toy(5,"Скутер",1),
                new Toy(10,"Шахматы",2),
                new Toy(10,"Слайм",2)
        ));
        System.out.println(toys1);
        
        ParticipantQueue pq = new ParticipantQueue(List.of(
                new Participant("Аня"),
                new Participant("Андрей"),
                new Participant("Света"),
                new Participant("Катя"),
                new Participant("Рома"),
                new Participant("Вася"),
                new Participant("Настя"),
                new Participant("Денис"),
                new Participant("Лиза"),
                new Participant("Оля")
        ));
      
        Raffle raf = new Raffle(pq,toys1);
        System.out.println(raf.currentToys.toString());
        raf.runRaffle();

        System.out.println("\nРозыгрыш с вероятностью проиграть\n");
        ParticipantQueue pqloss = new ParticipantQueue();
        for (int i = 1; i <= 10 ; i++){
            pqloss.addParticipant(new Participant());
        }
        Raffle raf2 = new Raffle(pqloss,toys1);
        raf2.setLossWeight(30);
        System.out.println(raf2.currentToys.toString());
        raf2.runRaffle();

        
        toys1.saveToFile();
    }

}