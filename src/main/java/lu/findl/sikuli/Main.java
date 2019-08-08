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
        App AcroRd32 = initAcrobatReader(sc);
        App form = initRbeForm(sc, "form_1");
        sc.type(Key.RIGHT, KeyModifier.CTRL); // go add bo page
        addBOs(sc, data.length);
    }

    private static App initAcrobatReader(Screen sc) {
        App AcroRd32 = new App("AcroRd32.exe");// open acrobat reader
        AcroRd32.open();
        AcroRd32.focus();
        sc.type(Key.SPACE, KeyModifier.ALT); // maximise window
        sc.wait(0.5);
        sc.type("n");
        return AcroRd32;
    }

    private static App initRbeForm(Screen sc, String formName) throws FindFailed {
        App form = new App("\"c:\\RBE\\" + formName + ".pdf\""); // open form 1
        form.open();
        sc.wait(new Pattern("logo.png").exact(), DEFAULT_TIMEOUT);// wait till pdf load
        return form;
    }

    private static void addBOs(Screen sc, int lenght) throws FindFailed {
        for (int i = 0; i < lenght - 1; i++) { // Add bos
            sc.click(sc.wait(new Pattern("addBoButton").exact(), DEFAULT_TIMEOUT));
            sc.mouseMove(sc.getCenter());
        }
    }
}
