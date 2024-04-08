package com.arthur.codes.leetcode.solutiions;

import com.arthur.codes.datastructure.Trie;

import java.util.Arrays;
import java.util.List;


/**
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 *
 * @author: huhao
 * @create: 2024/3/12
 */
public class WordReplace_648_2 {

  class Trie1 extends Trie {

    public String searchPrefix(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char currentChar = word.charAt(i);
        int index = currentChar - 'a';
        if (null != node.children[index]) {
          if (node.children[index].isEnd) {
            return word.substring(0, i + 1);
          }
          node = node.children[index];
        }else {
          return word;
        }
      }
      return word;

    }
  }

  public String replaceWords(List<String> dictionary, String sentence) {
    Trie1 trie1 = new Trie1();
    dictionary.stream().forEach(iterm -> trie1.insert(iterm));
    String[] sentenceWords = sentence.split(" ");
    StringBuilder result = new StringBuilder();
    for(int i=0;i<sentenceWords.length; i++){
      String prefix = trie1.searchPrefix(sentenceWords[i]);
      result.append(prefix).append(" ");
    }
    return result.toString().trim();
  }

  public static void main(String[] args) {
    String[] input = {"cat","bat","rat"};
    String sentence = "the cattle was rattled by the battery";
    WordReplace_648_2 wordReplace6482 = new WordReplace_648_2();
    WordReplace_648_2.Trie1 trie1 = wordReplace6482.new Trie1();
    String result = wordReplace6482.replaceWords(Arrays.asList(input),sentence);

    System.out.println(result);

  }
}
