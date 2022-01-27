package Injector;

import Annotations.AutoInjectable;
import Annotations.CollectionField;
import Annotations.Configuration;
import Annotations.WithoutConstructor;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Configuration(packages = {"Contracts", "CSVWorker", "Sorts", "Repository"})
public class Injector {
    /*
    * Collects found classes
    */
    private List<Object> pool;
    /*
    * inject value to field
    * */
    public <T> T inject(T object) throws Exception {
        try {
            fillPool();
            Class<?> clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            Collection<Object> tempPool = new ArrayList<>();
            for (Field field : fields) {
                AutoInjectable annotation = field.getAnnotation(AutoInjectable.class);
                CollectionField param = field.getAnnotation(CollectionField.class);
                if (annotation != null) {
                    if (param == null) {
                        for (Object poolEl : pool) {
                            if (Arrays.equals(poolEl.getClass().getInterfaces(), clazz.getInterfaces()) ||
                                poolEl.getClass().getSuperclass().equals(clazz.getSuperclass())) {
                                tempPool.add(poolEl);
                            }
                            if (tempPool.size() == 1) {
                                field.setAccessible(true);
                                System.out.println(tempPool.toArray()[0]);
                                field.set(object, tempPool.toArray()[0]);
                                field.setAccessible(false);
                            } else {
                                if (tempPool.size() < 1)    throw new Exception();
                                else {
                                    for (Object tp : tempPool) {
                                        if (tp.getClass().getSimpleName().equals(annotation.defaultField())) {
                                            field.setAccessible(true);
                                            field.set(object, tp);
                                            field.setAccessible(false);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        for (Object poolEl : pool) {
                            if (poolEl.getClass().getSuperclass().getSimpleName().equals(param.paramName()) ||
                                checkInterface(poolEl, param.paramName()) ||
                                poolEl.getClass().getSimpleName().equals(param.paramName())) {
                                tempPool.add(poolEl);
                            }
                        }
                        field.setAccessible(true);
                        field.set(object, tempPool);
                        field.setAccessible(false);
                    }
                }
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
    /*
    * method, that fill pool of classes
    * */
    private void fillPool() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> injectors = Injector.class;
        pool = new ArrayList<>();
        List<Object> classes = new ArrayList<>();
        Configuration config = injectors.getAnnotation(Configuration.class);
        for (String str : config.packages()) {
            for (Class<?> cl : findClasses(str)) {
                if (cl.getAnnotation(FunctionalInterface.class) == null &&
                        cl.getAnnotation(WithoutConstructor.class) != null) {
                    classes.add(cl.getDeclaredConstructor().newInstance());
                }
            }
        }
        pool.addAll(classes);
    }
    /*
    * method, that found marked classes
    * */
    private Set<Class<?>> findClasses(String packageName) {
        Reflections reflection = new Reflections(packageName, new SubTypesScanner(false));
        return new HashSet<>(reflection.getSubTypesOf(Object.class));
    }
    /*
    * method that checking interfaces
    * */
    private boolean checkInterface(Object obj, String nameObj) {
        for(Class<?> o : obj.getClass().getInterfaces()) {
            if (o.getSimpleName().equals(nameObj)) return true;
        }
        return false;
    }
}