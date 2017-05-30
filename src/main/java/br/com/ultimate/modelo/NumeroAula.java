package br.com.ultimate.modelo;

/**
 * Created by Gustavo on 27/05/2017.
 * ENUM responsável por representar o número de aulas para todos os livros
 */
public enum NumeroAula {

    AULA_1(1), AULA_2(2), AULA_3(3), AULA_4(4), AULA_5(5), AULA_6(6), AULA_7(7), AULA_8(8), AULA_9(9), AULA_10(10);

    private int aula;

    NumeroAula(int aula){
        this.aula = aula;
    }

    public int getNumeroAula(){
        return this.aula;
    }
}
