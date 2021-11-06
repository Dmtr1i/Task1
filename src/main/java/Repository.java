public class Repository {
    private Contract[] contracts;
    private int size;
    Repository(){
        size = 0;
        contracts = (Contract[]) new Contract[10];
    }
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
    public boolean isEmpty(){return size==0;}
    public void print(){ for(int i = 0; i < size; i++) System.out.println(contracts[i]); }
    public int getSize(){ return size; }
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
    public void clear(){
        contracts = (Contract[]) new Contract[10];
        size = 0;
    }
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
