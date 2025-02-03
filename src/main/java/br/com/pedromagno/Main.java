package br.com.pedromagno;

import java.util.ArrayList;

import br.com.pedromagno.blockchain.domain.Block;
import br.com.pedromagno.blockchain.domain.Blockchain;
import br.com.pedromagno.blockchain.service.BlockchainService;
import br.com.pedromagno.blockchain.utils.StringUtil;

public class Main {

    public static ArrayList<Block> blockchain = Blockchain.getInstance().getChain();

    public static void main(String[] args) {

        System.out.println("Tentando minerar o primeiro bloco...");
        BlockchainService.addBlock(new Block("Olá, eu sou o primeiro bloco", "0"));

        System.out.println("Tentando minerar o segundo bloco...");
        BlockchainService.addBlock(new Block("Olá, eu sou o segundo bloco",blockchain.getLast().hash));

        System.out.println("Tentando minerar o terceiro bloco... ");
        BlockchainService.addBlock(new Block("Olá, eu sou o terceiro bloco",blockchain.getLast().hash));

        System.out.println("\nA Blockchain é válida ? " + BlockchainService.isChainValid());

        String blockchainJson = StringUtil.getJson(blockchain);
        System.out.println("\nBlockchain: ");
        System.out.println(blockchainJson);
    }

}