package br.com.pedromagno.blockchain.service;

import br.com.pedromagno.blockchain.domain.Block;
import br.com.pedromagno.blockchain.utils.TextoUtil;

/**
 * Esta classe é reponsável por operações como cálculo de hash, validação e mineração.
 * Aqui deve conter todas as "regras de negócio" referentes a um bloco.
 *
 * @author Pedro Magno <pedromagnopro@gmail.com>
 * @since 30/01/2025
 */

public class BlockService {

    public static String calculateHash(Block block){
        String calculatedHash = TextoUtil.aplicarSha256(block.getPreviousHash() + Long.toString(block.getTimestamp()) + block.getData());
        return calculatedHash;
    }
}
