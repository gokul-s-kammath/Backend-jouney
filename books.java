import java.util.*;
class Book{
    String title,authour;
    private double price;
    public Book(String title,String authour,double price){
        this.title=title;
        this.authour=authour;
        setprice(price);;
    }
    public double getprice(){
         return this.price;
    }
    public void setprice(double price){
        if(price<0){
            System.out.println("The price cannot be below zero!");
        }
        else{
            this.price=price;
        }
    }
}
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<Book> Mylibrary=new ArrayList<>();
        Book b1=new Book("titile","GOkul",500);
        Mylibrary.add(b1);
        Book b2=new Book("Abc","Lav",100);
        Mylibrary.add(b2);
        int num=0;
        boolean isvalid=true;
        
        try{
        System.out.print("Enter the  price for the new book:");
        num=sc.nextInt();   
        }
        catch(Exception e){
            System.out.println("The price should be a positive number!");
            isvalid=false;
        }
        if(isvalid){
            Book b3=new Book("BCA","baby",num);
            Mylibrary.add(b3);

        }
       
        for(Book b:Mylibrary){
            System.out.println(b.title+" is written by "+b.authour+ " costs " + b.getprice());
        }
    }
}
