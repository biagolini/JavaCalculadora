import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Calculadora  extends JFrame {
    private JLabel lbTitulo, lbNum1, lbNum2, lbOperator;
    private JTextField tfNum1, tfNum2;
    private JComboBox<String> cbOperator;
    private static final String valOp[] = {"+", "-", "*","/", "^", "%"};
    private JButton calcular;
    private Container cp;

    private Double resultado;

    public Calculadora() {
        //Instanciamento
        lbTitulo = new JLabel("Calculadora - Exercicio 1");
        lbNum1 = new JLabel("Numero 1");
        lbNum2 = new JLabel("Numero 2");
        lbOperator = new JLabel("Operador");
        tfNum1 = new JTextField();
        tfNum2 = new JTextField();
        cbOperator = new JComboBox<>(valOp);
        calcular = new JButton("Calcular");
        cp = getContentPane();
        resultado = 0d;

        //Formatação
        cp.setLayout(null);
        cp.setBackground(new Color(210, 210, 210));
        setTitle("Calculadora");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbTitulo.setFont(new Font("Calibri", Font.BOLD, 20));
        lbTitulo.setBounds(50, 0, 400, 50);
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        lbNum1.setBounds(50, 100, 100, 50);
        lbNum2.setBounds(50, 200, 100, 50);
        lbOperator.setBounds(50, 300, 100,50);
        tfNum1.setBounds(200, 100, 200, 50);
        tfNum2.setBounds(200, 200, 200, 50);
        cbOperator.setBounds(200, 300, 200, 50);
        calcular.setBounds(200, 400, 200, 50);

        //Adição dos componentes
        cp.add(lbTitulo);
        cp.add(lbNum1);
        cp.add(lbNum2);
        cp.add(lbOperator);
        cp.add(tfNum1);
        cp.add(tfNum2);
        cp.add(cbOperator);
        cp.add(calcular);

        //Eventos - Botão Calculadora
        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btCalcularAction();
            }
        });
    }

    private void btCalcularAction() {
        this.calcular();
        JOptionPane.showMessageDialog(this,
                ("Resultado:   " + resultado),
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void calcular() {
        String operador = cbOperator.getSelectedItem().toString();
        Double n1 = Double.parseDouble(tfNum1.getText());
        Double n2 = Double.parseDouble(tfNum2.getText());

        switch (operador) {
            case "+":
                resultado = n1 + n2;
                break;
            case "-":
                resultado = n1 - n2;
                break;
            case "*":
                resultado = n1 * n2;
                break;
            case "/":
                resultado = n1 / n2;
                break;
            case "^":
                resultado = Math.pow(n1,n2);
                break;
            case "%":
                resultado = (n1 % n2);
                break;
            default:
                System.out.println("Erro na seleção de metodo.");
                resultado = 0d;
                break;
        }
    }

}
