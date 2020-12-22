package Experiment3;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCalculate {
    private JFrame frame;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SwingCalculate window = new SwingCalculate();
                    window.frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public SwingCalculate() {
        initialize();
    }
    private void initialize () {
        frame = new JFrame();
        frame.setTitle("\u7B80\u6613\u8BA1\u7B97\u5668");
        frame.setBounds(100,1400,450,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setVgap(20);
        flowLayout.setHgap(10);
        frame.getContentPane().add(panel,BorderLayout.NORTH);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(textField);
        textField.setColumns(20);

        JPanel panel1 = new JPanel();
        String[] name = {"7" , "8" , "9" , "/" , "C",
                         "4" , "5" , "6" , "*" , "Sqrt",
                         "1" , "2" , "3" , "-" , "1/x",
                         "0" , "+/-" , "." , "+" , "="};
        for (int i = 0; i < name.length;i ++){
            JButton button = new JButton(name[i]);
            panel1.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String t = e.getActionCommand();
                    if(t.equals("=")){
                        ScriptEngineManager manager = new ScriptEngineManager();
                        ScriptEngine scriptEngine = manager.getEngineByName("javascript");
                        String str = textField.getText();
                        try {
                            double d;
                            if (str.contains("Sqrt")){
                                d = Math.sqrt(Double.parseDouble(textField.getText().substring(5,str.length() - 1)));
                            }
                            else{
                                d = Double.parseDouble(scriptEngine.eval(str).toString());
                            }
                            if (Double.isNaN(d)) {
                                textField.setText("ERROR!");
                            }
                            else{
                                textField.setText(textField.getText() + "=" + String.valueOf(d));
                            }
                        }catch (Exception e1){
                            textField.setText("ERROR!");
                        }
                    }
                    else if (t.equals("C")) {
                        textField.setText("");
                    }
                    else if (t.equals("+/-")){
                        double dd = Double.parseDouble(textField.getText());
                        if (dd > 0) {
                            textField.setText("-" + textField.getText());
                        }
                        else{
                            dd *= -1;
                            textField.setText("+" + textField.getText());
                        }
                    }
                    else if (t.equals("1/x")) {
                        textField.setText("1/" + textField.getText());
                    }
                    else if (t.equals("Sqrt")) {
                        String tt = textField.getText();
                        textField.setText("Sqrt(" + tt + ")");
                    }
                    else{
                        textField.setText(textField.getText() + e.getActionCommand());
                    }
                }
            });
        }
        frame.getContentPane().add(panel1,BorderLayout.CENTER);
        panel1.setLayout(new GridLayout(4,5,5,5));
    }
}
