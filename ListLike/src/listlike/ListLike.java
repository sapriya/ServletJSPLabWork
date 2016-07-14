/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listlike;
import java.util.Iterator;

/**
 *
 * @author sapriya
 */

class StorageFull extends Exception{
    StorageFull(){
    System.out.println("Storage is full");
    }
}

class Sequence <E> implements Iterable <E>{
    private int count=0;
    private final String[] seq; //Assumption for the code purpose: Straitng the index of array from 1
    
    Sequence(int s){
    seq = new String[s];
    }
    
    void add(Object o){
        try {
         if(count<seq.length-1){
         seq[count++] = (String) o; // Add item
         
         }else{
             throw new StorageFull();
         }
        }catch (Exception e){
        }
    }
    
    String getIndex(Object idx){
     return seq[(int)idx];
    }
    
    int getSize(){
     return seq.length;
    }
    
    @Override
    public SequenceIterator<E> iterator() {
        return new SequenceIterator<E>();
    }
    
    //Limit capacity data storage method using Iterator
    public class SequenceIterator <T> implements Iterator<T>{
        
        private int trackStorage;
        
        @Override
        public boolean hasNext(){
            return trackStorage<count;       
        }
        
        @Override
        public T next(){ return  (T) seq[trackStorage++];
        }
        
        @Override
        public void remove(){} //Could be implemented to remove specific element from array 
    }
}

public class ListLike {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
//        Sequence s = new Sequence();
//        assert s.size() == 0;
//        s.add("Hello");
//        s.add("there");
//        assert s.size() == 2;
//        assert s.get(0).equals("Hello");
//        assert s.get(1).equals("there");
//        s.add("done");
//        assert s.size() == 3;
//        assert s.get(0).equals("Hello");
//        assert s.get(1).equals("there");
//        assert s.get(2).equals("done");
        Sequence<String> s = new Sequence<String>(5);
        s.add("Hello");
        s.add("there");
        s.add("done");
        Iterator i1 = s.iterator();
        Iterator i2 = s.iterator();
        assert i1.hasNext();
        assert i1.next().equals("Hello");
        assert i1.hasNext();
        assert i1.next().equals("there");
        assert i2.hasNext();
        assert i2.next().equals("Hello");
        assert i1.hasNext();
        assert i1.next().equals("done");
        assert i1.hasNext() == false;
        assert i2.next().equals("there");
        assert i2.next().equals("done");
        assert i2.hasNext() == false;
        for(String o : s){
        System.out.println(o);
        }
        }catch (Exception e){
            System.out.println("Assertion Error");
        }
    }
        
}
    
