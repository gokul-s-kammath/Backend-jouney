import java.util.*;
class Movie{
    String title;
    String director;
    private double rating;
    public Movie(String title,String director,double rating){
    this.title=title;
    this.director=director;
    setrating(rating);
}
public double getrating(){
    return this.rating;
}
public void setrating(double rating){
    if(rating>10.0||rating<0.00){
        System.out.println("This rating is not valid");
    }
    else{
        this.rating=rating;
    }
}
}
class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<Movie>moviedatabase=new ArrayList<>();
        Movie m1=new Movie("Park", "Gokul", 8.00);
        Movie m2=new Movie("Shark", "Lav", 9.00);
        moviedatabase.add(m1);
        moviedatabase.add(m2);
        double rate=0;
        boolean isvalid=true;
        try{
            System.out.println("Enter the rating for the new movie:");
            rate=sc.nextDouble();
        }
        catch(Exception e){
            System.out.println("The entred value is not valid for this format of data!");
            isvalid=false;
        }
        if(isvalid){
            Movie m3=new Movie("newmovie", "ageen",rate);
            moviedatabase.add(m3);
        }
        System.out.println("The movies having a rating above 7!");
        for(Movie v:moviedatabase){
            if(v.getrating()>7.0){
                System.out.println("The title of the movie is:"+v.title);
                System.out.println("The director of the movie is:"+v.director);
            }
        }
    }
}
