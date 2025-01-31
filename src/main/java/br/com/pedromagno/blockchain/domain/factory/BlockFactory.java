package br.com.pedromagno.blockchain.domain.factory;


import br.com.pedromagno.blockchain.domain.Block;
import br.com.pedromagno.blockchain.service.BlockService;

/**
 * Esta classe é responsável por construir instâncias padronizadas
 * de objetos da classe Block.
 *
 * Todos os objetos da classe Block devem ser instanciados aqui.
 *
 * @author Pedro Magno
 * @since 30/01/2025
 */
public class BlockFactory {
    // Cria uma instância padronizada do Block
    public static Block createBlock(String data, String previousHash){
        Block block = new Block(data, previousHash);
        block.setHash(BlockService.calculateHash(block));
        return block;
    }

}
