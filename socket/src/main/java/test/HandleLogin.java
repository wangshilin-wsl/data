package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HandleLogin implements ActionListener{
    windowlogin win;

    public HandleLogin(windowlogin win){
        this.win = win;
    }

    public void actionPerformed(ActionEvent e) {



        String id=win.textField.getText();
        String password=win.textField_1.getText();
        System.out.println(id+"  "+password);
        Client client=new Client();
        client.connect();

    }

}
