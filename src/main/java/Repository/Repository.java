package Repository;

import Contracts.Contract;

public class Repository {
    /*
    Private fields for storage data
     */
    private Contract[] contracts;
    private int size;
    /*
    Constructor
     */
    public Repository(){
        size = 0;
        contracts = (Contract[]) new Contract[10];
    }
    /*
    this method adds new contract to repository
     */
    public void add(Contract contract){
        if (isEmpty()) contracts[0] = contract;
        else {
            if (size == contracts.length) {
                Contract[] copy = (Contract[]) new Contract[contracts.length*2];
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
    public Contract get(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (contracts[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) return null;
        else return contracts[index];
    }
    /*
    this method clear repository
     */
    public void clear(){
        contracts = (Contract[]) new Contract[10];
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
            contracts = (Contract[])copy;
            size -= 1;
            return true;
        }
    }
}
