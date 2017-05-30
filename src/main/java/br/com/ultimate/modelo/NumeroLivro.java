package br.com.ultimate.modelo;

/**
 * Created by Gustavo on 27/05/2017.
 * ENUM responsável por representar o número de cada livro
 */
public enum NumeroLivro {

    LIVRO_1(1), LIVRO_2(2), LIVRO_3(3), LIVRO_4(4);

    private int livro;

    NumeroLivro(int livro){
        this.livro = livro;
    }

    public int getNumeroLivro(){
        return this.livro;
    }
}
