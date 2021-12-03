package assignment1;

import java.awt.*;
import java.io.FileNotFoundException;

public class map extends coordinates {
    Earth e;
    int blocksize = 24;
    double scale = 0.2;

   //used the webinar for this part
    //this is for printing the world map
    public map(String fileName) throws FileNotFoundException {
        e = new Earth();
        e.readDataArray(fileName);

        //this will set the long and lat of my map
        setlong(-1, 361);
        setlati(-91, 91);
    }
    //this will allow for the user to alter the sea level of the map
    int riseSeaLevel = 0;
    public void riseSea(int riseSeaLevel ){
        this.riseSeaLevel = riseSeaLevel;
    }


    //paint component allows for it to be painted using jframe
    @Override
    public void paintComponent(Graphics m) {
        Graphics2D m2d = (Graphics2D) m;

        //gets the width and height from coordinates
        this.width = getWidth();
        this.height = getHeight();


// for loop to keep iterating through the map coords
        for (int g = 0; g < e.arrayOfEarth.length; g++) {


            double longitude = e.arrayOfEarth[g][0];
            double latitude = e.arrayOfEarth[g][1];
            double altitude = e.arrayOfEarth[g][2] + searize;


            //this will determine each altitude what color that portion of the map will be
            if (altitude <= -4000 + riseSeaLevel) {
                m2d.setColor(new Color(15, 50, 97));

            }else if (altitude <= -3000 + riseSeaLevel) {
                m2d.setColor(new Color(50, 68, 255));

            }else if (altitude <= -2000 + riseSeaLevel) {
                m2d.setColor(new Color(65, 91, 255));

            }else if (altitude <= -1000 + riseSeaLevel) {
                m2d.setColor(new Color(50, 68, 255));

            }else if (altitude <= -500 + riseSeaLevel) {
                m2d.setColor(new Color(27, 86, 205));

            }else if (altitude <= 0 + riseSeaLevel) {
                m2d.setColor(new Color(60, 102, 140));

            }else if (altitude <= 1000 + riseSeaLevel) {
                m2d.setColor(new Color(50, 200, 50));

            }else if (altitude <= 2000 + riseSeaLevel) {
                m2d.setColor(new Color(50, 150, 0));

            }else if (altitude <= 3000 + riseSeaLevel) {
                m2d.setColor(new Color(60, 180, 55));

            }else if (altitude <= 4000 + riseSeaLevel) {
                m2d.setColor(new Color(51, 71, 0));

            }else if (altitude <= 6500 + riseSeaLevel) {
                m2d.setColor(new Color(80, 80, 0));

            }else {
                m2d.setColor(new Color(0, 0, 0));
            }
            m.fillRect(scalelong(longitude), scalelati(latitude), blocksize, blocksize);
      } /*

        for (double longitude = 0; longitude < Earth.MAX_DIM; longitude += scale) {
            for (double latitude = 0; latitude < Earth.MAX_DIM; latitude += scale) {
                    double lon = e.mapOfEarth.floorKey(longitude);
                    double lat = e.mapOfEarth.floorKey(latitude);
                    double curColour = e.mapOfEarth.get(lon).get(lat);

                    if (curColour <= -4000) {
                        m2d.setColor(new Color(15, 50, 97));
                    }else if (curColour <= -3000) {
                        m2d.setColor(new Color(50, 68, 255));
                    }else if (curColour <= -1000) {
                        m2d.setColor(new Color(0, 255, 255));
                    }else if (curColour <= 10) {
                        m2d.setColor(new Color(50, 250, 255));
                    }else {
                        m2d.setColor(new Color(0, 255, 0));
                    }

                    m.fillRect(scalelong(longitude), scalelati(latitude), blocksize, blocksize);
                }
            }*/
        }
    }
