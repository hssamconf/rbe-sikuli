package lu.findl.sikuli;

import org.sikuli.basics.Debug;
import org.sikuli.script.*;

public class Main {
    private static final int DEFAULT_TIMEOUT = 60; //1 minute

    public static void main(String[] args) throws FindFailed {

        Debug.setDebugLevel(2);
        ImagePath.add(Main.class.getCanonicalName() + "/imgs");
        Screen sc = new Screen();

        String[] data = {"Houssam", "Imane", "Othmane"};

        App.focus("AcroRd32");// open acrobat reader
        App pdf = App.open("\"c:\\RBE\\form_1.pdf\""); // open form 1
        sc.wait(new Pattern("logo.png").exact(), DEFAULT_TIMEOUT);// wait till pdf load

        sc.type(Key.RIGHT, KeyModifier.CTRL); // go add bo page

        for (int i = 0; i < data.length - 1; i++) { // Add bos
            sc.click(sc.wait(new Pattern("addBoButton").exact(), DEFAULT_TIMEOUT));
            sc.mouseMove(sc.getCenter());
        }

    }
}
