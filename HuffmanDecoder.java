package huffman;

import java.util.HashMap;

/**
 * Класс, отвечающий за декодирование
 * бинарного кода в символы.
 */
class HuffmanDecoder {

    /**
     * @param map - алфавит, представленный HashMap <код, символ>
     * @param inputLine - входящая строка, преобразованная в массив символов
     * @return возвращает декодированную строку.
     */
    static String decode(HashMap map, char[] inputLine) {
        StringBuilder output = new StringBuilder();
        String code = "";
        for (int i = 0; i<inputLine.length;) {
            if (map.containsKey(code)) {
                output.append(map.get(code));
                code = "";
            } else {
                code += inputLine[i];
                i++;
            }
        }
        output.append(map.get(code));

        return output.toString();
    }

}
