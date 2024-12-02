package com.kamil.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
	private List<Block> blockchain = new ArrayList<>();
	private int difficulty = 4; // difficulty level for proof of work
	
	// add methods to add blocks and validate the chain
	public void addBlock(Block newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}
	
	// method to get the current blockchain
	public List<Block> getBlockchain(){
		return blockchain;
	}
	
	// method to validate the integrity of the blockchain
	public boolean isChainValid() {
		for(int i = 1; i < blockchain.size(); i++) {
			Block currentBlock = blockchain.get(i);
			Block previousBlock = blockchain.get(i - 1);
			
			// checking if the current block's hash is correct
			if(!currentBlock.getHash().equals(currentBlock.calculateHash())) {
				return false;
			}
			
			// checking if the current block points to the correct previous block
			if(!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
				return false;
			}
		}
		return true;
	}
}
