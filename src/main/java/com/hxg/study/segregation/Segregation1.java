package com.hxg.study.segregation;

/**
 * 接口隔离原则
 */
public class Segregation1
{
}

interface Interface1
{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}

/**
 * B 类实现接口
 */
class B implements Interface1
{

    @Override
    public void operation1()
    {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2()
    {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3()
    {
        System.out.println("B 实现了 operation3");
    }

    @Override
    public void operation4()
    {
        System.out.println("B 实现了 operation4");
    }

    @Override
    public void operation5()
    {
        System.out.println("B 实现了 operation5");
    }
}

/**
 * D 实现了接口1
 */
class D implements Interface1
{

    @Override
    public void operation1()
    {
        System.out.println("D 实现了 operation1");
    }

    @Override
    public void operation2()
    {
        System.out.println("D 实现了 operation2");
    }

    @Override
    public void operation3()
    {
        System.out.println("D 实现了 operation3");
    }

    @Override
    public void operation4()
    {
        System.out.println("D 实现了 operation4");
    }

    @Override
    public void operation5()
    {
        System.out.println("D 实现了 operation5");
    }
}

/**
 * A 类通过Interface1依赖(使用)B类，但是只会用到方法1，2，3
 */
class A {
    public void depend1(Interface1 interface1)
    {
        interface1.operation1();
    }

    public void depend2(Interface1 interface1)
    {
        interface1.operation2();
    }

    public void depend3(Interface1 interface1)
    {
        interface1.operation3();
    }
}

/**
 * C类通过Interface1依赖(D类)，但是只会使用方法1，4，5
 */
class C {
    public void depend1(Interface1 interface1)
    {
        interface1.operation1();
    }

    public void depend2(Interface1 interface1)
    {
        interface1.operation4();
    }

    public void depend3(Interface1 interface1)
    {
        interface1.operation5();
    }
}

// 按照接口隔离原则应该这样处理：将接口Interface1拆分为独立的几个接口，类A和类C分别与它们需要的接口简历依赖关系。也就是采用接口隔离原则