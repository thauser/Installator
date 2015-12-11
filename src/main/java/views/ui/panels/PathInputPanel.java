package views.ui.panels;

import views.ui.button.GUIButton;
import views.ui.textinput.GUITextInputField;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eunderhi on 11/12/15.
 */
public class PathInputPanel extends GUIPanel {

    public PathInputPanel(JFrame frame) {
        super(frame);
    }

    @Override
    public void build() {
        button.setText("Install");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(field.getTextField(), BorderLayout.NORTH);
        frame.getContentPane().add(button.getButton(), BorderLayout.SOUTH);
        frame.setSize(900, 600);
    }

    public void setField(GUITextInputField field) {
        this.field = field;
    }

    public void setButton(GUIButton button) {
        this.button = button;
    }

}