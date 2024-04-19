package structures;


/**
 * An easy way to store key/value pairs.  We assume that other
 * classes will access fields directly.
 */
class KVPair<K,V> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.
   */
  K key;

  /**
   * The value.
   */
  V value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create an empty key/value pair.
   */
  KVPair() {
    this(null, null);
  } // KVPair()

  /**
   * Create a new key/value pair.
   */
  KVPair(K key, V value) {
    this.key = key;
    this.value = value;
  } // KVPair(K,V)

  // +------------------+--------------------------------------------
  // | Standard methods |
  // +------------------+

  public KVPair<K,V> clone() {
    return new KVPair<K,V>(this.key, this.value);
  } // clone()

  public String toString() {
    return "{ " + this.key.toString() + " : " + this.value.toString() + " }";
  } // toString()
} // class KVPair

/**
   * Retrieves all of the keys in the associative array. 
   */
  public String[] getAllKeys() {
    String[] arr = new String[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = pairs[i].key.toString();
      }
    return arr;
    }
