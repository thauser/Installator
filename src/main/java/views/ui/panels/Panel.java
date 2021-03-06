package views.ui.panels;

import views.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunderhi on 07/12/15.
 */
public abstract class Panel implements View {

    private List<View> viewList = new ArrayList<>();

    @Override
    public void update() {
        display();
    }

    @Override
    public void display() {
        displayPanel();
        displayComponents();
    }

    protected abstract void displayPanel();

    private void displayComponents() {
        for(View view : viewList) {
            view.display();
        }
    }

    public void addView(View view) {
        viewList.add(view);
    }

}
