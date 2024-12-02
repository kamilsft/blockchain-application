package com.kamil.blockchain;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blockchain")
@CrossOrigin(origins = "*")
public class BlockchainController {
	
	private final Blockchain blockchain = new Blockchain();
	
	@PostMapping("/addBlock")
	public Block addBlock(@RequestBody Map<String, String> data) {
		String sentData = data.get("data");
		System.out.println("received data: " + sentData); // debug log
		// getting the previous hash or using "0" if its the first block
		String previousHash = blockchain.getBlockchain().isEmpty() ? "0" : blockchain.getBlockchain().get(blockchain.getBlockchain().size() - 1).getHash();
		Block newBlock = new Block(sentData, previousHash);
		blockchain.addBlock(newBlock);
		System.out.println("New block added: " + newBlock); // debug log
		return newBlock;
	}
	
	@GetMapping("/getChain")
	public List<Block> getBlockchain(){
		return blockchain.getBlockchain();
	}
	
	@GetMapping("/isChainValid")
	public boolean isChainValid() {
		return blockchain.isChainValid();
	}
}
