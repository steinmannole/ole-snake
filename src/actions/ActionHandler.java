package actions;

import gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Gui.btnexit) {
            Data.safeData();
            System.exit(0);
        }
        if (e.getSource() == Gui.btnsave) {

        }
    }
}
