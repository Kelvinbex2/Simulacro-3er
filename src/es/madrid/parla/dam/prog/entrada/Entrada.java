package es.madrid.parla.dam.prog.entrada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    static Scanner sc = new Scanner(System.in);

    public static int leerEntero() {
        int num = 0;

        try {
            num = sc.nextInt();

            if (num < 0) {
                throw new InputMismatchException("Numero negativo, debe ser mayor aue 0.");
            }
        } catch (InputMismatchException e) {
            System.out.println("No valido.");

        } finally {
            sc.nextLine();
        }

        return num;
    }

    public static String leerString() {
        String texto = "";

        try {
            texto = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }

        return texto;
    }

    public static boolean leerboolean() {
        while (true) {
            String cadena = sc.nextLine();

            if (cadena.length() == 2) {
                if (cadena.equalsIgnoreCase("si"))
                    return true;
                if (cadena.equalsIgnoreCase("no"))
                    return false;

                System.out.println("Debes introduciir si o no");

            }
        }
    }

    public static double leerDouble() {
        double num = 0;
        num = sc.nextDouble();
        return num;
    }

}
