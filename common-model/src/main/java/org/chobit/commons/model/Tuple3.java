package org.chobit.commons.model;

import java.util.Objects;

/**
 * 二元元组
 *
 * @author robin
 */
public class Tuple3<T1, T2, T3> {

    /**
     * 第一个元素
     */
    public final T1 _1;


    /**
     * 第二个元素
     */
    public final T2 _2;


    /**
     * 第三个元素
     */
    public final T3 _3;


    public Tuple3(T1 _1, T2 _2, T3 _3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(_1, tuple3._1) && Objects.equals(_2, tuple3._2) && Objects.equals(_3, tuple3._3);
    }


    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3);
    }


    @Override
    public String toString() {
        return "Tuple3{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                ", _3=" + _3 +
                '}';
    }
}
