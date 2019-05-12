public class KontekstStrategii
{
    private Interfejs typStrategii;

    public KontekstStrategii(Interfejs typStrategii)
    {
        this.typStrategii = typStrategii;
    }

    public Interfejs getTypStrategii()
    {
        return typStrategii;
    }

    public void setTypStrategii(Interfejs typStrategii)
    {
        this.typStrategii = typStrategii;
    }

    public void przenies(String sciezka)
    {
        typStrategii.przeniesienie(sciezka);
    }

    public void przetworz(String sciezka) { typStrategii.przetwarzanie(sciezka); }
}
