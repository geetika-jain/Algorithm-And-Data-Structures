package DataStructures;

public class Trie {
    public static int n=26;
    static TrieNode root;

    Trie(){
        root=new TrieNode();
    }

    public static void main(String[] args){
        Trie trie=new Trie();

        trie.insert("geet");
        trie.insert("rishi");
        System.out.println(trie.search("geet"));
        System.out.println(trie.search("rishiz"));


    }

    void insert(String key){
        int level;
        int length =key.length();
        int index;
        TrieNode node=root;
        for(level=0;level<length; level++){
            index=key.charAt(level)-'a';
            if(node.child[index]==null)
                node.child[index] = new TrieNode();
            node=node.child[index];
        }
        node.isEndOfWord=true;
    }

    boolean search(String key){
        int level;
        int length =key.length();
        int index;
        TrieNode node=root;
        for(level=0;level<length; level++){
            index=key.charAt(level)-'a';
            if(node.child[index]==null)
                return  false;
            node=node.child[index];
        }

        return (node.isEndOfWord);
    }

    public class TrieNode{
        boolean isEndOfWord;
        TrieNode[] child;

        TrieNode(){
            child=new TrieNode[n];

            for(int i=0;i<n;i++){
                child[i]=null;
            }
            isEndOfWord=false;
        }

    }
}
