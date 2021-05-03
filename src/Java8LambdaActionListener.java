import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Java8LambdaActionListener {
    public static void main(String[] args) {
        // JAVA 8: FUNÇÕES LAMBDA

        // Função sem lambda
        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Olá Mundo!");
            }
        });

        // Função com lambda
        JButton jButton2 = new JButton();
        jButton2.addActionListener(e -> System.out.println("Olá Mundo!"));

        // SAM - Single Abstract Method
        // Qualquer interface que tenha apenas 1 método abstrato.
    }
}
