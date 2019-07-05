package lu.findl.sikuli;

import org.sikuli.basics.Debug;
import org.sikuli.script.*;

public class Main {

    public static void main(String[] args) throws FindFailed {

        Debug.setDebugLevel(3);
        ImagePath.add("src/main/resources");
        Screen sc = new Screen(2);

        String[] data = {"Houssam", "Imane", "Othmane"};

        App.open("AcroRd32",5); // open Adobe acrobat reader
        sc.doubleClick("imgs/form2.png");// open form2
        sc.wait(6.0);

        Match zoomArriere = sc.find("imgs/zoomArriere.png"); // resize adobe acrobat screen size to make page switch easy
        for (int i = 0; i < 4; i++)
            sc.click(zoomArriere);

        sc.click("imgs/nextPage.png"); // go to add one or more bo page

        for (int i = 0; i < data.length -1; i++) { // Add bo
            sc.click("imgs/addBoButton.png");
            sc.wait(1.0);
        }
    }
}































