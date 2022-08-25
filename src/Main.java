import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static String[] toBytes (String value, String storage) {
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(2147483647);
        double PB_Value = Double.parseDouble(value);
        switch (storage) {
            case "TB" -> PB_Value /= 1e+3;
            case "GB" -> PB_Value /= 1e+6;
            case "MB" -> PB_Value /= 1e+9;
            case "KB" -> PB_Value /= 1e+12;
            case "B" -> PB_Value /= 1e+15;
            case "b" -> PB_Value /= 8e+15;
        }

        String Bit_String = df.format(PB_Value * 8e+15) + " b";
        String Byte_String = df.format(PB_Value * 1e+15) + " B";
        String KB_String = df.format(PB_Value * 1e+12) + " KB";
        String MB_String = df.format(PB_Value * 1e+9) + " MB";
        String GB_String = df.format(PB_Value * 1e+6) + " GB";
        String TB_String = df.format(PB_Value * 1e+3) + " TB";
        String PB_String = df.format(PB_Value) + " PB";

        return new String[] {
                Bit_String,
                Byte_String,
                KB_String,
                MB_String,
                GB_String,
                TB_String,
                PB_String
        };
    }

    public static void main(String[] args) {
        Scanner storageinput = new Scanner(System.in);
        System.out.println("Storage Type:");
        String storage = storageinput.next();

        Scanner valueinput = new Scanner(System.in);
        System.out.println("Storage Value:");
        String value = valueinput.next();

        String[] list = toBytes(value, storage);

        System.out.println(value + " " + storage + ":");
        System.out.println();

        for (String i : list) {
            System.out.println(i);
        }
    }
}