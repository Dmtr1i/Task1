package Sorts;

import Repository.Repository;
import Contracts.Contract;
import java.util.Comparator;

public class SelectionSort <T extends Contract> implements ISorter<T>{
    @Override
    public void sort(Comparator<T> comp, Repository<T> repo) {
        for (int i = 0; i < repo.getSize(); i++) {
            int minIndex = i;
            for (int j = 0; j < repo.getSize(); j++) {
                if (comp.compare(repo.get(minIndex), repo.get(j)) > 0) {
                    minIndex = j;
                }
            }
            T temp = repo.get(i);
            repo.set(i, repo.get(minIndex));
            repo.set(minIndex, temp);
        }
    }
}
