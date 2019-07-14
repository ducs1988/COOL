import java.util.Collections;
import java.util.List;

/**
 * 642. Design Search Autocomplete System
 * https://leetcode.com/problems/design-search-autocomplete-system/
 */

class AutocompleteSystem {
    class Node {
        String sentence;
        int times;
        public Node(String str, int t) {
            sentence = str;
            times = t;
        }
    }

    class Trie {
        int times;
        Trie[] branches = new Trie[27]; // a-z and white space
    }

    private Trie root;
    private cur_sent = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; ++i) {
            insert(root, sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            insert(root, cur_sent, 1);
            cur_sent = "";
        } else {
            cur_sent += c;
            List<Node> list = lookup(cur_sent, root);
            Collections.sort(list, new Comparator<Node>(){
                public int compare(Node a, Node b) {
                    if (a.times == b.times)
                        return a.sentence.compareTo(b.sentence);
                    return b.times - a.times;
                }
            });
            for (int i = 0; i < Math.min(list.size(), 3); ++i) {
                res.add(list.get(i).sentence);
            }
        }

        return res;
    }


    private List<Node> lookup(String s, Trie node) {
        List<Node> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (node.branches[int_(c)] == null)
                return new ArrayList<>();
            node = node.branches[int_(c)];
        }
        help(list, node, s);
        return list;
    }

    private void help(List<Node> list, Trie node, String s) {
        if (node.times > 0)
            list.add(node);
        for (char c = 'a'; c <= 'z'; ++c) {
            if (node.branches[c-'a'] != null)
                help(list, node.branches[c-'a'], s + c);
        }
        if (node.branches[26] != null)
            help(list, node.branches[26], s + ' ');
    }

    private void insert(Trie node, String s, int t) {
        for (char c : s.toCharArray()) {
            if (node.branches[int_(c)] == null)
                node.branches[int_(c)] = new Trie();
            node = node.branches[int_(c)];
        }
        node.times += t;
    }

    private int int_(char c) {
        return c == ' ' ? 26 : c-'a';
    }
}