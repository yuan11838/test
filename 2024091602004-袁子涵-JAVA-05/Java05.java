public class Java051 {
    public static void main(String[] args){
        Person p1 = new Person("1",1,1);
        Person a = new Person(p1);
        p1.age = 2;
        p1.sex = 2;
        p1.name = "2";
        System.out.println("a的name "+a.name+" a的age "+a.age+" a的sex"+a.sex);
        System.out.println("p1的name "+p1.name+" p1的age "+p1.age+" p1的sex "+p1.sex);
        p1.eat();
        System.out.println("Person类中存在"+Person.count+"个对象");

    }
    //不知道为什么，如果我不加static，程序就会报错：java: 无法从静态上下文中引用非静态 变量 this
    public static class Person {
        static int count = 0;
        private String name;
        private int age;
        private int sex;
        private void eat() {
            System.out.println(name+"正在吃东西");
        }

        private void sleep() {

        }
        private void dadoudou() {

        }
        //java会自动构造一个默认的构造函数，这里就直接构造一个显式的
        public Person(String name,int age,int sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
            count++;


        }
        //复制构造函数
        public Person(Person a){
            this.name = a.name;
            this.age =  a.age;
            this.sex = a.sex;
            count++;

        }
        public static int Count(){
            return count;
        }
        //那个删除对象使计数减一的要求，由于时间不够，我先搁置一下，如果有时间一定补上
        //请学长学姐谅解

    }

}