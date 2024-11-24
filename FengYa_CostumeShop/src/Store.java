import java.util.Objects;
import java.util.Scanner;

public class Store {
    Product[]  products = new Product[5];
    int total = 2;
    Scanner input = new Scanner(System.in);

    int capacity = 5;
    String rubbish;
    int requestNumber = 2;

    Request[] requestList = new Request[100];


    // 添加请求
    public void addRequest(String briefIntroduction,int status,int SNumber){
        Request request = new Request(briefIntroduction,status,SNumber);
        requestList[requestNumber++] = request;
    }

    Store(){
        products[0] = new Product("Amiya-Origin","xl",1,false,1,500);
        products[1] = new Product("薇薇安娜-原皮","xl",2,false,1,1100);
        products[0].priceHistory[products[0].priceHistoryNumber++] = 500;
        products[1].priceHistory[products[1].priceHistoryNumber++] = 900;
        products[1].priceHistory[products[1].priceHistoryNumber++] = 1100;
        requestList[0] = new Request("麻麻！我想出薇薇安！请问可以借我衣服嘛！",2,2);
        requestList[1] = new Request("老师您好，请问阿米娅的衣服可以卖吗.....？",3,1);
    }
    // 查找单品信息
    public String informationCheck(int number){
        String a = "";
        a = a + "sequence number: " + products[number].SNumber + " Name: " + products[number].name + " Price: " + products[number].price + " state: " + products[number].status + " Is damaged? " + products[number].isDamaged + "\nPrice History: " + products[number].returnHistory();
        return a;
    }

    //1） 查询全部商品
    public void checkAll(){
        for(int i = 0;i<total;i++){
            System.out.println(informationCheck(i));
        }
        System.out.println("""
                
                You have viewed all the current costumes!
                Please enter "exit" to exit or any other words to back to option interface...
                """);

    }


    //4） 添加商品
    public int addProduct(){
        System.out.flush();
        System.out.println("Welcome to the Add Product interface!\n------------------------------------------\nThe name of the costume?");
        if(total == 5){
            System.out.println("The store is at its maximum capacity!\nIf you want to add more products,please expand its capacity.");
            rubbish = input.nextLine();
            return 1;
        }
        int sign = 0;
        products[total] = new Product();
        String name = input.nextLine();
        products[total].setName(name);
        System.out.println("The size of the costume?");
        String size = input.nextLine();
        products[total].setSize(size);
        int flag = 0;
        boolean isDamaged = false;
        while(flag == 0){
            System.out.println("Is the costume damaged?(enter true or false)");
            String isDamagedAcceptor = input.nextLine();

            if(Objects.equals(isDamagedAcceptor,"true")){
                isDamaged = true;
                flag = 1;
            }else if(Objects.equals(isDamagedAcceptor,"false")){
                isDamaged = false;
                flag = 1;
            }else{
                System.out.println("You are not entering a valid word.Please try again...\n");
            }
        }

        products[total].setDamaged(isDamaged);
        System.out.println("The price of the costume?");

        String numberAcceptor = input.nextLine();
        try{
            int number = Integer.parseInt(numberAcceptor);
        }catch(NumberFormatException e){
            System.out.println("It's not a number!\nEnter any word to retry...");
            rubbish = input.nextLine();
            if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                System.out.println("Exit the programme.Bye!");
                sign = 1;
                return sign;
            }
            sign = 1;
            return sign;
        }
        int price = Integer.parseInt(numberAcceptor);


        products[total].setPrice(price);
        products[total].setStatus(1);
        products[total].setSNumber(total+1);
        products[total].priceHistory[products[total].priceHistoryNumber++] = price;
        total++;
        return sign;
    }


    public int getNewRequest(){
        int a = 0;
        for(int i = 0;i<requestNumber;i++){
            if(requestList[i].getNewOrReadOrSettled() == 1){
                a++;
            }
        }
        return a;
    }

    public int getRequest(){
        int a = 0;
        for(int i = 0;i<requestNumber;i++){
            if(requestList[i].getNewOrReadOrSettled() != 3){
                a++;
            }
        }
        return a;
    }

    public String getRequestInformation(int number){
        String a = "";
        a += "Sequence number: " + requestList[number].getSNumber() + "\nBrief introduction: " + requestList[number].getBriefIntroduction() + "\nWanted state: " + requestList[number].getStatus();

        return a;
    }

//    public void solveRequest(int number){
//        requestList[number].setStatus(3);
//        requestNumber--;
//    }

}
