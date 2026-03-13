import com.google.gson.GsonBuilder;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static ArrayList<Block> blockChain = new ArrayList<Block>();
    public static int difficulty = 5;
    public static void main(String[] args) {
  Block genesisBlock = new Block("first bo  ck","0");
        System.out.println("hash for block 1 :"+ genesisBlock.hash);

    Block SecondBlock = new Block("second block",genesisBlock.hash);
        System.out.println("hash for block 2 :"+SecondBlock.hash);

        Block ThirdBlock = new Block(" hash for third block",SecondBlock.hash);
        System.out.println("hash for block 3"+ ThirdBlock.hash);

    blockChain.add(new Block("first block","0"));
        System.out.println("trying to mine block 1");
        blockChain.get(0).mineBlock(difficulty);
    blockChain.add(new Block("second block",blockChain.get(blockChain.size()-1).hash));
        System.out.println("trying to mine block 2");
        blockChain.get(1).mineBlock(difficulty);
    blockChain.add(new Block("third block",blockChain.get(blockChain.size()-1).hash));
        System.out.println("trying to mine block 3");
        blockChain.get(2).mineBlock(difficulty);
    String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockChainJson);
    }
    public static Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;
        for(int i = 1; i<blockChain.size();i++){
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);
if(!currentBlock.hash.equals(currentBlock.calculateHash())){
    System.out.println("Current Hash not equal");
    return false;
}
if (!previousBlock.hash.equals(currentBlock.calculateHash())){
    System.out.println("prev hash not equal");
    return  false;
}

        }
    return true;
    }

}
