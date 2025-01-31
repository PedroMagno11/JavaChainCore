package br.com.pedromagno;

import br.com.pedromagno.blockchain.domain.Block;
import br.com.pedromagno.blockchain.domain.factory.BlockFactory;

public class Main {
    public static void main(String[] args) {
        Block genesisBlock = BlockFactory.createBlock("Hi i'm the first block", "0");
        System.out.println("Hash for block 1: " + genesisBlock.getHash());

        Block secondBlock = BlockFactory.createBlock("Hi i'm the second block", genesisBlock.getHash());
        System.out.println("Hash for block 2: " + secondBlock.getHash());

        Block thirdBlock = BlockFactory.createBlock("Hi i'm the third block", secondBlock.getHash());
        System.out.println("Hash for block 3: " + thirdBlock.getHash());
    }
}