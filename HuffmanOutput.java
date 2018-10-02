package huffman;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс, отвечающий за вывод информации в файл.
 */
class HuffmanOutput {
    /**
     * @param data - данные(строка)
     * Процедура, записывающая данные в файл,
     * указанный в FileWriter.
     */
    static void write(String data) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\narek\\IdeaProjects\\Huffman Encoding-Decoding\\src\\huffman\\output.txt", true);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
