package com.example.demo;

import com.example.demo.shop.Description;
import com.example.demo.shop.Items;
import com.example.demo.shop.Logins;
import com.example.demo.student.Student;

import java.util.ArrayList;
import java.util.Objects;

public class DBManager {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static final ArrayList<Items> items = new ArrayList<>();
    private static final ArrayList<Logins> logins = new ArrayList<>();
    private static Long id = 3L;
    private static Long idShop = 7L;
    private static Long idLogins = 3L;

    static {
        students.add(new Student(1L,"dan","purap1e@mail.ru",18));
        students.add(new Student(2L,"oleg","utkoleg@mail.ru",18));
    }

    static {
        items.add(new Items(1L,"MacBook Pro 2020",new Description("8 GB RAM", "256 GB SSD", "Intel Core i7"),1499.99));
        items.add(new Items(2L,"ASUS TUF GAMING",new Description("16 GB RAM", "512 GB SSD", "AMD Ryzen 5"),999.99));
        items.add(new Items(3L,"Apple Iphone 12 Pro",new Description("6 GB RAM", "128 GB MEMORY", "Super Retina XDR OLED Display"),1099.99));
        items.add(new Items(4L,"XIAOMI Redmi Note 8",new Description("6 GB RAM", "54 GB MEMORY", "Android 9 Pie"),199.99));
        items.add(new Items(5L,"XIAOMI Redmi Note 10",new Description("8 GB RAM", "128 GB MEMORY", "Android 11"),299.99));
        items.add(new Items(6L,"MSI Prestige 15",new Description("32 GB RAM", "1024 GB MEMORY", "Intel Core i7"),1999.99));
    }

    static {
        logins.add(new Logins(1L,"purap1e@mail.ru","danik6785","Daniyar Bulegenov"));
        logins.add(new Logins(2L,"utkoleg@gmail.com","Mun2015bkru!","Oleg Mun"));
    }


    //----------------------------------students-methods---------------------------------------------------------
    public static ArrayList<Student> getStudents(){
        return students;
    }

    public static void addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
    }

    public static Student getStudent(Long id){
        for(Student s: students){
            if (s.getId()==id) return s;
        }
        return null;
    }

    //----------------------------------items-methods---------------------------------------------------------

    public static ArrayList<Items> getItems(){
        return items;
    }

    public static void addItem(Items item){
        item.setId(idShop);
        items.add(item);
        idShop++;
    }

    public static Items getItem(Long id){
        for(Items it: items){
            if (Objects.equals(it.getId(), id)) return it;
        }
        return null;
    }

    //----------------------------------logins-methods---------------------------------------------------------

    public static void addLogin(Logins login){
        login.setId(idLogins);
        logins.add(login);
        idLogins++;
    }

    public static Logins getLogin(String email){
        for(Logins l: logins){
            if (l.getEmail().equals(email)) return l;
        }
        return null;
    }
}
