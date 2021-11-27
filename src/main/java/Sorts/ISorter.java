package Sorts;

import Repository.Repository;
import Contracts.Contract;
import java.util.Comparator;

public interface ISorter<T extends Contract> {
    void sort(Comparator<T> comp, Repository<T> repo);
}
