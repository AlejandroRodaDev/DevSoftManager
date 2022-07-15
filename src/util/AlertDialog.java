package util;

import javax.swing.*;

public class AlertDialog {

    public static void errorDialog(String text){
        JOptionPane.showMessageDialog(null, text,"Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void messageDialog(String text){
        JOptionPane.showMessageDialog(null,text);
    }

    public int wantContinueDialog(String text){

        int answer = JOptionPane.showConfirmDialog(null,text,
                " ",JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        return answer;
    }
}
