package br.com.pedromagno.blockchain.domain;

import br.com.pedromagno.blockchain.utils.StringUtil;
import java.util.Date;

/**
 * Cada bloco em uma blockchain tem sua própria "impressão digital", contém
 * a "impressão digital" do bloco anterior e alguns dados como transações, por
 * exemplo.
 *
 * Hash = "impressão digital"
 *
 * Cada bloco contém o hash do bloco anterior e seu próprio hash.
 *
 * @author Pedro Magno <pedromagnopro@gmail.com>
 * @since 30/01/2025
 */

public class Block {

    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp; // tempo em millisegundos desde 01/01/1970
    private int nonce;


    public Block(String data,String previousHash ) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();

        this.hash = calculateHash();
    }

    //Calcula o novo hash baseado no conteúdo do block
    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }


    public String getData() {
        return data;
    }


    public long getTimeStamp() {
        return timeStamp;
    }


    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
}