package Cache_LFU;

public class MainClass {
	public static void main(String args[]) {
		LFUCache cache = new LFUCache(3);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		System.out.println(cache.get(1));
		System.out.println(cache.get(1));
		cache.put(4, 4);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.put(2, 2);
		
	}
}
