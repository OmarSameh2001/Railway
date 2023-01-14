import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;

public class Main
{ public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
while (true)
{
    //giving user all operations to choose from
    System.out.println("Please enter the number of the operation you want:");
    System.out.println("1- Offer new trip");
    System.out.println("2- Add a Passanger to Specific Trip");
    System.out.println("3- Remove a Passenger from a Specific Trip");
    System.out.println("4- Retrive average number of passengers");
    System.out.println("5- Dispaly all trips");
    System.out.println("6- save all in text");
    System.out.println("7- Exit the program");
    int q = scan.nextInt();
    if (q == 1) {addTrip();}
    else if (q == 2) {newPassenger();}
    else if (q == 3) {removePassenger();}
    else if (q == 4) {averagePassenger();}
    else if (q == 5) {dispalyTrip();}
    else if (q == 6) {save();}
    else if (q == 7) {break;}
    else {System.out.println("invalid number");}

}
}

    //declaring two arraylists
    static ArrayList <Trip> trips = new ArrayList<>();
    static ArrayList <String> dates = new ArrayList<>();
    public static void addTrip()//1- adding new trip in specified date
    {
        //driver details
        Driver driver1 = new Driver("Hussein", 123456, 40, "a" ,123);
        //adding trip options
        Scanner scan = new Scanner(System.in);
        int number, maxpass, speed;
        String start, end, date;
        System.out.println("Enter the trip number");
        number = scan.nextInt();
        System.out.println("Enter the trip maximum passenger's number");
        maxpass = scan.nextInt();
        System.out.println("Enter the trip Max speed");
        speed = scan.nextInt();
        System.out.println("Enter the trip Date");
        date = scan.next();
        System.out.println("Enter the trip start station");
        start = scan.next();
        System.out.println("Enter the trip end station");
        end = scan.next();
        Trip trip2 = new Trip(number, driver1, date, maxpass, start, end, speed);
        trips.add(trip2);  //save trip in trips arraylist
        boolean found = false;
        for (int d = 0; d<dates.size(); d++)
        {
            if (date==dates.get(d)) {
                found = true;
                break;
            }
        }
        if (found == false)
        {
            dates.add(date);
            Collections.sort(dates);
        }


    }
    public static void newPassenger()//2-adding new passenger to a specific trip
    {
        Scanner scan = new Scanner(System.in);
        String name, blood;
        int age, civilid;
        System.out.println("Please Enter passenger's name");
        name = scan.next();
        System.out.println("Please Enter passenger's civil id");
        civilid = scan.nextInt();
        System.out.println("Please Enter passenger's Blood type");
        blood = scan.next();
        System.out.println("Please Enter passenger's age");
        age = scan.nextInt();
        Passenger pass1 = new Passenger(name, civilid, age, blood);
        System.out.println("Please enter the number of the trip you want");
        for (int a = 0; a< trips.size(); a++)
        {
            System.out.print((a+1) + "- ");
            trips.get(a).display();
            System.out.println();
        }
        int t = scan.nextInt();
        if (t > trips.size() || t < 1)
        {
            System.out.println("invalid input");
        }
        else
        {
            trips.get(t-1).addpass(pass1);
        }
    }
    public static void removePassenger()//3- remove existing passenger in a specific trip
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number of the trip you want you wnt to remove a passenger from");
        for (int a = 0; a< trips.size(); a++)
        {
            System.out.print((a+1) + "- ");
            trips.get(a).display();
            System.out.println();
        }
        int t = scan.nextInt();
        if (t > trips.size() || t < 1)
        {
            System.out.println("invalid input");
        }
        else
        {
            System.out.println("choose the number of passenger you want to remove: ");
            Trip trip3 = trips.get(t-1);
            trip3.displaypass();
            int p = scan.nextInt();
            if (p > trip3.passengers.size() || p < 1)
            {
                System.out.println("invalid input");
            }
            else {
                trip3.removepass(trip3.passengers.get(p-1));
            }
        }
    }
    public static void averagePassenger()//4- retrieve average passengers per trip of a specified date
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the date (month/day/year)");
        String date = scan.next();
        double count = 0, sum = 0;
        for (int u = 0; u < trips.size(); u++)
        {
            if (Objects.equals(trips.get(u).getDate(), date))
            {

                count++;
                sum+=trips.get(u).passengers.size();
            }
        }

        if (count==0)
        {
            System.out.println("the average is 0");
        }
        else {
            System.out.println("the average is: " + (sum/count));
        }
    }
    public static void dispalyTrip()//5-display all trips
    {

        if (trips.size()==0) {
            System.out.println("There is no trips yet, please add");
        } else {
            for(int i = 0; i<dates.size(); i++)
            {
                ArrayList <Trip> tripnum = new ArrayList<>();
                for(int x =0; x<trips.size(); x++)
                {
                    if(dates.get(i)==trips.get(x).getDate())
                        tripnum.add(trips.get(x));
                }
                System.out.print(dates.get(i) + ": ");
                for (int z = 0; z<tripnum.size(); z++)
                    tripnum.get(z).display();
            }
        }

    }
    public static void save()//6- save data in text file
    {   if (trips.size()==0) {
            System.out.println("There is no trips yet, please add");
        } else {
            try {
            File fl = new File("data.txt");
            PrintWriter add = new PrintWriter(fl);
                for(int x =0; x<trips.size(); x++)
                {
                        add.println(trips.get(x).toString());
                }
                add.close();
            }
            catch (Exception w){
                System.out.println(w);
            }
        }
    }
}


