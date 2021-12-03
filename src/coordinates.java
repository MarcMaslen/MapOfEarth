package assignment1;

import javax.swing.*;

public class coordinates extends JComponent {
    int width = 1920, height = 1080;



    double longitudemin=0, longitudemax=1, latitudemin=0, latitudemax=1;


    public int scalelong(double longitude) { return (int) (width * (longitude - longitudemin) / (longitudemax - longitudemin)); }



    public int scalelati(double latitude) { return (int) (height * (latitudemin - latitude) / (latitudemax - latitudemin) + height); }




    public void setlong(double min, double max) {
        longitudemin = min;    longitudemax = max;



    }
    public void setlati(double min, double max) {
        latitudemin =min; latitudemax = max; }
}
