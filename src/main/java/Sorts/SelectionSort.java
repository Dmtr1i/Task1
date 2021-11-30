package Sorts;

import Repository.Repository;
import Contracts.Contract;
import java.util.Comparator;

public class SelectionSort <T extends Contract> implements ISorter<T>{
    @Override
    public void sort(Comparator<T> comp, Repository<T> repo) {
        for (int i = 0; i < repo.getSize(); i++) {
            int minIndex = i;
            for (int j = i; j < repo.getSize(); j++) {
                if (comp.compare(repo.getByIndex(minIndex), repo.getByIndex(j)) < 0) {
                    minIndex = j;
                }
            }
            T temp = repo.getByIndex(i);
            repo.set(i, repo.getByIndex(minIndex));
            repo.set(minIndex, temp);
        }
    }
}
