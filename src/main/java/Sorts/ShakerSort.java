package Sorts;

import Repository.Repository;
import Contracts.Contract;
import java.util.Comparator;

public class ShakerSort <T extends Contract> implements ISorter<T>{
    @Override
    public void sort(Comparator<T> comp, Repository<T> repo) {
        int start = 0, end = repo.getSize() - 1;
        while (start <= end) {
            for (int i = end; i > start + 1; i--) {
                if (comp.compare(repo.get(i - 1), (T)repo.get(i)) > 0) {
                    T temp = repo.get(i);
                    repo.set(i, repo.get(i + 1));
                    repo.set(i + 1, temp);
                }
                start++;
            }
            for (int i = start; i < end - 1; i++) {
                if (comp.compare(repo.get(i), (T)repo.get(i + 1)) > 0) {
                    T temp = repo.get(i);
                    repo.set(i, repo.get(i + 1));
                    repo.set(i + 1, temp);
                }
                end--;
            }
        }
    }
}
