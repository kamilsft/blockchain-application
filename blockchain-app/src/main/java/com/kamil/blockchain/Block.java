package com.kamil.blockchain;

import java.security.MessageDigest;
import java.security.Security;
import java.util.Map;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Block {
	private String hash;
	private String previousHash;
	private String data;
	private long timeStamp; // as number of milliseconds 
	private int nonce;
	
	/*
	 *  implementation of a hashing logic using 
	 *  Bouncy Castle
	 */
	
	// static block to register bouncy castle as a security provider
	static {
		Security.addProvider(new BouncyCastleProvider());
	}	
	
	// constructor
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = System.currentTimeMillis();
		this.hash = calculateHash(); // initial hash calculation
	}
	
	// method to calculate the hash of the block
	public String calculateHash() {
		String input = previousHash + Long.toString(timeStamp) + data + nonce;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256"); // use bouncy castle for SHA-256
			byte[] hashBytes = digest.digest(input.getBytes());
			StringBuilder hexString = new StringBuilder();
			for (byte b : hashBytes) {
				hexString.append(String.format("%02x", b)); // converting bytes to hex
			}
			return hexString.toString();
		} catch(Exception e) { 
			throw new RuntimeException(e);
		}
	}
	
	// getters and setters
	public String getHash() {
		return hash;
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
	
	// method to mine the block with proof of work
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); // Create a string with difficulty * "0"
		while(!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
	}
	
	
}
