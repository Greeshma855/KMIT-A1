package p1;
import p1.p2.demo2;
public class demo1
{
    public void m1()
    {
        System.out.println("demo1 m1 method called");
        demo2 d = new demo2();
        d.m2();

    }
    public void m2()
    {
        System.out.println("demo1 m2 method called");
    }
}