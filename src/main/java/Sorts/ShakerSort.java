package Sorts;

import Repository.Repository;
import Contracts.Contract;
import java.util.Comparator;

public class ShakerSort <T extends Contract> implements ISorter<T>{
    @Override
    public void sort(Comparator<T> comp, Repository<T> repo) {
        int start = 0, end = repo.getSize() - 1;
        while (start <= end) {
            for (int i = start; i < end; i++) {
                if (comp.compare(repo.getByIndex(i), repo.getByIndex(i + 1)) < 0) {
                    T temp = repo.getByIndex(i);
                    repo.set(i, repo.getByIndex(i + 1));
                    repo.set(i + 1, temp);
                }
            }
            end--;
            for (int i = end; i > start; i--) {
                if (comp.compare(repo.getByIndex(i - 1), repo.getByIndex(i)) < 0) {
                    T temp = repo.getByIndex(i);
                    repo.set(i, repo.getByIndex(i + 1));
                    repo.set(i + 1, temp);
                }
            }
            start++;
        }
    }
}
