public class Test {


}

class Fu{
    void draw(){
        System.out.println("父类的 draw 方法");
    }
    Fu(){
        System.out.println("开始父类的无参构造");
        draw();
        System.out.println("结束父类的无参构造");
    }
}

class Zi extends Fu{
    private int radius = 1;
    private String a = "s";
    Zi(int r){
        System.out.println("开始子类的构造");
        radius = r;
        System.out.println("结束调用子类的构造, radius="+radius);
    }

    void draw(){
        System.out.println("调用子类的 draw 方法,radius="+radius);
    }
}

class PolyConstructors {
    public static void main(String[] args){
        new Zi(100);
    }
}


