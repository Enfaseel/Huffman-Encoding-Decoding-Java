package huffman;

/**
 * Класс, описывающий лепестки дерева Хаффмана.
 */
class HuffmanLeaf extends HuffmanTree {
    final char value;

    HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}
