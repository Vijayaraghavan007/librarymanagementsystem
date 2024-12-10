import java.util.Scanner;
public class Librarymanagement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        books s = new books();
        s.disp_menu();
        Students f=new Students();
        int a = sc.nextInt();
        sc.nextLine();
        while(a !=0){
          
            switch(a)
            {
                case 0:
                {
                    break;
                }
                case 1:
                {
                    book v = new book();
                    s.addbook(v);
                    break;

                }
                case 2:
                {
                    System.out.println(" press 1 to Search with Book Serial No");
                    System.out.println("press 2 to Search with Author Name");
                    System.out.println("press 3 to Search with Borrow Books");
                    System.out.println("press 4 to Search with All Books");
                    System.out.println("press 5 to Search with Registered students");

                    int j = sc.nextInt();

                    switch(j){
                        case 1:
                        s.searchBysno();
                        break;

                        case 2:
                        s.searchByauthor_name();
                        break;
                    }

                }
                case 3:
                {
                    student b=new student();
                    f.addStudent(b);
                    break;
                }

                case 4:
                {
                    f.allregister_student();
                    break;
                }

                case 5:
                {
                    f.checkoutbook();
                    break;
                }

                    

                        
                
            }
            s.disp_menu();
            a = sc.nextInt();
            sc.nextLine();   
        }
        



    }
    
    
    
}

class book{
    public int sno;
    private String book_name;
    private String author_name;
    public int book_qunt;
    book()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the serial Number");
        this.sno=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the Book Name");
        this.book_name=sc.nextLine();

        System.out.println(" Search with Author Name");
        this.author_name=sc.nextLine();

        System.out.println("Search with Book Quantity");
        this.book_qunt=sc.nextInt();


    }

    public int getsno()
    {
        return sno;
    }
    public String getbook_name()
    {
        return book_name;
    }
    public String getauthor_name()
    {
        return author_name;
    }
    public int getbook_qunt()
    {
        return book_qunt;
    }
    public void setBook_qunt( int book_qunt)
    {
        this.book_qunt=book_qunt;
    }

}




class books
{
    book thebook[] =new book[50];
        int count=0;
        void addbook( book b)
        {
            if (count<50)
            {
                thebook[count]=b;
                count++;
            }
            else 
            {
                System.out.println("no momery space......");
            }
        }
        void searchBysno()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("   Search By Serial Num");
            int sno;
            System.out.println("    Enter The Serial Num of Book");
            sno = sc.nextInt();

            int flag = 0;
            System.out.println(
                "S.No\t\t\tName\t\t\tAuthor\t\t\tAvailable_qunt");

            for (int i = 0; i < count; i++) {
                if(sno == thebook[i].getsno()){
                    System.out.println(thebook[i].getsno()+"\t\t\t"+thebook[i].getbook_name()+"\t\t\t"+thebook[i].getauthor_name()+"\t\t\t"+thebook[i].getbook_qunt());
                    flag++;
                    return;
                }
            }
            if (flag == 0)
            System.out.println("No Book for Serial No "+ sno + " Found.");
        }

        void searchByauthor_name()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("  Search by Author Name ");
            String author_name;
            System.out.println("Enter The Author Name");
            author_name = sc.nextLine();

            int flag = 0;
            System.out.println(
                "S.No\t\t\tName\t\t\tAuthor\t\t\tAvailable_qunt");

            for(int i = 0; i < count; i++){
                if(author_name.equals(thebook[i].getauthor_name())){
                    System.out.println(thebook[i].getsno()+"\t\t\t"+thebook[i].getbook_name()+"\t\t\t"+thebook[i].getauthor_name()+"\t\t\t"+thebook[i].getbook_qunt());
                    flag++;

                }
            }
            if(flag == 0){
                System.out.println("No Books is Found"+author_name);
            }

        }

        
    public void borrow_lst (int c)
    {
        Scanner sc = new Scanner(System.in);
        c=sc.nextInt();
        for(int i=0; i<count; i++){
            if(thebook[i].book_qunt==c){
                thebook[i].book_qunt=-1;
                break;
            }
        }
    }
        

        void allbook()
        {
            System.out.println(
                "S.No\t\t\tName\t\t\tAuthor\t\t\tAvailable_qunt");
            for(int i=0; i < count; i++){
                System.out.println( " The list of All Books ");
                System.out.println(thebook[i].getsno()+"\t\t\t"+thebook[i].getbook_name()+"\t\t\t"+thebook[i].getauthor_name()+"\t\t\t"+thebook[i].getbook_qunt());
            }    
        }



    


    void disp_menu()
{
    System.out.println(
                "----------------------------------------------------------------------------------------------------------");
    System.out.println("Press 1 to Add new book");
    System.out.println("Press 0 to Exit Applications");
    System.out.println("Press 2 to upgrade Quantity of book");
    System.out.println("press 3 to register a student");
    System.out.println("press 4 to show all registered students");
    System.out.println("press 5 to checkout a book");
    System.out.println(
                "----------------------------------------------------------------------------------------------------------");
}


}

class student
{
    public String Student_name;
    public int Register_num;
    public int bookcount;
    Scanner sc = new Scanner(System.in);


    student()
    {
        System.out.println("Enter the Student Name");
        this.Student_name=sc.nextLine();
        System.out.println("Enter the register num");
        this.Register_num=sc.nextInt();
        this.bookcount=1;
    }
    public String getStudent_name()
    {
        return Student_name;
    }
    public int getRegister_num()
    {
        return Register_num;
    }
    public int getbookcount()
    {
        return bookcount;
    }
    void increbookcount()
    {
        bookcount++;
    }

}

class Students
{
    student theStudent[] = new student[32];
    int count = 0;
    void addStudent (student b)
    {
        if (count<32)
        {
            theStudent[count]=b;
            count++;
        }
        else
        {
            System.out.println("  No Students Registered");
        }
    }

    void allregister_student()
    {
        for(int i=0; i<count; i++)
        {
            System.out.println("\t\tStd_name\t\tstd_registerno");
            System.out.println("\t\t"+theStudent[i].getStudent_name()+"\t\t"+theStudent[i].getRegister_num());
        }
    }

    void checkoutbook()
    {
        Scanner sc = new Scanner(System.in);
        books obj = new books();
        System.out.println(" Enter your Registered Name");
        String a= sc.nextLine();
        for(int i=0; i<count; i++)
        {
            if(a.equals(theStudent[i].getStudent_name()))
            {
                if(theStudent[i].getbookcount()<=3)
                {
                    System.out.println(" Enter the Serial num to Checkout");
                    int c = sc.nextInt();
                    sc.nextLine();
                    obj.borrow_lst(c);
                    theStudent[i].increbookcount();
                }
                else{
                    System.out.println("you cannot take more than 3 books");
                }
            }
        }
    }
}
