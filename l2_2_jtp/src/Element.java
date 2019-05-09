public class Element {
    private int val;
    private Element next;

    public Element(int val)
    {
        this.val = val;
    }

    public Element getNext()
    {
        return next;
    }

    public int getVal()
    {
        return val;
    }

    public void setVal(int val)
    {
        this.val = val;
    }

    public void setNext(Element next)
    {
        this.next = next;
    }
}