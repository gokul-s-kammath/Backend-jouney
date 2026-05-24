import java.util.*;
class Transaction{
    String money;
    double amount;
    public Transaction(String money,double amount){
        this.money=money;
        this.amount=amount;
    }
}
class Wallet{
    String ownername;
    private double balance=0;
    ArrayList<Transaction>history=new ArrayList<>();
    public Wallet(String ownername,double balance){
        this.ownername=ownername;
        this.balance=balance;
    }

    public void setbalanced(double balance){
        this.balance+=balance;
    }
    public void setbalancew(double balance){
        this.balance-=balance;
    }
    public double getbalance(){
        return this.balance;
    }
    public void Deposite(double cash){
        if(cash<=0){
            System.out.println("Any amount less than or equal to zero is not accepted!");
        }
        else{
            setbalanced(cash);
            Transaction d=new Transaction("Deposite", cash);
            history.add(d);
        }
    }
    public void Withdraw(double cash){
        if(getbalance()-cash<=0){
            System.out.println("Insufficent balance!");
        }
        else{
            setbalancew(cash);
            Transaction w=new Transaction("Withdraw", cash);
            history.add(w);
        }
    }
}
class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        String onlyusername="Gokul";
        Wallet w=null;
        System.out.print("Enter the username:");
        String name=sc.next();
        boolean isvalid=true;
        if(name.equals(onlyusername)){
            System.out.println("Welcome to ABC Gokul");
            w=new Wallet(name, 0);
        }
        else{
            isvalid=false;
            System.out.println("The entered user name is not valid try again!");
        }

        int choice=0;
        while(isvalid&&choice!=4){
        System.out.println("--- Digital Wallet Menu ---\r\n" + //
                        "1. View Balance & History\r\n" + //
                        "2. Deposit Money\r\n" + //
                        "3. Withdraw Money\r\n" + //
                        "4. Exit\r\n" + //
                        "Enter choice:");
            choice=sc.nextInt();
        
            switch (choice){
                case 1:
                    System.out.println("The amount of balance is:"+w.getbalance());
                    for(Transaction t:w.history){
                        System.out.println("The amount of money "+t.money +" is "+t.amount);
                    }

                    break;
                case 2:
                    System.out.print("Enter the cash you want to deposite:");
                    double dep=sc.nextDouble();
                    w.Deposite(dep);
                    break;
                case 3:
                    System.out.print("Enter the cash you want to withdraw:");
                    double with=sc.nextDouble();
                    w.Withdraw(with);
                    break;
                case 4:
                    System.out.println("Thankyou for banking with us  ;)");
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }
    
    }
}
