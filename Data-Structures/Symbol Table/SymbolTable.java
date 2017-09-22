/*null value is not allowed
get() returns null if key is not present
put() overwrites the old value
Best practice to use immutable types for syblo table keys
No duplicates
Elementry implementation-
	unordered linkedlist	
	ordered array	
	
*/
public class ST<Key,Value>{
	ST(){
	}

	void put(Key key,Value val){
	}
	
	Value get(Key key){
	}
	
	//lazy version of delete
	void delete(Key key){
		put(key, null);
	}

	boolean contains(Key key){
		return get(key) != null;
	}

	boolean isEmpty(){
	}

	int size(){
	}
	
	Iterable<Key> keys(){
	}
}
