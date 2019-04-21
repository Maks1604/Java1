package lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Главное окно");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        add(textArea, BorderLayout.CENTER);
        JButton button1 = new JButton("Добавить ФИО");
        add(button1, BorderLayout.SOUTH);
        setBounds(500, 200, 600, 600);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFIO(textArea);
            }
        });

    }

    public static void main(String[] args) {
        new MainWindow();
    }
}

class AddFIO extends JFrame {
    private JTextArea textArea;


    public AddFIO(JTextArea textArea) {
        this.textArea = textArea;
        setTitle("Добавление ФИО");
        JButton button = new JButton("OK");
        JTextField surname = new JTextField();
        JLabel labelSurname = new JLabel("Фамиия");
        JTextField name = new JTextField();
        JLabel labelName = new JLabel("Имя");
        JTextField patronymic = new JTextField();
        JLabel labelPatronymic = new JLabel("Отчество");
        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.add(labelSurname);
        panel.add(surname);
        panel.add(labelName);
        panel.add(name);
        panel.add(labelPatronymic);
        panel.add(patronymic);
        panel.add(button);
        add(panel, BorderLayout.CENTER);
        setBounds(500, 200, 500, 500);
        setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(surname.getText() + " " + name.getText() + " " + patronymic.getText() + '\n');
                setVisible(false);
                dispose();
            }
        });

    }
}