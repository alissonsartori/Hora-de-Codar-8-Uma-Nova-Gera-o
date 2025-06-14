package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Simulador de Animal de Estimação Virtual!");
        System.out.println("Digite o nome do seu animal de estimação:");
        String nomePet = scanner.nextLine();

        VirtualPet pet = new VirtualPet(nomePet);
        System.out.println(pet.nome + " nasceu! O objetivo é cuidar dele até os 50 dias de idade. Boa sorte!");

        while (pet.estaVivo()) {

            if (pet.verificarVitoria()) {
                break;
            }

            pet.verificarStatus();

            System.out.println("\nO que você quer fazer com " + nomePet + "?");
            System.out.println("1. Alimentar");
            System.out.println("2. Brincar");
            System.out.println("3. Descansar");
            System.out.println("4. Levar ao banheiro");
            System.out.println("5. Dar banho");
            System.out.println("6. Sair do jogo");

            int escolha = -1;
            try {
                escolha = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
                continue;
            }


            switch (escolha) {
                case 1:
                    pet.alimentar();
                    break;
                case 2:
                    pet.brincar();
                    break;
                case 3:
                    System.out.println("Por quantas horas " + pet.nome + " deve descansar?");
                    try {
                        int horas = scanner.nextInt();
                        pet.descansar(horas);
                    } catch (InputMismatchException e) {
                        System.out.println("Número de horas inválido. Tente novamente.");
                        scanner.next();
                    }
                    break;
                case 4:
                    pet.levarAoBanheiro();
                    break;
                case 5:
                    pet.darBanho();
                    break;
                case 6:
                    System.out.println("Saindo do Simulador. Adeus, " + pet.nome + "!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    continue;
            }
            pet.passarTempo();
        }

        System.out.println("\n--- FIM DE JOGO ---");
        scanner.close();
    }
}