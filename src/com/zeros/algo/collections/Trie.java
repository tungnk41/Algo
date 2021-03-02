package com.zeros.algo.collections;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root;
    Trie(){
        this.root = new TrieNode();
    }

    private void insert(String word){
        TrieNode current = root;
        for (char c : word.toCharArray()){
            if(!current.egdes.containsKey(c)){
                current.egdes.put(c,new TrieNode());
            }
            current = current.egdes.get(c);
        }
        current.isWordEnd = true;
    }

    private boolean search(String word){
        TrieNode current = root;
        for(char c : word.toCharArray()){
            if(!current.egdes.containsKey(c)){
                return false;
            }
            current = current.egdes.get(c);
        }
        return current.isWordEnd;
    }

    public static void run(){
        Trie trie = new Trie();
        trie.insert("abcer");
        trie.insert("abczx");
        System.out.println(trie.search("abced"));
    }
    class TrieNode{
        Map<Character,TrieNode> egdes;
        boolean isWordEnd = false;
        TrieNode(){
            this.egdes = new HashMap<>();
            this.isWordEnd = false;
        }
    }


}
