public abstract class Person {
    private String name;
    private int civilid;
    private int age;
    private String blood;

    public Person(String aname, int acivilid, int aage, String ablood)
    {
        name = aname;
        civilid = acivilid;
        age = aage;
        blood = ablood;
    }
    public int getCivilid()
    {
        return civilid;
    }
    public int getAge()
    {
        return age;
    }
    public String getName()
    {return name;}
    public String getBlood()
    {
        return blood;
    }
    public void setName(String aname)
    {
        name = aname;
    }
    public void setBlood(String ablood)
    {
        blood = ablood;
    }
    public void setCivilid(int acivilid)
    {
        civilid = acivilid;
    }
    public void setAge(int aage)
    {
        age = aage;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", civilid: " + civilid + ", age: " + age + ", blood type: " + blood;
    }
}
