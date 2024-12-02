# Blockchain Functions

## Overview
This project is a lightweight implementation of core blockchain functionalities in Java. It includes foundational concepts like block creation, hashing, proof-of-work, and chain validation. The purpose of this project is to demonstrate how a blockchain operates through simple, functional code.

---

## Features
- **Block Creation**:
  - Each block contains:
    - Data
    - Previous block hash
    - Timestamp
    - Proof-of-work nonce
  - Blocks are hashed using the SHA-256 algorithm.
- **Blockchain Management**:
  - Add new blocks to the chain with proof-of-work.
  - Validate the integrity of the blockchain to ensure immutability.
- **RESTful API**:
  - Provides endpoints to interact with the blockchain for testing purposes.

---

## Technologies Used
- **Programming Language**: Java
- **Hashing Algorithm**: SHA-256 (via Bouncy Castle Provider)
- **REST API**: Spring Boot (optional for testing)
- **Build Tool**: Maven


---

## How to Use
This project is intended as a library of blockchain functions that can be used in other Java projects or explored for educational purposes.

### Key Functionalities
1. **Block Creation**:
   - Create a block with data and link it to the previous block using its hash.
   - Example:
     ```java
     Block block = new Block("Some data", "previousBlockHash");
     block.mineBlock(4); // Proof-of-work with difficulty 4
     System.out.println(block.getHash());
     ```
2. **Blockchain Management**:
   - Add blocks to a blockchain and validate the chain.
   - Example:
     ```java
     Blockchain blockchain = new Blockchain();
     blockchain.addBlock(new Block("First Block", "0")); // Genesis block
     blockchain.addBlock(new Block("Second Block", blockchain.getBlockchain().get(0).getHash()));
     System.out.println("Is blockchain valid? " + blockchain.isChainValid());
     ```
3. **REST API**:
   - Use Spring Boot to expose blockchain operations as RESTful APIs.

---

## API Endpoints
If used with Spring Boot:
| HTTP Method | Endpoint                        | Description                             |
|-------------|---------------------------------|-----------------------------------------|
| POST        | `/api/blockchain/addBlock`      | Adds a new block to the blockchain.     |
| GET         | `/api/blockchain/getChain`      | Retrieves the entire blockchain.        |
| GET         | `/api/blockchain/isChainValid`  | Checks if the blockchain is valid.      |

---

## Prerequisites
1. Java 17+ installed on your machine.
2. Maven installed and configured.




