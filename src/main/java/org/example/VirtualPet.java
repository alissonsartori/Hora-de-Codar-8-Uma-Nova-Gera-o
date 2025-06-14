package org.example;

class VirtualPet {
    String nome;
    int nivelDeFome;
    int nivelFelicidade;
    int nivelDeCansaco;
    int idade;
    int vontadeBanheiro;
    int nivelDeSujeira;

    public VirtualPet(String nome) {
        this.nome = nome;
        this.nivelDeFome = 50;
        this.nivelFelicidade = 50;
        this.nivelDeCansaco = 0;
        this.idade = 0;
        this.vontadeBanheiro = 0;
        this.nivelDeSujeira = 0;
    }

    public void alimentar() {
        this.nivelDeFome -= 15;
        this.vontadeBanheiro += 10;
        if (this.nivelDeFome < 0) this.nivelDeFome = 0;
        System.out.println(nome + " foi alimentado. Nível de fome diminuiu, mas a vontade de ir ao banheiro aumentou.");
    }

    public void brincar() {
        this.nivelFelicidade += 20;
        this.nivelDeCansaco += 15;
        this.nivelDeSujeira += 10;
        if (this.nivelFelicidade > 100) this.nivelFelicidade = 100;
        System.out.println(nome + " está brincando! Felicidade aumentou, mas também o cansaço e a sujeira.");
    }

    public void descansar(int horas) {
        if (horas >= 8) {
            this.nivelDeCansaco = 0;
            System.out.println(nome + " teve um ótimo descanso de " + horas + " horas e está completamente recuperado!");
        } else {
            this.nivelDeCansaco -= horas * 10;
            if (this.nivelDeCansaco < 0) this.nivelDeCansaco = 0;
            System.out.println(nome + " descansou por " + horas + " horas. O cansaço diminuiu.");
        }
    }

    public void levarAoBanheiro() {
        this.vontadeBanheiro = 0;
        System.out.println("Ufa! " + nome + " foi ao banheiro e se sente aliviado.");
    }

    public void darBanho() {
        this.nivelDeSujeira = 0;
        System.out.println("Que banho gostoso! " + nome + " está limpinho agora.");
    }

    public void verificarStatus() {
        System.out.println("\n--- Status atual de " + nome + " ---");
        System.out.println("Idade: " + idade + " dias");
        System.out.println("Fome: " + nivelDeFome + "/100");
        System.out.println("Felicidade: " + nivelFelicidade + "/100");
        System.out.println("Cansaço: " + nivelDeCansaco + "/100");
        System.out.println("Vontade de ir ao Banheiro: " + vontadeBanheiro + "/100");
        System.out.println("Nível de Sujeira: " + nivelDeSujeira + "/100");
        System.out.println("------------------------------------");
    }

    public void passarTempo() {
        System.out.println("\n...Um dia se passou...");
        this.idade++;
        this.nivelDeFome += 5;
        this.nivelDeCansaco += 10;
        this.nivelFelicidade -= 3;
    }

    public boolean estaVivo() {
        if (nivelDeFome >= 100) {
            System.out.println("GAME OVER! " + nome + " desmaiou de fome.");
            return false;
        }
        if (nivelDeCansaco >= 100) {
            System.out.println("GAME OVER! " + nome + " desmaiou de cansaço.");
            return false;
        }
        if (nivelFelicidade <= 0) {
            System.out.println("GAME OVER! " + nome + " fugiu de tanta tristeza.");
            return false;
        }
        if (vontadeBanheiro >= 100) {
            System.out.println("GAME OVER! " + nome + " teve um acidente... que sujeira!");
            return false;
        }
        if (nivelDeSujeira >= 100) {
            System.out.println("GAME OVER! " + nome + " ficou doente por falta de higiene.");
            return false;
        }
        return true;
    }

    public boolean verificarVitoria() {
        if (idade >= 50) {
            System.out.println("PARABÉNS! Você cuidou de " + nome + " muito bem e ele chegou à idade de 50 dias! VOCÊ VENCEU!");
            return true;
        }
        return false;
    }
}