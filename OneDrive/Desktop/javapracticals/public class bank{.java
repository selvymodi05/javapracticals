public class bank{


abstract class account {
    String no,name;
    double bal;
    account(String n,String h,double b) {
        no=n;
        name=h;
        bal=b;
    }
    void deposit(double x) {
        if(x>0) 
            {bal+=x;}
    }
    abstract boolean withdraw(double x);
    abstract double rate();
    abstract String type();

    public String toString() {
        return type()+" "+no+" "+name+" "+bal+" "+rate();
    }

    public boolean equals(Object o) {
        if(!(o instanceof account))
            return false;
        account a=(account)o;
        return no.equals(a.no);
    }
    void widraw(double x)
    {
        if(amout>=x)
        {
            System.Out.Println("invalid amount");
        }

    }
    abstract  double rate()
    {
        rate = (amount * x/12);
    }