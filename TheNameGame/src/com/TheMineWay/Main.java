/*
    Joel Campos Oliva
    - The name game -
*/

package com.TheMineWay;

import java.util.Scanner;

public class Main {
    static final String GREEN = "\u001B[32m", RESET = "\u001B[0m";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu();
        System.out.println("--- FINAL DEL PROGRAMA ---");
    }
    static void Menu() {
        int opcio;
        do {
            System.out.println("\n****** Menú principal ******");
            System.out.println("1. Escriure un nom\n2. Sortir");
            System.out.print("\n[?] Opció: ");
            opcio = GetNumber(1,2);
            //No considero necessari fer servir un switch
            if(opcio == 1) Cantar();
        } while(opcio != 2);
    }
    static void Cantar() {
        String nom = GetName();

        System.out.println("\nA CANTAR!" + GREEN);
        // Cadena 1
        System.out.println(nom + "!");
        System.out.println(nom + ", " + nom + " bo " + (nom.charAt(0) == 'B' ? nom.substring(1) : NameReplace(nom,'B')));

        // Cadena 2
        System.out.println("banana fanna fo " + (nom.charAt(0) == 'F' ? nom.substring(1) : NameReplace(nom,'F')));

        // Cadena 3
        System.out.println("fee fa mo " + (nom.charAt(0) == 'M' ? nom.substring(1) :NameReplace(nom, 'M')) + ", " + nom + "!" + RESET);
    }

    // Funcions 'low level'
    static int GetNumber(int min, int max) {
        while(true) {
            int number = scanner.nextInt();
            if(number >= min && number <= max) return number;
            Error(0);
        }
    }
    static String GetName() {
        while(true) {
            System.out.print("[?] Nom: ");
            String name = scanner.next();
            if(name.length() > 1) return name;
            Error(1);
        }
    }
    static String NameReplace(String name, char original, char replacement) {
        return name.substring(0,1).replace(original,replacement) + name.substring(1);
    }
    static String NameReplace(String name, char replacement) {
        return replacement + name.substring(1);
    }
    static String Capitalize(String text) {
        // És la funció separar 1 i 2 unificada
        //Retorna la primera en majúscules i la resta en minúscules
        return text.toUpperCase().substring(0,1) + text.substring(1).toLowerCase();
    }

    // Funcions d'error
    static void Error(int code) {
        switch (code) {
            case 0: Error("Valor fora de rang"); break;
            case 1: Error("Nom no vàlid (mínim 2 lletres)"); break;
            default: Error("Error desconegut"); break;
        }
    }
    static void Error(String text) {
        System.out.println("[!] " + text);
    }
}