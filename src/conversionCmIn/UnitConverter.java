package conversionCmIn;

public class UnitConverter {

    // 変換の計算
    public double cmToInch(double cm) {
        // センチ>>インチ
        return cm / 2.54;
    }

    public double inchToCm(double inch) {
        // インチ>>センチ
        return inch * 2.54;
    }

}
