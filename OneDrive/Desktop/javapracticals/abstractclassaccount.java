


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

    public int hashCode() {
        return no.hashCode();
    }
}

class savings extends account {
    savings(String n,String h,double b) {
        super(n,h,b);
    }

    boolean withdraw(double x) {
        if(x>0 && bal-x>=1000) {
            bal-=x;
            return true;
        }
        return false;
    }

    double rate() { return 4; }
    String type() { return "savings"; }
}

class current extends account {
    current(String n,String h,double b) {
        super(n,h,b);
    }

    boolean withdraw(double x) {
        if(x>0 && bal-x>=-5000) {
            bal-=x;
            return true;
        }
        return false;
    }

    double rate() { return 0; }
    String type() { return "current"; }
}

class fd extends account {
    fd(String n,String h,double b) {
        super(n,h,b);
    }

    boolean withdraw(double x) {
        return false;
    }

    double rate() { return 7; }
    String type() { return "fd"; }
}

class salary extends account {
    salary(String n,String h,double b) {
        super(n,h,b);
    }

    boolean withdraw(double x) {
        if(x>0 && x<=bal) {
            bal-=x;
            return true;
        }
        return false;
    }

    double rate() { return 3; }
    String type() { return "salary"; }
}

public class bank {
    public static void main(String[] args) {

        account[] a={
            new savings("s1","selvy",5000),
            new current("c1","rahul",2000),
            new fd("f1","priya",10000),
            new salary("sa1","amit",8000)
        };

        for(account x:a)
            System.out.println(x);

        a[0].deposit(1000);

        System.out.println(a[0].withdraw(2000));
        System.out.println(a[2].withdraw(2000));

        for(account x:a) {
            if(x instanceof savings)
                System.out.println("min balance=1000");

            if(x instanceof current)
                System.out.println("limit=5000");
        }

        account x=new savings("s1","abc",7000);
        account y=new current("s1","xyz",3000);

        System.out.println(x.equals(y));
    }
}
}
