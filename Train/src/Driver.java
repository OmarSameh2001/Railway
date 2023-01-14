public class Driver extends Person{
    private int id;


    public Driver (String aname, int acivilid, int aage, String ablood, int aid)
    {
        super (aname, acivilid, aage, ablood);
        id = aid;
    }

    public void setId(int aid)
    {
        id = aid;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + ", id:" + id;
    }
}
