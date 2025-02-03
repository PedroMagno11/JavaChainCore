package br.com.pedromagno.blockchain.service;

import br.com.pedromagno.blockchain.domain.Block;
import br.com.pedromagno.blockchain.domain.Blockchain;

/**
 * Esta classe é reponsável por adicionar bloco e verificar se a blockchain é válida.
 *
 * @author Pedro Magno <pedromagnopro@gmail.com>
 * @since 01/02/2025
 */

public class BlockchainService {

    private static final Blockchain blockchain = Blockchain.getInstance();

    public static void addBlock(Block newBlock) {
        MiningService.mineBlock(newBlock);
        blockchain.getChain().add(newBlock);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[Blockchain.DIFICULDADE]).replace('\0', '0');

        //Percorre toda a blockchain para verificar os hashes
        for(int i=1; i < blockchain.getChain().size(); i++) {
            currentBlock = blockchain.getChain().get(i);
            previousBlock = blockchain.getChain().get(i-1);

            //Compara o hash registrado com o hash calculado
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("O hash atual é diferente do hash calculado");
                return false;
            }

            //Compara o hash anterior com o previous hash registrado
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("O hash anterior é diferente do previous hash");
                return false;
            }

            //verifica se o hash que foi atribuido foi minerado
            if(!currentBlock.hash.substring(0, Blockchain.DIFICULDADE).equals(hashTarget)) {
                System.out.println("Este bloco não foi minerado");
                return false;
            }

        }
        return true;
    }
}
