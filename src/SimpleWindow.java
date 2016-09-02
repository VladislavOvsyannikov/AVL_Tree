import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleWindow extends JFrame {

    SimpleWindow(){
        super("BinSearchTree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1300, 600);
        setResizable(false);
        setLocationRelativeTo(null); // фрейм по центру экрана
        setLayout(new BorderLayout()); // задаем менеджер компаноки BorderLayout

        final DrawPanel drawPanel = new DrawPanel(); // создаем панель для рисования
        JPanel buttonPanel = new JPanel(); // создаем панель для кнопок
        buttonPanel.setLayout(new FlowLayout());

// добавляем панели на фрейм
        add(drawPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(new JLabel(""));
        final JTextField x1 = new JTextField("", 3);
        x1.setHorizontalAlignment(JTextField.RIGHT);
        buttonPanel.add(x1);

        JButton buttonAdd = new JButton("Add");
        buttonPanel.add(buttonAdd);

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.setDrawMode(1);
                drawPanel.setX(Integer.valueOf(x1.getText()));
                drawPanel.repaint();
            }
        });
        JButton buttonFind = new JButton("Find");
        buttonPanel.add(buttonFind);

        buttonFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.setDrawMode(2);
                drawPanel.setX(Integer.valueOf(x1.getText()));
                drawPanel.repaint();
            }
        });

        JButton buttonDelete = new JButton("Delete");
        buttonPanel.add(buttonDelete);

        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.setDrawMode(3);
                drawPanel.setX(Integer.valueOf(x1.getText()));
                drawPanel.repaint();
            }
        });
        JButton buttonRandom = new JButton("Random");
        buttonPanel.add(buttonRandom);

        buttonRandom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.setDrawMode(4);
                drawPanel.setX(Integer.valueOf(x1.getText()));
                drawPanel.repaint();
            }
        });
        JButton buttonClear = new JButton("Clear");
        buttonPanel.add(buttonClear);

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.setDrawMode(5);
                drawPanel.repaint();
            }
        });
        setVisible(true);
    }
}
