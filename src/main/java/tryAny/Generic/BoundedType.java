package tryAny.Generic;

public class BoundedType {
    public static void main(String[] args) {
	Hoge<Foo, Bar> h1 = new Hoge<Foo, Bar>();// コンパイル通る
	Hoge<Foo, Foo> h2 = new Hoge<Foo, Foo>();// コンパイル通る
	// Hoge<Bar, Foo> h3 = new Hoge<Bar, Foo>();//コンパイル通らない
    }
}

abstract class Foo {
}

class Bar extends Foo {
}

class Hoge<T, U extends T> {
}