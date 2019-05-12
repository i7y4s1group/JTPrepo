package Blok1.Zadanie1;


public class Main {
    //WYSLAC ZADANIA DO KONCA NIEDZIELI
    //Math.Random
    //imiona - tablica 10 elementowa nazwiska losujemy w cyklu
    //nazwiska kolejno dodajemy
    //co to jest solid
    public static void main(String[] args) {
        Clients clients = new Clients();

/*        Map<Integer, List<Client>> wynikLosowan = klienci.drawingClientsEveryMonth(true);

        klienci.numberOfClientWinnings(wynikLosowan).entrySet().forEach(
                klient -> System.out.println(klient.getKey() + " " + klient.getValue())
        );*/

        clients.numberOfRepetitionsOfNames()
                .forEach((surnames, repetitions) ->
                        System.out.println(surnames + " " + repetitions)
                );

        System.out.println("--------------------------------------------------");
        System.out.println();
        clients.numberOfRepetitionsOfNamesV2().forEach(surname -> System.out.println(surname.getName() + " " + surname.getCounter()));
    }
}
