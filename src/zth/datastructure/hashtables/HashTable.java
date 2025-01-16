package zth.datastructure.hashtables;

public class HashTable {

  private Node[][] data;
  private int size = 0;

  HashTable(int size) {
    data = new Node[size][0];
  }

  void put(String key, int value) {
    Node[] nodes = data[hash(key)];
    if (nodes.length == 0) {
      nodes = new Node[] { new Node(key, value) };
      data[hash(key)] = nodes;
    } else {
      Node[] newNodes = new Node[nodes.length + 1];

      for (int i = 0; i < nodes.length; i++) {
        newNodes[i] = nodes[i];
      }
      newNodes[newNodes.length - 1] = new Node(key, value);
      data[hash(key)] = newNodes;
    }

    size++;
  }

  // complexity o(1) if no collision, with collisions it is O(n)
  int get(String key) throws NullPointerException {
    Node[] nodes = data[hash(key)];

    if (nodes.length > 0) {
      for (int i = 0; i < nodes.length; i++) {
        if (nodes[i].key.equals(key)) {
          return nodes[i].value;
        }
      }
    }
    throw new NullPointerException("No value");
  }

  String[] keys() {

    String[] result = new String[size];

    int resultIndes = 0;

    // complexity o(1) if no collision, with collisions it is O(n^2)
    for (int i = 0; i < data.length; i++) {
      if (data[i].length == 1) {
        result[resultIndes++] = data[i][0].key;
      } else if (data[i].length > 1) {
        for (Node node : data[i]) {
          result[resultIndes++] = node.key;
        }
      }
    }

    return result;
  }

  // should be fast enough, does not depend on current example - O(n)
  private int hash(String key) {
    int hash = 0;
    for (int i = 0; i < key.length(); i++) {
      hash = (hash + key.codePointAt(i) * i) % data.length;
    }
    return hash;
  }

  private static class Node {
    final String key;
    final int value;

    public Node(String key, int value) {
      this.key = key;
      this.value = value;
    }

  }

  public static void main(String[] args) {
    var map = new HashTable(2);

    map.put("aaaaaa", 1000);
    map.put("bbbbbb", 2000);
    map.put("cccc", 10);
    map.put("ddd", 0);

    String[] keys = map.keys();

    map.get("aaaaaa");
    map.get("bbbbbb");
    map.get("cccccc");

  }
}
