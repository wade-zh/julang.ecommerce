package store.julang.common.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class PropertyUtilTests {

    @Test
    public void testClone() {
        List<A> aList = asList(
                new A(1, "小明"),
                new A(2, "小红"),
                new A(3, "小丽")
        );

        List<B> bList = asList(
                new B(),
                new B(),
                new B()
        );

        for (int i = 0; i < aList.size(); i++) {
            A a = aList.get(i);
            B b = bList.get(i);
            System.out.println("===============克隆前==============");
            System.out.println(a);
            System.out.println(b);
            System.out.println("==================================");
            PropertyUtil.<A, B>clone(a, b);
            System.out.println("===============克隆后==============");
            System.out.println(a);
            System.out.println(b);
            System.out.println("==================================");

        }
    }
}

class A {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


class B {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                '}';
    }
}