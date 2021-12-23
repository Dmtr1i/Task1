package Repository;

import Contracts.Contract;
import Sorts.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;

public class Repository <T extends Contract> {
    /*
    Private fields for storage data
     */
    private T[] contracts;
    private int size;
    private ISorter<T> sorter = new BubbleSort<>();
    /*
    Constructor
     */
    public Repository(){
        size = 0;
        contracts = (T[]) new Contract[10];
    }
    /*
    * This method returns sorter
    * */
    public ISorter<T> getSorter() {
        return sorter;
    }
    /*
    * This method sets sorter
    * */
    public void setSorter(ISorter<T> sorter) {
        this.sorter = sorter;
    }
    /*
    this method adds new contract to repository
     */
    public void add(T contract){
        if (isEmpty()) contracts[0] = contract;
        else {
            if (size == contracts.length) {
                T[] copy = (T[]) new Contract[contracts.length*2];
                System.arraycopy(contracts, 0, copy, 0, contracts.length);
                copy[contracts.length] = contract;
                contracts = copy;
            }
            else contracts[size] = contract;
        }
        size += 1;
    }
    /*
    This method returns true if method if repository is empty and false if repository is not empty
    */
    public boolean isEmpty(){return size==0;}
    /*
    this method prints all contracts of the repository
     */
    public void print(){ for(int i = 0; i < size; i++) System.out.println(contracts[i]); }
    /*
    this method returns size of the repository
     */
    public int getSize(){ return size; }
    /*
    this method returns contract by the ID
     */
    public T getById(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (contracts[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) return null;
        else return (T)contracts[index];
    }
    /*
    * this method returns contract by the index
    * */
    public T getByIndex(int index) { return (T)contracts[index];}
    /*
    this method clear repository
     */
    public void clear(){
        contracts = (T[]) new Contract[10];
        size = 0;
    }
    /*
    this method delete contract by the ID
     */
    public boolean remove(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (contracts[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        else {
            Contract[] copy = new Contract[size-1];
            System.arraycopy(contracts, 0, copy, 0, index);
            System.arraycopy(contracts, index + 1, copy, index, size - index - 1);
            contracts = (T[])copy;
            size -= 1;
            return true;
        }
    }
    /*
    * search value in repository by criteries
    */
    public Repository<T> search(Predicate<T> predicate) {
        Repository<T> result = new Repository<T>();
        for (int i = 0; i < size; i++) {
            if (predicate.test((T)contracts[i]))
                result.add((T)contracts[i]);
        }
        return result;
    }
    /*
    * this method sets contract by index
    * */
    public void set(int id, T contract) {
        contracts[id] = contract;
    }
    /*
    * this method sorts repository
    * */
    public void sort(Comparator<T> comp) {
        sorter.sort(comp, this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository<?> that = (Repository<?>) o;
        return size == that.size;
    }
    @Override
    public int hashCode() {
        return Objects.hash(size, contracts) + Arrays.hashCode(contracts);
    }

}
