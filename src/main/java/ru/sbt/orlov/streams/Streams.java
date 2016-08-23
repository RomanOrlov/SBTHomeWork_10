package ru.sbt.orlov.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author r.orlov
 */
public class Streams<T> {
    
    private List<T> values;
    
    private Streams(Collection<T> collection) {
        this.values = new ArrayList<>(collection);
    }
    
    public static<T> Streams<T> of(Collection<T> collection) {
        return new Streams<>(collection);
    }
    
    public Streams<T> filter(Predicate<? super T> predicate) {
        boolean removeIf = values.removeIf(predicate);
        return this;
    }
    
    public<R> Streams<R> transform(Function<? super T,? extends R> function) {
        List<R> transformed = new ArrayList<>(values.size());
        values.forEach(t -> transformed.add(function.apply(t)));
        return new Streams<>(transformed);
    }
    
    public<K,V> Map<K,V> toMap(Function<? super T,? extends K> keyMapper,Function<? super T,? extends V> valueMapper) {
        Map<K,V> map = new HashMap<>(values.size());
        values.forEach(t -> map.put(keyMapper.apply(t), valueMapper.apply(t)));
        return map;
    }
}
