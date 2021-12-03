package assignment1;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class Earth {
    double[][] arrayOfEarth;
    TreeMap<Double, TreeMap<Double, Double>> mapOfEarth;
    public static final int MAX_DIM = 90;
    //double altitude = code();

    public double code() {
        while (true) {
            System.out.println("please enter an altitude: ");
            Scanner scan = new Scanner(System.in);
            double num = scan.nextDouble();
            return num;
        }


        }

      //used the webinar
    public void readDataArray(String fileName) throws FileNotFoundException {
        Scanner data = new Scanner(new File(fileName));
        int count = 0;

        // This counts how many lines are in the file using a while loop
        while (data.hasNextLine()) {
            count++;
            data.nextLine();
        }


        //this print out how many lines are in the file using the  previous while loop
        System.out.println("File has " + count + "  lines");


        //this declares the 2D Array using all the lines in the file and grouping them up into 3's
        arrayOfEarth = new double[count][3];
        data.close();

        //this scans the file that we are using and defines the stings and doubles.
        data = new Scanner(new File(fileName));
        String java;
        double longitude;
        double latitude;
        double altitude;

        count = 0;
        while (data.hasNextLine()) {
            java = data.nextLine();
            String[] EarthData = java.split("\t");
            //this declared each of the 3 cords as a double and what order
            longitude = Double.parseDouble(EarthData[0]);
            latitude = Double.parseDouble(EarthData[1]);
            altitude = Double.parseDouble(EarthData[2]);

            //this groups the data into an array in groups of 3, as longitude, latitude and altitude.
            arrayOfEarth[count][0] = longitude;
            arrayOfEarth[count][1] = latitude;
            arrayOfEarth[count][2] = altitude;

            count++;
        }
    }
    public List<ArrayList<Double>> coordinatesAbove(double altitude) {
        List<ArrayList<Double>> coordinatesAboveEA = new ArrayList<>();
        //this takes the altitude and sees how many cords are above the number given by the user
        for(int j = 0; j < arrayOfEarth.length; j++) {
            if (arrayOfEarth[j][2]> altitude){
              ArrayList<Double> mylist = new ArrayList<>();
              for (int s = 0; s < arrayOfEarth[j].length; s++){
                  mylist.add(arrayOfEarth[j][s]);
              }
              coordinatesAboveEA.add(mylist);
            }
        }
        return  coordinatesAboveEA;
    }
    //this tell's the user the percentage of how many cords are above the number
    public void percentageAbove(double altitude){
        double percentageAboveEA = coordinatesAbove(altitude).size();
        double equation = percentageAboveEA/arrayOfEarth.length*100;
        DecimalFormat form = new DecimalFormat("#.#");
        System.out.println("Proportion of coordinates above "+ form.format(altitude) + " Meters: "+ form.format(equation)+ "%");
    }

    public List<ArrayList<Double>> coordinatesBelow(double altitude) {
        //this takes the altitude and sees how many cords are below the number given by the user
        List<ArrayList<Double>> coordinatesAboveEB = new ArrayList<>();
        for(int j = 0; j < arrayOfEarth.length; j++) {
            if (arrayOfEarth[j][2]< altitude){
                ArrayList<Double> mylist = new ArrayList<>();
                for (int s = 0; s < arrayOfEarth[j].length; s++){
                    mylist.add(arrayOfEarth[j][s]);
                }
                coordinatesAboveEB.add(mylist);
            }
        }
        /*System.out.println(coordinatesAboveEB);*/
        return  coordinatesAboveEB;
    }
    //this tell's the user the percentage of how many cords are below the number
    public void percentageBelow(double altitude) {
        double percentageAboveEB = coordinatesAbove(altitude).size();
        double equation = percentageAboveEB/arrayOfEarth.length*100;
        DecimalFormat form = new DecimalFormat("#.#");
        System.out.println("Proportion of coordinates above "+ form.format(altitude) + " Meters: "+ form.format(equation)+ "%");;
    }

        public void readDataMap(String fileName) throws FileNotFoundException {
             Scanner data = new Scanner(new File(fileName));
             mapOfEarth = new TreeMap<>();

             //this function puts the data into a treemap
             String java;
             double longitude;
             double latitude;
             double altitude;
             //using a while functions i found worked best for the treemap
             while(data.hasNextLine()) {
                 java = data.nextLine();
                 String[]   mapData = java.split("\t");
                 longitude = Double.parseDouble(mapData[0]);
                 latitude = Double.parseDouble(mapData[1]);
                 altitude = Double.parseDouble(mapData[2]);

                 //if / else is great for error handling during this part
                 if(mapOfEarth.get(longitude) == null){
                     mapOfEarth.put(longitude, new TreeMap<>());
                     mapOfEarth.get(longitude).put(latitude, altitude);
                 }
                 else {
                     mapOfEarth.get(longitude).put(latitude, altitude);
                 }
             }
             data.close();
       }
       //this generates a map using a set resolution
      public void generateMap(double resolution) {
            TreeMap<Double, TreeMap<Double, Double>> Foundation = new TreeMap<>();
            int Long = (int) (360 / resolution);
            int Lat = (int) (180 / resolution);
            int amount = Long*Lat;
           System.out.println(amount);
           DecimalFormat dec = new DecimalFormat("#.#");
           while (Foundation.size() != amount){
               double MyLong = Double.parseDouble(dec.format(new Random().nextInt(amount)));
               double Mylat = Double.parseDouble(dec.format(new Random().nextInt(amount)));
               TreeMap<Double, Double> Found = new TreeMap<>();
               Found.put(MyLong, Mylat);
               double alt = Double.parseDouble(dec.format(new Random().nextInt(amount)));
               Foundation.put(alt, Found);
               System.out.println(Foundation);
               System.out.println(Foundation.size());
               }

           }


           // this gets the altitude for the random map
           public double getAltitude(double longitude, double latitude){
           double alt = 0;
            TreeMap<Double, Double> Foundation = new TreeMap<>();
            Foundation.put(longitude, latitude);
            Set<Map.Entry<Double, TreeMap<Double, Double>>> set = mapOfEarth.entrySet();

            for(Map. Entry<Double, TreeMap<Double, Double>> Entry : set) {
                if(Entry.getValue().equals(Foundation)) {
                    System.out.println("alt" + Foundation + "=" + Entry.getKey());
                    alt = Entry.getKey();
                }
            }
            return alt;
           }
    }








