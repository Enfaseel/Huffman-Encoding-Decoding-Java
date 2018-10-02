package huffman;

/**
 * Класс, реализующий сравнивание двух
 * близких по частоте букв, а также
 * описывающий экземпляр класса.
 */
class Node extends HuffmanTree {
    final HuffmanTree left, right;

    Node(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}