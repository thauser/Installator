package controllers.unpacker;

import controllers.Controller;
import models.unpacking.Unpacker;

/**
 * Created by eunderhi on 14/12/15.
 * Controller to trigger the unpacking action. This is done in a new thread
 * to prevent the unpacking action from blocking the GUI.
 */
public class UnpackerController implements Controller {

    private Unpacker unpacker;
    private Thread unpackingThread;

    public UnpackerController(Unpacker unpacker) {
        this.unpacker = unpacker;
    }

    @Override
    public void performAction() {
        if(unpackingThread == null) {
            unpacker.unpack();
        }
        else {
            unpackingThread.start();
        }
    }

    public void multiThread() {
        unpackingThread = new Thread(unpacker::unpack);
    }

}
