package structures;

/**
 * An easy way to store key/value pairs. We assume that other
 * classes will access fields directly.
 * 
 * @author Samuel A. Rebelsky
 */
class KVPair<K, V> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.
   */
  private K key;

  /**
   * The value.
   */
  private V value;

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

  /*
   * Creates a copy of a KVPair
   */
  public KVPair<K, V> clone() {
    return new KVPair<K, V>(this.key, this.value);
  } // clone()

  /*
   * Converts a KVPair to string
   */

  public String toString() {
    return "{ " + this.key.toString() + " : " + this.value.toString() + " }";
  } // toString()

  /*
   * Retrieves the current key
   */

  public K getKey() {
    return this.key;
  } // getKey()

  /*
   * Retrieves the current value
   */

  public V getValue() {
    return this.value;
  } // getValue
  
  /*
   * Sets the current value to value
   */

  public V setValue(V value) {
    return this.value = value;
  } // setValue
} // class KVPair
