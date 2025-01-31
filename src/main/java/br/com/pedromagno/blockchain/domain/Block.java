package br.com.pedromagno.blockchain.domain;

import br.com.pedromagno.blockchain.service.BlockService;

import java.util.Date;

/**
 * @author Pedro Magno <pedromagnopro@gmail.com>
 * @since 30/01/2025
 */

public class Block {
    private String hash;
    private String previousHash;
    private String data; // o nosso dado será uma simples mensagem
    private long timestamp; // millisegundos desde 01/01/1970

    // Contrutor do bloco
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime(); // tempo em milissegundos desde 01/01/1970
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

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
