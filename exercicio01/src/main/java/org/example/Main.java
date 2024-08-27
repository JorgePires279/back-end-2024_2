package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner leitor = new Scanner(System.in);

        System.out.println("qual ambientação você prefere");
        System.out.println("1 - sci f1");
        System.out.println("2 - medieval");
        Integer opcaoAmbientacao = leitor.nextInt();

        System.out.println("qual genero você prefere");
        System.out.println("1 - comedia");
        System.out.println("2 - drama");
        Integer opcaoGenero = leitor.nextInt();

        if (opcaoAmbientacao == 1 && opcaoGenero == 1) System.out.println("Homens Preto");
        if (opcaoAmbientacao == 1 && opcaoGenero == 2) System.out.println("Arrivel");
        if (opcaoAmbientacao == 2 && opcaoGenero == 1) System.out.println("Shrek");
        if (opcaoAmbientacao == 2 && opcaoGenero == 2) System.out.println("Gladiador");
    }
}