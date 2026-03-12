import com.google.gson.GsonBuilder;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static ArrayList<Block> blockChain = new ArrayList<Block>();
    public static void main(String[] args) {
  Block genesisBlock = new Block("first bo  ck","0");
        System.out.println("hash for block 1 :"+ genesisBlock.hash);

    Block SecondBlock = new Block("second block",genesisBlock.hash);
        System.out.println("hash for block 2 :"+SecondBlock.hash);

        Block ThirdBlock = new Block(" hash for third block",SecondBlock.hash);
        System.out.println("hash for block 3"+ ThirdBlock.hash);

    blockChain.add(new Block("first block","0"));
    blockChain.add(new Block("second block",blockChain.get(blockChain.size()-1).hash));
    blockChain.add(new Block("third block",blockChain.get(blockChain.size()-1).hash));
String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockChainJson);
    }
}
