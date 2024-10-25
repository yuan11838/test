package aaa;

import java.net.StandardSocketOptions;
import java.util.*;

public class Java06 {

    public static void main(String[] args) {
        WechatCustomer wechatCustomerout = new WechatCustomer("sp.",true);
        WechatCustomer wechatCustomerin = new WechatCustomer("N/A",false);
        TableCustomer tableCustomer = new TableCustomer(1);
        List<Order> list = new ArrayList<Order>();
        list.add(new Dish_1());
        list.add(new Dish_2());
        system s = new system();
        Dish_1 dish1 = new Dish_1();
        Dish_2 dish2 = new Dish_2();
        dish1.name = "番茄炒蛋";
        dish1.price = 12;
        dish2.name = "青椒肉丝";
        dish2.price = 20;
        System.out.println(dish1.name+"价格为"+dish1.price+"元");
        dish1.profile();
        if(dish1.check()){
            System.out.println("原料足够可以烹饪该菜品");
        }else {
            System.out.println("不能烹饪该菜品");
        }
        System.out.println(dish2.name+"价格为"+dish2.price+"元");
        dish2.profile();
        if(dish2.check()){
            System.out.println("原料足够可以烹饪该菜品");
        }else {
            System.out.println("不能烹饪该菜品");
        }
        s.manageOrder(list,tableCustomer);
        s.manageOrder(list,wechatCustomerin);
        s.manageOrder(list,wechatCustomerout);
    }
    //构建公共父类
    public static class Dish{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        String name;//菜品名称
        double price;//菜品价格
        public void profile(){
           System.out.println(name+"11");
        }
    }
    //子类1+实现
    public static class Dish_1 extends Dish implements Order{
        public void profile() {
            System.out.println("番茄炒蛋是普通的大众菜肴，烹调方法比较简单，而且营养搭配合理。色泽鲜艳，口味宜人，深受大众喜爱。其营养价值丰富，具有营养素互补的特点以及健美抗衰老的作用。番茄含有丰富的胡萝卜素、维生素C和B族维生素，番茄红素具有独特的抗氧化能力。鸡蛋含有大量的维生素和矿物质及有高生物价的蛋白质。蛋黄中含有丰富的卵磷脂、固醇类等，对神经系统和身体发育有非常好的作用，深受人们的喜爱。");
        }
        public void cook(){
            System.out.println("番茄炒蛋的做法是");
        }
        Random a = new Random();
        int a1 = a.nextInt(10);//通过随机数使check随机返回true或false
        public boolean check(){

            if(a1>5){
                return true;
            }else {
                return false;
            }
        }
    }
    //子类2+实现
    public static class Dish_2 extends Dish implements Order {
        public void profile() {
            System.out.println("青椒肉丝，是以青椒为主要食材的家常菜，属于川菜菜系。口味香辣，菜品色香味俱全，操作简单，营养价值丰富。");
        }
        public void cook(){
            System.out.println("青椒炒肉的做法是");
        }
        Random b = new Random();
        int a2 = b.nextInt(10);//通过随机数使check随机返回true或false
        public boolean check(){
            if(a2>5){
                return true;
            }else {
                return false;
            }
        }
    }
    //接口
    public interface Order{
        void cook();
        boolean check();
    }
    public static class system {
        private static int i = 1;
        //请补全处理订单的函数
        public void manageOrder(List<Order> dishes, Object customer){
            boolean cookall = true;
            for(Order dish:dishes){
                if(!dish.check()){
                cookall =false;
                break;
                }
            }
            if(!cookall){
                System.out.println("取消订单");
                System.out.println("该订单编号为"+(i));
                i++;
            }else {
                for (Order dish : dishes){
                    dish.cook();
                }
                System.out.println("该订单编号为"+(i));
                i++;
                if(customer instanceof TableCustomer){//使用instanceof二元运算符，返回true或false
                    TableCustomer tableCustomer =(TableCustomer) customer;
                    System.out.println("Table类");
                    System.out.println("将菜品送到"+tableCustomer.tableId+"号餐桌");
                }else if(customer instanceof WechatCustomer){
                    WechatCustomer wechatCustomer = (WechatCustomer) customer;
                    if(wechatCustomer.takeout){
                        System.out.println("Wechat类外卖");
                        System.out.println("将外卖送到"+wechatCustomer.address);
                    }else {
                        System.out.println("Wechat类堂食");
                        System.out.println("无需额外处理");
                    }

                }
            }
            //要求1：一旦订单里有一个菜品的原料不足以烹饪，就输出“取消订单”，
            // 否则输出所有菜品的烹饪方法，最后再输出该订单的编号，编号从1开始递增。
        }
    }
    public static class TableCustomer{
        public int tableId;
        public TableCustomer(int tableId){
            this.tableId = tableId;
        }
    }
    public static class WechatCustomer {
        public String address;//顾客地址
        public boolean takeout;//true代表该顾客是外卖，false代表该顾客是堂食
        public WechatCustomer(String address,boolean takeout){
            this.takeout = takeout;
            this.address = address;
        }
    }
    //感觉这个随机数有点离谱，随机半天都roll不出true
    //在订单中，好像运行这些类时又将随机数roll了一遍，导致订单输出结果和之前输出的菜单不一致，但我整了半天也没能使这俩一致，还请学长学姐指点
    //这个我真的做了半天（从昨天晚上9点到凌晨4点半，然后又是一早上），感觉脑子有点转不动了
}