public class Main
{
    public static void main(String[] args)
    {
        Skan skan = new Skan();

        while(true)
        {
            try
            {
                skan.skanuj();
            }
            catch(Wyjatek e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
                try
                {
                    System.out.println("Usypiam");
                    Thread.sleep(60000);
                }
                catch (InterruptedException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }
}
