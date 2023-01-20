package main;

import control.Command;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Currency;
import view.MoneyDialog;
import view.MoneyDisplay;
import view.SwingMoneyDialog;
import view.SwingMoneyDisplay;

public class MainFrame extends JFrame{

    private Currency[] currencies;
    private Map<String, Command> commands = new HashMap<>();
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    
    public MainFrame(Currency[] currencies){
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog(), BorderLayout.NORTH);
        this.add(moneyDisplay(), BorderLayout.CENTER);
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
        
    public void add(Command command){
        commands.put(command.name(), command);
    }

    private Component moneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog(currencies);
        moneyDialog = dialog;
        return dialog;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(calculateButton());
        return panel;
    }
    
    private Component moneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        moneyDisplay = display;
        return display;
    }

    private JButton calculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Calculate").execute();
            }
        };
    }

}
