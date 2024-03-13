package com.arthur.codes.leetcode.solutiions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
public class WordReplace_648 {

    public String replaceWords(List<String> dictionary, String sentence) {

        final StringBuffer resultStrBuff = new StringBuffer();

        String[] sentenceWords = sentence.split(" ");
        Comparator<String> stringComparator = Comparator.comparing(String::length);

        Arrays.asList(sentenceWords).stream().forEach(iterm -> {
            List<String> prefixList = dictionary.stream().filter(x -> {
                return iterm.startsWith(x);
            }).collect(Collectors.toList());
            if(!prefixList.isEmpty()){
                String prefix = prefixList.stream().min(stringComparator).get();
                resultStrBuff.append(prefix);
            }else {
                resultStrBuff.append(iterm);
            }
            resultStrBuff.append(" ");

        });

        return resultStrBuff.toString().trim();
    }



}
