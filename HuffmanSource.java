package huffman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanSource {
    static HashMap<Character, Integer> charFreq = new HashMap<>();
    /**
     * Прежде чем приступить к реализации алгоритма
     * кодирования/декодирования по Хаффману считываем
     * input файл, а также вызов исключений
     * в случае его отсутствия.
     */
    public static void main(String[] args) throws FileNotFoundException {
        double startTime = System.currentTimeMillis();
        FileReader reader = new FileReader("C:\\Users\\narek\\IdeaProjects\\Huffman Encoding-Decoding\\src\\huffman\\input.txt");
        StringBuilder tempLine = new StringBuilder();
        try {
            int c;
            while ((c = reader.read()) != -1) {

                tempLine.append((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        String inputLine = tempLine.toString();

        for (char c : inputLine.toCharArray()) {
            if (charFreq.containsKey(c)) {
                charFreq.put(c, charFreq.get(c) + 1);
            } else {
                charFreq.put(c, 1);
            }
        }
        HuffmanTree tree = HuffmanCoder.buildTree(charFreq);


        System.out.println("SYMBOL\tWEIGHT\tHUFFMAN CODE");
        HuffmanCoder.printCodes(tree, new StringBuffer());
        System.out.println("Общая длина текста = " + inputLine.length());

        String encodedLine = HuffmanCoder.encode(HuffmanCoder.charToCode, inputLine.toCharArray());

        System.out.println("Длина закодированной строки = " + encodedLine.length());
        System.out.println("Количество единиц = " + (encodedLine.length() - HuffmanCoder.amountOfZero(encodedLine)) + "\nКоличество нулей = " + (HuffmanCoder.amountOfZero(encodedLine)));

        String decodedLine = HuffmanDecoder.decode(HuffmanCoder.codeToChar, encodedLine.toCharArray());

        double symbolsPerWord = (double) encodedLine.length() / inputLine.length();
        System.out.println("Среднее количество символов на кодирование 1 буквы = " + symbolsPerWord);
//        HuffmanOutput.write(encodedLine);
        HuffmanOutput.write(decodedLine);
        double timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Программа выполнялась " + timeSpent/1000 + " с");
    }
}
