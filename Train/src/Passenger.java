public class Passenger extends Person{
    public Passenger(String aname, int acivilid,int aage, String ablood) {
        super(aname, acivilid, aage, ablood);
    }


    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this==obj;
    }
    public void display ()
    {
        System.out.println(this.getName() + " " + this.getCivilid() + " " + this.getAge() + " " + this.getBlood());
    }

}
