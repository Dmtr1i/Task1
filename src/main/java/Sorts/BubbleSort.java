package Sorts;
import Repository.Repository;
import Contracts.Contract;
import java.util.Comparator;

public class BubbleSort <T extends Contract> implements ISorter<T>{
    @Override
    public void sort(Comparator<T> comp, Repository<T> repo) {
        boolean check = true;
        while(check) {
            check = false;
            for (int i = 0; i < repo.getSize() - 1; i++) {
                if (comp.compare(repo.get(i), (T)repo.get(i + 1)) > 0) {
                    T temp = repo.get(i);
                    repo.set(i, repo.get(i + 1));
                    repo.set(i + 1, temp);
                    check = true;
                }
            }
        }
    }
}
