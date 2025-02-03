package br.com.pedromagno.blockchain.domain;


import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private static Blockchain instance;
    private ArrayList<Block> chain;

    /* Dificuldade -> O quão difícil é para encontrar um bloco.
     * Neste caso, a quantidade de zeros que devem ser resolvidos
     * para minerar um bloco.
     */
    public static int DIFICULDADE = 5;

    private Blockchain(){
        chain = new ArrayList<>();
    }

    public static Blockchain getInstance(){
        if(instance == null){
            instance = new Blockchain();
        }
        return instance;
    }

    public ArrayList<Block> getChain(){
        return chain;
    }

}
