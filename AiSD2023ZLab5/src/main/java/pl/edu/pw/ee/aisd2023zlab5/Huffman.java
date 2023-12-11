package pl.edu.pw.ee.aisd2023zlab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class Huffman {

    private Node root;
    private Heap NodeOfList;
    private String pathToFile;
    private String codeBinaryTree;
    private String textFromFile;

    private String pathToFileTree = "src/main/file/tree.txt";

    public Huffman() {
        NodeOfList = new Heap();
    }

    public String codeHuffman(String pathToFile) {
        WriteAndRead.checkFileExist(pathToFile);
        this.pathToFile = pathToFile;
        
            readTextFile();

            buildHuffmanTree();

            codeBinaryTree = changeTreeToBinaryTree();
            
            WriteAndRead.writeFileBinary(pathToFileTree, codeBinaryTree);
            String decodeTree = WriteAndRead.readFileBinary(pathToFileTree);

        return decodeTree;
    }

    private void readTextFile() {
        WriteAndRead.checkFileExist(pathToFile);

        try (FileReader fileReader = new FileReader(pathToFile, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(fileReader);) {

            int character;
            textFromFile = "";

            while ((character = reader.read()) != -1) {
                textFromFile += (char) character;

                addToNodes((char) character, 1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (NodeOfList.getSize() == 0) {
            throw new IllegalArgumentException("Empty File");
        }
    }

   public void buildHuffmanTree() {


        while (NodeOfList.getSize() > 1) {


            Node left = NodeOfList.pop();
            Node right = NodeOfList.pop();


            NodeOfList.push(new Node(left, right, left.getFreq() + right.getFreq()));
        }

        root = NodeOfList.get(0);
    }

   public void addToNodes(char character, int numOfChars) {
        Node nodeToFind = new Node(null, null, 1, character);
        boolean nodeFound = false;

        for (int i = 0; i < NodeOfList.getSize(); i++) {
            if (nodeToFind.equals(NodeOfList.get(i))) {
                nodeFound = true;
                Node nodeToUpdate = NodeOfList.get(i);
                NodeOfList.remove(i);
                nodeToUpdate.setFreq(nodeToUpdate.getFreq() + numOfChars);
                NodeOfList.push(nodeToUpdate);
                break;
            }
        }

        if (!nodeFound) {
            NodeOfList.push(new Node(null, null, numOfChars, character));
        }
   }

    
    public String changeTreeToBinaryTree() {
        StringBuilder stringBuilder = new StringBuilder();
        createBinaryTree(root, "", stringBuilder);
        return stringBuilder.toString();
    }
    
    private void createBinaryTree(Node node, String code, StringBuilder stringBuilder) {
        if (node != null) {
            if (node.isLeaf()) {
                stringBuilder.append("1");
                stringBuilder.append(code);
            } else {
                stringBuilder.append("0");
                createBinaryTree(node.getLeft(), code + "0", stringBuilder);
                createBinaryTree(node.getRight(), code + "1", stringBuilder);
            }
        }
    }
    public int calculateTreeCost() {
        if (root == null) {
            return 0;
        }

        int totalCost = 0;
        List<Node> nodeList = new ArrayList<>();
        List<Integer> depthList = new ArrayList<>();

        nodeList.add(root);
        depthList.add(0);

        while (!nodeList.isEmpty()) {
            Node currentNode = nodeList.remove(0);
            int currentDepth = depthList.remove(0);

            if (currentNode.isLeaf()) {
                totalCost += currentNode.getFreq() * currentDepth;
            } else {
                if (currentNode.getLeft() != null) {
                    nodeList.add(currentNode.getLeft());
                    depthList.add(currentDepth + 1);
                }
                if (currentNode.getRight() != null) {
                    nodeList.add(currentNode.getRight());
                    depthList.add(currentDepth + 1);
                }
            }
        }
        return totalCost;
    }


}