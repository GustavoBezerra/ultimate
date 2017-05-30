package br.com.ultimate.modelo;

/**
 * Created by Gustavo on 27/05/2017.
 * Classe responsável por representar a nota de um aluno no final da aula
 */
public class Nota {

    private Aluno aluno;
    private float notaCompreensao;
    private float notaConversacao;
    private float notaParticipacao;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public float getNotaCompreensao() {
        return notaCompreensao;
    }

    public void setNotaCompreensao(float notaCompreensao) {
        this.notaCompreensao = notaCompreensao;
    }

    public float getNotaConversacao() {
        return notaConversacao;
    }

    public void setNotaConversacao(float notaConversacao) {
        this.notaConversacao = notaConversacao;
    }

    public float getNotaParticipacao() {
        return notaParticipacao;
    }

    public void setNotaParticipacao(float notaParticipacao) {
        this.notaParticipacao = notaParticipacao;
    }

    /**
     * Método responsável por calcular a nota final de um aluno
     * @return Soma das notas de compreensão, conversação e participação
     */
    public float getNotaFinal(){
        return notaCompreensao + notaConversacao + notaParticipacao;
    }
}
