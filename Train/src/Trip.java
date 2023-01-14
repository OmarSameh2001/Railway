import java.util.ArrayList;

public class Trip {
    private String start, date, end;
    Driver driver ;
    //driver1.getId();
    private int number, maxpass, speed;
    public Trip(int anumber, Driver adriver, String adate, int amaxpass, String astart, String aend, int aspeed)
    {
        number = anumber;  date = adate; driver= adriver;
        maxpass = amaxpass; start = astart; end = aend; speed = aspeed;
    }

    public int getNumber()
    {   return number;}
    public Driver getNDriver()
    {   return driver;}
    public String getDate()
    {   return date;}
    public int getMaxpass()
    {   return maxpass;}
    public String getStart()
    {   return start;}
    public String getEnd()
    {   return end;}
    public int getSpeed()
    {   return speed;}
    public void setNumber(int anumber)
    {   number = anumber;}
    public void setDriver(Driver adriver)
    {   driver = adriver;}
    public void setDate(String adate)
    {   date = adate;}
    public void setMaxpass(int amaxpass)
    {   maxpass = amaxpass;}
    public void setStart(String astart)
    {   start = astart;}
    public void setEnd(String aend)
    {   end = aend;}
    public void setSpeed(int aspeed)
    {   speed = aspeed;}


    ArrayList<Passenger> passengers = new ArrayList<>();

    public void addpass(Passenger passenger) {

        if (this.passengers.size() <= this.getMaxpass()) {
            passengers.add(passenger);
            System.out.println("Passenger Sucessfully added to the trip");
        } else {
            System.out.println("The trip is full");
        }

    }
    public void removepass(Passenger passenger) {
        for(int x = 0; x < passengers.size(); x++){
            if(passenger.equals(passengers.get(x)))
            {passengers.remove(x);}
        }

    }
    public void display()
    {
        System.out.println("The date of the trip: " + this.getDate() + "it starts from: " + this.getStart() + " and ends in: " + this.getEnd());
    }
    public void displaypass()
    {
        for (int w = 0; w < passengers.size(); w++)
        {
            System.out.print((w+1) + ": ");
            passengers.get(w).display();
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        return "Date: " + date + ", trip number: " + number + ", driver: " + driver + ", Max passengers: " + maxpass + ", Departure: " + start + ", Arriving: " + end + ", Top speed: " + speed + "km/h";
    }
}
