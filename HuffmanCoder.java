package huffman;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Класс, реализующий такие функции, как
 * построение дерева, формирование и вывод
 * двоичного кода для каждого символа,
 * непосредственно кодирование и подсчет
 * количества нулей в кодированной строке.
 */
class HuffmanCoder {
    static HashMap<Character, String> charToCode = new HashMap<>();
    static HashMap<String, Character> codeToChar = new HashMap<>();

    /**
     * @param charFreqs HashMap <буква, частота буквы>
     * @return возвращает построенное дерево в зависимости от
     * полученного количества символов и их частоты.
     */
    static HuffmanTree buildTree(HashMap charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();

        for (Object o : charFreqs.entrySet()) {
            HashMap.Entry pair = (HashMap.Entry) o;
            trees.offer(new HuffmanLeaf((int) pair.getValue(), (char) pair.getKey()));
        }

        assert trees.size() > 0;

        while (trees.size() > 1) {

            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();


            assert b != null;
            trees.offer(new Node(a, b));
        }
        return trees.poll();
    }


    /**
     * Процедура, выводящая в консоль закодированные символы
     * в формате "буква -  частота буквы - код буквы"
     * А так же заполняющий 2 алфавита(HashMap'а),
     * необходимых для кодирования/декодирования.
     * @param tree - дерево с лепестками(буквами)
     * @param prefix - двоичный код символа
     */
    static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            System.out.println(leaf.value + "\t\t" + HuffmanSource.charFreq.get(leaf.value) + "\t\t" + prefix);

            String chars = new String(prefix);
            charToCode.put(leaf.value, chars);
            codeToChar.put(chars, leaf.value);
        } else if (tree instanceof Node) {
            Node node = (Node) tree;
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);


            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }

    }

    /**
     * Функция, кодирующая входящую строку в двоичный код в соответствии с входящим алфавитом.
     * @param alphabet - HashMap <буква, двоичный код>
     * @param inputLine - входящая строка
     * @return возвращает закодированную строку
     */
    static String encode(HashMap alphabet, char[] inputLine) {
        StringBuilder output = new StringBuilder();
        for (char anInputLine : inputLine) {
            output.append(alphabet.get(anInputLine));
        }
        return output.toString();
    }

    /**
     * Функция, подсчитывающая количество нулей во входящей строке.
     * @param encodedLine - закодированная строка
     * @return возвращает количество нулей в строке
     */
    static int amountOfZero (String encodedLine) {
        int countOfZero = 0;
        for (char c : encodedLine.toCharArray()) {
            if (c == '0') countOfZero+=1;
        }
        return countOfZero;
    }
}


