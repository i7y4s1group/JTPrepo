package los.przemyslaw;

import java.util.concurrent.Semaphore;

public class Zamowienie extends Thread {
    private Magazyn magazyn;
    private Finanse finanse;

    public Zamowienie(Magazyn magazyn, Finanse finanse)
    {
        this.magazyn = magazyn;
        this.finanse = finanse;
    }

    public void zamow(){

        for(int i=0 ; i < magazyn.wezStanMagazynu().size(); i ++){
            while(magazyn.wezStanMagazynu().get(i).getIlosc() <10 && finanse.getBudzet() > magazyn.wezStanMagazynu().get(i).getCena()) {
                magazyn.zmniejszZapasy(1,i);
                finanse.setBudzet(finanse.getBudzet()-magazyn.wezStanMagazynu().get(i).getCena());
            }
        }
    }

}
