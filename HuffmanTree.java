package huffman;

/**
 * Описание экземпляра абстрактного класса, и метода
 * сравнения, необходимого для функционирования
 * класса Node.
 */
abstract public class HuffmanTree implements Comparable<HuffmanTree> {
    final int frequency;
    HuffmanTree(int freq) { frequency = freq; }
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}
