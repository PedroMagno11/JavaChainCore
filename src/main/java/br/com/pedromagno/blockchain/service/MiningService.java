package br.com.pedromagno.blockchain.service;

import br.com.pedromagno.blockchain.domain.Block;
import br.com.pedromagno.blockchain.domain.Blockchain;
import br.com.pedromagno.blockchain.utils.StringUtil;

/**
 * Esta classe é reponsável pela mineração de um bloco.
 *
 * @author Pedro Magno <pedromagnopro@gmail.com>
 * @since 30/01/2025
 */

public class MiningService {

    // Aumenta o valor nonce até que o alvo do hash seja atingido.
    public static void mineBlock(Block block) {
        String target = StringUtil.getDificultyString(Blockchain.DIFICULDADE); // Cria uma string com dificuldade * "5";
        while (!block.getHash().substring(0,Blockchain.DIFICULDADE).equals(target)){
            block.setNonce(block.getNonce() + 1);
            block.setHash(block.calculateHash());
        }

//        System.out.println("Bloco minerado!" + block.getHash());
    }

}
