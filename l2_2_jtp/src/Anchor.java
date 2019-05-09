public class Anchor
{
    private Element first;

    public Anchor()
    {
        this.first = null;
    }

    public void setFirst(Element first)
    {
        this.first = first;
    }

    public Element getFirst()
    {
        return first;
    }

    public void insertAtTheFront(int x)
    {
        Element element = new Element(x);
        element.setNext(first);
        this.first = element;
    }

    public void insertAtTheEnd(int x)
    {
        Element element = first;
        if(first == null)
        {
            System.out.println("Brak elementow na liscie");
        }
        Element nowyElement = new Element(x);
        nowyElement.setNext(null);

        if(element != null)
        {
            while(element.getNext() != null)
            {
                element = element.getNext();
            }
            element.setNext(nowyElement);
        }
        else
        {
            nowyElement.setNext(null);
            first = nowyElement;
        }
        System.out.println("Dodano element na koncu listy");
    }

    public void removeFirst()
    {
        if(first == null)
        {
            System.out.println("Brak elementow na liscie");
        }
        else
        {
            if(first.getNext() == null)
            {
                first = null;
            }

            if(first != null && first.getNext() != null)
            {
                first = first.getNext();
            }
            System.out.println("Usunieto element z poczatku listy");
        }
    }

    public void removeLast()
    {
        Element element = first;
        if(element == null)
        {
            System.out.println("Brak elementow na liscie");
        }
        else
        {
            if(element.getNext() == null)
            {
                first = null;
            }
            else
            {
                if(element != null && element.getNext() != null)
                {
                    while(element.getNext().getNext() != null)
                    {
                        element = element.getNext();
                    }
                    element.setNext(null);
                }
            }
            System.out.println("Usunieto elemnent z konca listy");
        }
    }

    public void show()
    {
        Element element = first;
        System.out.println("Lista:");
        while(element != null)
        {
            System.out.println(element.getVal());
            element = element.getNext();
        }
    }
}