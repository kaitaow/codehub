for(int i=0;i<10000;i++){
	//不要使用注释掉的写法，因为这样会创建大量的String实例
	//String s=new String("hello world");
	String s="hello world";
}
对于同时提供了静态工厂方法和构造器的不可变类，通常可以
使用静态工厂方法而不是构造器，以避免创建不必要的对象。
例如，静态工厂方法Boolean.valueOf(String)几乎总是优先于构造器
Boolean(String)。

通过将一个类中那些创建之后就一般不会再去修改的域
声明为静态常量域可以每次实例化时都创建这些域。

