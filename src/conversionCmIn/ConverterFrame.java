package conversionCmIn;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ConverterFrame extends JFrame {
    private UnitConverter converter = new UnitConverter();
    private JTextField textField;
    private JRadioButton cmToInchRadio;
    private JRadioButton inchToCmRadio;
    private JLabel resultJLabel;

    public ConverterFrame() {

        setTitle(" cm / inch 変換");
        setSize(300, 200);
        setLocationRelativeTo(null);// 画面中央
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // パネル作成（部品置き場）
        JPanel panel = new JPanel();

        // ラベル
        JLabel label = new JLabel("数値を入力：");

        // 入力欄
        textField = new JTextField(10);

        // パネルに追加
        panel.add(label);
        panel.add(textField);

        // フレームに載せる
        add(panel);

        // ラジオボタン
        cmToInchRadio = new JRadioButton("cm → inch", true);
        inchToCmRadio = new JRadioButton("inch → cm");

        // グループ化（どちらか一方のみ）
        ButtonGroup group = new ButtonGroup();
        group.add(cmToInchRadio);
        group.add(inchToCmRadio);

        // パネルに追加
        panel.add(cmToInchRadio);
        panel.add(inchToCmRadio);

        // 変換ボタン
        JButton convertButton = new JButton("変換");
        panel.add(convertButton);

        convertButton.addActionListener(e -> {
            String input = textField.getText();

            try {
                double value = Double.parseDouble(input);

                double result;
                String unit;

                if (cmToInchRadio.isSelected()) {
                    result = converter.cmToInch(value);
                    unit = "inch";
                } else {
                    result = converter.inchToCm(value);
                    unit = "cm";
                }

                resultJLabel.setText(String.format("結果：%.2f %s", result, unit));

            } catch (NumberFormatException ex) {
                resultJLabel.setText("※ 数値を入力してください");
            }

        });

        // 結果表示ラベル
        resultJLabel = new JLabel("結果：");
        panel.add(resultJLabel);

        setVisible(true);
    }
}
