
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;



public class Driver {
    private String password = "88884231";
    Scanner input = new Scanner(System.in);
    int logInTime = 0;
    //int total = 2;
    Store store = new Store();
    String rubbish;

    //首页设置
    public void set(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("""
                This is Fengyaa's team's shop and you can check or do some extra works in this interface!
                Now, you can access Fengyaa's team's shop with custom or administrator authority.
                
                ------------------------------------------------------------------------------
                
                Please press 1 if you would like to access as a custom.
                Please press 2 if you would like to access as an administrator.
                
                """);

        String order = input.nextLine();
//        String rubbish = input.nextLine();
        if(Objects.equals(order,"1")){
            customMode();
        }else if(Objects.equals(order,"2")){
            checkAdministratorMode();
        }else{
            System.out.println("This is not a valid input!\nIf you would like to retry,please enter 'y' or 'Y'.");
            String yesOrNo = input.nextLine();
            if(yesOrNo.charAt(0) == 'Y'|| yesOrNo.charAt(0) == 'y'){
                set();
            }else{
                System.out.println("Exit the programme.");
            }
        }
    }



    //客户模式
    public void customMode(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("""
                Welcome to custom mode! Here's what you can do.
                ---------------------------------------------------
                1) Check All the inventory.
                2) Search for a specific costume and its whole information.
                3) Find the historical price of a specific costume. *This option has been deleted and can't be used.
                4) Buy a specific costume.
                5) Borrow a specific costume.
                6) exit to choose another authority without ending the programme.
                ---------------------------------------------------
                You can enter the corresponding number of the options above to perform actions.
                """);
        String acceptor = input.nextLine();
        if(Objects.equals(acceptor,"exit")||Objects.equals(acceptor,"Exit")){
            System.out.println("Exit the programme.Bye!");
            return;
        }
        switch(acceptor){
            case "1" :
                store.checkAll();
                String returnOrNot = input.nextLine();
                returnCustomInterface(returnOrNot);
                break;
            case "2" :
                searchSpecificItem();
                break;
            case "3" :
                System.out.println("This option has been deleted.Try another one.");
                rubbish = input.nextLine();
                returnCustomInterface(rubbish);
                break;
            case "4" :
                buyItem();
                break;
            case "5" :
                borrowItem();
                break;
            case "6" :
                set();
                break;
            default:
                System.out.println("It's not a valid number!Please try again or enter exit to exit.\n Enter any thing to retry...");
                String rubbish = input.nextLine();
                if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                    System.out.println("Exit the programme.Bye!");
                    return;
                }
                customMode();
        }

        /*  这些内容是过去的尝试，现在我们找到了更好的解决办法
        try{
            int number = Integer.parseInt(acceptor);
        }catch(NumberFormatException e){

            System.out.println("You are not entering a number! Please try again later\n Enter any thing to retry...");
            String rubbish = input.nextLine();
            customMode();
        }
        int number = Integer.parseInt(acceptor);
        switch(number){
            case 1 :
                checkAll();
                break;
            case 2 :
                searchSpecificItem();
                break;
            case 3 :
                getHistoricalPrice();
                break;
            case 4 :
                buyItem();
                break;
            case 5 :
                borrowItem();
                break;
            default:
                System.out.println("It's not a valid number!Please try again or enter exit to exit.\n Enter any thing to retry...");
                String rubbish = input.nextLine();
                customMode();

        }*/


    }

    //管理员模式
    public void administratorMode(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("""
                Welcome to administrator mode! Here's what you can do.
                ---------------------------------------------------
                1) Check All the inventory.
                2) Search for a specific costume and its whole information.
                3) Find the historical price of a specific costume.*This option has been deleted and can't be used.
                4) add a new costume to the shop.
                5) expand the storage's capacity.
                6) change a specific costume's price.
                7) delete a specific costume.
                8) change a specific costume's state.
                9) check requests.
                10) exit to choose another authority without ending the programme.
                ---------------------------------------------------
                You can enter the corresponding number of the options above to perform actions.
                """);
        System.out.println("Else,you have " + store.getRequest() +" requests waiting for you to deal with!");
        String acceptor = input.nextLine();
        if(Objects.equals(acceptor,"exit")||Objects.equals(acceptor,"Exit")){
            System.out.println("Exit the programme.Bye!");
            return;
        }
        switch(acceptor){
            case "1" :
                store.checkAll();
                administratorMode();
                break;
            case "2" :
                administratorSearchSpecificItem();
                break;
            case "3" :
                System.out.println("This option has been deleted.Try another one.");
                rubbish = input.nextLine();
                returnAdministratorInterface(rubbish);
                break;
            case "4" :
                if(store.addProduct() == 1){
                    System.out.println("A fair add!\nReturn to the administrator title...");
                    rubbish = input.nextLine();
                    administratorMode();
                    return;
                }

                System.out.println("\nSuccessfully add a product!Please enter any word to continue...");
                rubbish = input.nextLine();
                if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                    System.out.println("Exit the programme.Bye!");
                    return;
                }
                administratorMode();
                break;
            case "5" :
                expandStorage();
                break;
            case "6" :
                changePrice();
                break;
            case "7" :
                deleteProduct();
                break;
            case "8" :
                changeProductState();
                break;
            case "9" :
                checkRequest();
                break;
            case "10" :
                set();
                break;
            default:
                System.out.println("It's not a valid number!Please try again or enter exit to exit.\n Enter any thing to retry...");
                rubbish = input.nextLine();
                if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                    System.out.println("Exit the programme.Bye!");
                    return;
                }
                administratorMode();
        }


    }

    //管理员模式身份检查
    public void checkAdministratorMode(){
        logInTime++;
//        System.out.print("\033[H\033[2J");
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("""
                ------------------------------------------
                Now,please enter the password.
                
                """);
        if(logInTime >= 3){
            System.out.println("""
                    If you forget your password,you can check the password by answering a question.
                    Enter "check" to start the question.
                    
                    """);
        }
        String acceptor = input.nextLine();
        System.out.println(acceptor);
        if(Objects.equals(acceptor, password)){

            administratorMode();

        }else if(Objects.equals(acceptor,"exit")|| Objects.equals(acceptor,"Exit")){

            System.out.println("Exit the programme.Bye!");

        }else if(Objects.equals(acceptor,"check")||Objects.equals(acceptor,"Check")){

            System.out.println("\nPlease answer:What's your name?(Please answer in four words.)");
            String Dave = input.nextLine();
            if(Objects.equals(Dave,"Dave")){

                System.out.println("Password is: 88884231\nLet's try to enter the administrator mode again.\nEnter any keys to retry...");
                String rubbish = input.nextLine();
                logInTime = 0;
                checkAdministratorMode();
            }else{

                System.out.println("Your answer is wrong.Try again.");
                checkAdministratorMode();

            }

        }else{
            System.out.println("""
                    
                    Your password is not correct! Please try again or enter "exit" to exit.
                    Enter any word to retry...
                    
                    """);
            String answer = input.nextLine();

            if(Objects.equals(answer,"exit")|| Objects.equals(answer,"Exit")){
                System.out.println("Exit the programme.Bye!");

            }else{
                checkAdministratorMode();
            }


        }

    }



    //2） 查找方法
    public void searchSpecificItem(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("""
                You can search for a specific costume by product information.Search by:
                ------------------------------------------------------
                1) Sequence Number.
                2) Name.
                3) Price.
                4) status.
                5) Whether it is damaged.
                
                """);
        String acceptor = input.nextLine();
        if(Objects.equals(acceptor,"exit")||Objects.equals(acceptor,"Exit")){
            System.out.println("Exit the programme.Bye!");
            customMode();
            return;
        }
        switch(acceptor){
            case "1" :
                System.out.println("Sequence number?");
                String numberAcceptor = input.nextLine();
                try{
                    int number = Integer.parseInt(numberAcceptor);
                }catch(NumberFormatException e){
                    System.out.println("It's not a number!\nEnter any word to retry...");
                    rubbish = input.nextLine();
                    if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                        System.out.println("Exit the programme.Bye!");
                        return;
                    }
                    searchSpecificItem();
                }
                int number = Integer.parseInt(numberAcceptor);
                if(number > store.total){
                    System.out.println("There is no product!\nTurning back to the administrator mode...");
                    rubbish = input.nextLine();
                    customMode();
                    return;
                }
                System.out.println(store.informationCheck(number-1));
                System.out.println("\nEnter any words to back to custom mode...");
                rubbish = input.nextLine();
                customMode();
                break;
            case "2" :
                System.out.println("Name?");
                String name = input.nextLine();

                int flag = 1;
                for(int i = 0;i<store.total;i++){
                    if(Objects.equals(name,store.products[i].getName())){
                        System.out.println(store.informationCheck(i));
                        flag = 0;
                    }
                }
                if(flag == 1){
                    System.out.println("Can't find a corresponding costume!\nPlease enter any word to try again...");
                    rubbish = input.nextLine();
                    searchSpecificItem();
                }
                System.out.println("\nSuccessful pairing!\nEnter any word to back to the custom mode...");
                rubbish = input.nextLine();
                customMode();
                break;
            case "3" :
                System.out.println("Price?");
                String priceAcceptor = input.nextLine();
                try{
                    int price = Integer.parseInt(priceAcceptor);
                }catch(NumberFormatException e){
                    System.out.println("It's not a number!\nEnter any word to retry...");
                    rubbish = input.nextLine();
                    if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                        System.out.println("Exit the programme.Bye!");
                        return;
                    }
                    searchSpecificItem();
                }
                int price = Integer.parseInt(priceAcceptor);
                int[] priceArray = new int[100];
                int arrayNumber = 0;
                for(int i = 0;i<store.total;i++){
                    if(price == store.products[i].price){
                        priceArray[arrayNumber++] = store.products[i].getSNumber();
                    }
                }
                if(arrayNumber == 0){
                    System.out.println("There is no costume pairs your price.\nEnter any word to retry...");
                    rubbish = input.nextLine();
                    searchSpecificItem();
                }else{
                    for(int i = 0;i<arrayNumber;i++){
                        System.out.println(store.informationCheck(priceArray[i]-1)+"\n");
                    }
                    System.out.println("Successful match!\nEnter any word to exit...");
                    rubbish = input.nextLine();
                    returnCustomInterface(rubbish);
                }
                break;
            case "4" :
                System.out.println("Status?(Status 1 is on sale.Status 2 is lent out.Status 3 is sold out.)");
                String statusAcceptor = input.nextLine();
                try{
                    int status = Integer.parseInt(statusAcceptor);
                }catch(NumberFormatException e){
                    System.out.println("It's not a number!\nEnter any word to retry...");
                    rubbish = input.nextLine();
                    if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                        System.out.println("Exit the programme.Bye!");
                        return;
                    }
                    searchSpecificItem();
                }
                int status = Integer.parseInt(statusAcceptor);
                int[] statusArray = new int[100];
                int arrayStatusNumber = 0;
                for(int i = 0;i<store.total;i++){
                    if(status == store.products[i].status){
                        statusArray[arrayStatusNumber++] = store.products[i].getSNumber();
                    }
                }
                if(arrayStatusNumber == 0){
                    System.out.println("There is no costume pairs your status.\nEnter any word to retry...");
                    rubbish = input.nextLine();
                    searchSpecificItem();
                }else{
                    for(int i = 0;i<arrayStatusNumber;i++){
                        System.out.println(store.informationCheck(statusArray[i]-1)+"\n");
                    }
                    System.out.println("Successful match!\nEnter any word to exit...");
                    rubbish = input.nextLine();
                    returnCustomInterface(rubbish);
                }
                break;
            case "5" :
                System.out.println("Costume damaged or not?(If yes please enter y, no enter n)");
                String damage = input.nextLine();
                if(Objects.equals(damage,"n")){
                    int[] noArray = new int[100];
                    int noNumber = 0;
                    for(int i = 0;i<store.total;i++){
                        if(!store.products[i].isDamaged){
                            noArray[noNumber++] = store.products[i].getSNumber();
                        }
                    }
                    if(noNumber == 0){
                        System.out.println("There is no costume pairs which doesn't get damaged.\nEnter any word to retry...");
                        rubbish = input.nextLine();
                        searchSpecificItem();
                    }else{
                        for(int i = 0;i<noNumber;i++){
                            System.out.println(store.informationCheck(noArray[i]-1));
                        }
                        System.out.println("\nSuccessful match!\nEnter any word to exit...");
                        rubbish = input.nextLine();
                        returnCustomInterface(rubbish);
                    }
                }else if(Objects.equals(damage,"y")){
                    int[] yesArray = new int[100];
                    int yesNumber = 0;
                    for(int i = 0;i<store.total;i++){
                        if(store.products[i].isDamaged){
                            yesArray[yesNumber++] = store.products[i].getSNumber();
                        }
                    }
                    if(yesNumber == 0){
                        System.out.println("There is no costume pairs which get damaged.\nEnter any word to retry...");
                        rubbish = input.nextLine();
                        searchSpecificItem();
                    }else{
                        for(int i = 0; i< yesNumber; i++){
                            System.out.println(store.informationCheck(yesArray[i]-1));
                        }
                        System.out.println("\nSuccessful match!\nEnter any word to exit...");
                        rubbish = input.nextLine();
                        returnCustomInterface(rubbish);
                    }
                }else{
                    System.out.println("You are not entering a valid word!\nPlease try again later...");
                    rubbish = input.nextLine();
                    searchSpecificItem();
                }
                break;
            default:
                System.out.println("It's not a valid number!Please try again or enter exit to exit.\n Enter any thing to retry...");
                rubbish = input.nextLine();
                if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                    System.out.println("Exit the programme.Bye!");
                    return;
                }
                customMode();
        }
    }

    //4)  购买
    public void buyItem(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("Please enter your wanna costume's sequence number.");
        String numberAcceptor = input.nextLine();
        if(Objects.equals(numberAcceptor,"exit")||Objects.equals(numberAcceptor,"Exit")){
            System.out.println("Exit the buying interface.Enter any word to continue...");
            rubbish = input.nextLine();
            customMode();
            return;
        }
        try{
            int number = Integer.parseInt(numberAcceptor);
        }catch(NumberFormatException e){
            System.out.println("It's not a number!\nEnter any word to retry...");
            rubbish = input.nextLine();
            if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                System.out.println("Exit the programme.Bye!");
                return;
            }
            buyItem();
        }
        int number = Integer.parseInt(numberAcceptor);
        if(number > store.total){
            System.out.println("There is no product!\nTurning back to the administrator mode...");
            rubbish = input.nextLine();
            customMode();
            return;
        }
        System.out.println("Is this costume you want to buy?\n" + store.informationCheck(number-1) + "\nIf you sure,please enter y to ensure.");
        String acceptor = input.nextLine();
        if(Objects.equals(acceptor,"y")){
            System.out.println("Please write down your buying notes(for shop's administrator to see).");
            String note = input.nextLine();
            store.addRequest(note,2,number);
            System.out.println("Successfully add request!Now please wait for the administrator to connect you and sell the costume.\nEnter any word to continue...");
            rubbish = input.nextLine();
            returnCustomInterface(rubbish);
        }else{
            System.out.println("Invalid input.Restart the buying...");
            rubbish = input.nextLine();
            buyItem();

        }
    }

    //5） 借出
    public void borrowItem(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("Please enter your wanna costume's sequence number.");
        String numberAcceptor = input.nextLine();
        if(Objects.equals(numberAcceptor,"exit")||Objects.equals(numberAcceptor,"Exit")){
            System.out.println("Exit the borrowing interface.Enter any word to continue...");
            rubbish = input.nextLine();
            customMode();
            return;
        }
        try{
            int number = Integer.parseInt(numberAcceptor);
        }catch(NumberFormatException e){
            System.out.println("It's not a number!\nEnter any word to retry...");
            rubbish = input.nextLine();
            if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                System.out.println("Exit the programme.Bye!");
                return;
            }
            borrowItem();
        }
        int number = Integer.parseInt(numberAcceptor);
        if(number > store.total){
            System.out.println("There is no product!\nTurning back to the administrator mode...");
            rubbish = input.nextLine();
            customMode();
            return;
        }
        System.out.println("Is this costume you want to borrow?\n" + store.informationCheck(number-1) + "\nIf you sure,please enter y to ensure.");
        String acceptor = input.nextLine();
        if(Objects.equals(acceptor,"y")){
            System.out.println("Please write down your borrowing notes(for shop's administrator to see).");
            String note = input.nextLine();
            store.addRequest(note,3,number);
            System.out.println("Successfully add request!Now please wait for the administrator to connect you and lend you the costume.\nEnter any word to continue...");
            rubbish = input.nextLine();
            returnCustomInterface(rubbish);
        }else{
            System.out.println("Invalid input.Restart the borrowing...");
            rubbish = input.nextLine();
            buyItem();

        }
    }

    //4） 添加商品 在Store中


    public void administratorSearchSpecificItem(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("""
                You can search for a specific costume by product information.Search by:
                ------------------------------------------------------
                1) Sequence Number.
                2) Name.
                3) Price.
                4) status.
                5) Whether it is damaged.
                
                """);
        String acceptor = input.nextLine();
        if(Objects.equals(acceptor,"exit")||Objects.equals(acceptor,"Exit")){
            System.out.println("Exit the programme.Bye!");
            administratorMode();
            return;
        }
        switch(acceptor){
            case "1" :
                System.out.println("Sequence number?");
                String numberAcceptor = input.nextLine();
                try{
                    int number = Integer.parseInt(numberAcceptor);
                }catch(NumberFormatException e){
                    System.out.println("It's not a number!\nEnter any word to retry...");
                    administratorSearchSpecificItem();
                    if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                        System.out.println("Exit the programme.Bye!");
                        return;
                    }
                    administratorMode();
                }
                int number = Integer.parseInt(numberAcceptor);
                if(number > store.total){
                    System.out.println("There is no product!\nTurning back to the administrator mode...");
                    rubbish = input.nextLine();
                    administratorMode();
                    return;
                }
                System.out.println(store.informationCheck(number-1));
                System.out.println("\nEnter any words to back to administrator mode...");
                rubbish = input.nextLine();
                administratorMode();
                break;
            case "2" :
                System.out.println("Name?");
                String name = input.nextLine();

                int flag = 1;
                for(int i = 0;i<store.total;i++){
                    if(Objects.equals(name,store.products[i].getName())){
                        System.out.println(store.informationCheck(i));
                        flag = 0;
                    }
                }
                if(flag == 1){
                    System.out.println("Can't find a corresponding costume!\nPlease enter any word to try again...");
                    rubbish = input.nextLine();
                    searchSpecificItem();
                }
                System.out.println("\nSuccessful pairing!\nEnter any word to back to the custom mode...");
                rubbish = input.nextLine();
                administratorMode();
                break;
            case "3" :
                System.out.println("Price?");
                String priceAcceptor = input.nextLine();
                try{
                    int price = Integer.parseInt(priceAcceptor);
                }catch(NumberFormatException e){
                    System.out.println("It's not a number!\nEnter any word to retry...");
                    rubbish = input.nextLine();
                    if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                        System.out.println("Exit the programme.Bye!");
                        return;
                    }
                    administratorSearchSpecificItem();
                }
                int price = Integer.parseInt(priceAcceptor);
                int[] priceArray = new int[100];
                int arrayNumber = 0;
                for(int i = 0;i<store.total;i++){
                    if(price == store.products[i].price){
                        priceArray[arrayNumber++] = store.products[i].getSNumber();
                    }
                }
                if(arrayNumber == 0){
                    System.out.println("There is no costume pairs your price.\nEnter any word to retry...");
                    rubbish = input.nextLine();
                    searchSpecificItem();
                }else{
                    for(int i = 0;i<arrayNumber;i++){
                        System.out.println(store.informationCheck(priceArray[i]-1)+"\n");
                    }
                    System.out.println("Successful match!\nEnter any word to exit...");
                    rubbish = input.nextLine();
                    if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                        System.out.println("Exit the programme.Bye!");
                        return;
                    }else{
                        administratorMode();
                    }
                }
                break;
            case "4" :
                System.out.println("Status?(Status 1 is on sale.Status 2 is lent out.Status 3 is sold out.)");
                String statusAcceptor = input.nextLine();
                try{
                    int status = Integer.parseInt(statusAcceptor);
                }catch(NumberFormatException e){
                    System.out.println("It's not a number!\nEnter any word to retry...");
                    rubbish = input.nextLine();
                    if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                        System.out.println("Exit the programme.Bye!");
                        return;
                    }
                    administratorSearchSpecificItem();
                }
                int status = Integer.parseInt(statusAcceptor);
                int[] statusArray = new int[100];
                int arrayStatusNumber = 0;
                for(int i = 0;i<store.total;i++){
                    if(status == store.products[i].status){
                        statusArray[arrayStatusNumber++] = store.products[i].getSNumber();
                    }
                }
                if(arrayStatusNumber == 0){
                    System.out.println("There is no costume pairs your status.\nEnter any word to retry...");
                    rubbish = input.nextLine();
                    administratorSearchSpecificItem();
                }else{
                    for(int i = 0;i<arrayStatusNumber;i++){
                        System.out.println(store.informationCheck(statusArray[i]-1)+"\n");
                    }
                    System.out.println("Successful match!\nEnter any word to exit...");
                    rubbish = input.nextLine();
                    if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                        System.out.println("Exit the programme.Bye!");
                        return;
                    }else{
                        administratorMode();
                    }
                }
                break;
            case "5" :
                System.out.println("Costume damaged or not?(If yes please enter y, no enter n)");
                String damage = input.nextLine();
                if(Objects.equals(damage,"n")){
                    int[] noArray = new int[100];
                    int noNumber = 0;
                    for(int i = 0;i<store.total;i++){
                        if(!store.products[i].isDamaged){
                            noArray[noNumber++] = store.products[i].getSNumber();
                        }
                    }
                    if(noNumber == 0){
                        System.out.println("There is no costume pairs which doesn't get damaged.\nEnter any word to retry...");
                        rubbish = input.nextLine();
                        administratorSearchSpecificItem();
                    }else{
                        for(int i = 0;i<noNumber;i++){
                            System.out.println(store.informationCheck(noArray[i]-1));
                        }
                        System.out.println("\nSuccessful match!\nEnter any word to exit...");
                        rubbish = input.nextLine();
                        if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                            System.out.println("Exit the programme.Bye!");
                            return;
                        }else{
                            administratorMode();
                        }
                    }
                }else if(Objects.equals(damage,"y")){
                    int[] yesArray = new int[100];
                    int yesNumber = 0;
                    for(int i = 0;i<store.total;i++){
                        if(store.products[i].isDamaged){
                            yesArray[yesNumber++] = store.products[i].getSNumber();
                        }
                    }
                    if(yesNumber == 0){
                        System.out.println("There is no costume pairs which get damaged.\nEnter any word to retry...");
                        rubbish = input.nextLine();
                        administratorSearchSpecificItem();
                    }else{
                        for(int i = 0; i< yesNumber; i++){
                            System.out.println(store.informationCheck(yesArray[i]-1));
                        }
                        System.out.println("\nSuccessful match!\nEnter any word to exit...");
                        rubbish = input.nextLine();
                        if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                            System.out.println("Exit the programme.Bye!");
                            return;
                        }else{
                            administratorMode();
                        }
                    }
                }else{
                    System.out.println("You are not entering a valid word!\nPlease try again later...");
                    rubbish = input.nextLine();
                    administratorSearchSpecificItem();
                }
                break;
            default:
                System.out.println("It's not a valid number!Please try again or enter exit to exit.\n Enter any thing to retry...");
                rubbish = input.nextLine();
                if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                    System.out.println("Exit the programme.Bye!");
                    return;
                }
                administratorMode();
        }
    }

    //6） 改变价格
    public void changePrice(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("Which Product would you like to change price?\nPlease enter the sequence number.");
        String numberAcceptor = input.nextLine();
        try{
            int number = Integer.parseInt(numberAcceptor);
        }catch(NumberFormatException e){
            System.out.println("It's not a number!\nEnter any word to retry...");
            rubbish = input.nextLine();
            if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                System.out.println("Exit the programme.Bye!");
                return;
            }
            administratorMode();
        }
        int number = Integer.parseInt(numberAcceptor);
        if(number > store.total){
            System.out.println("There is no product!\nTurning back to the administrator mode...");
            rubbish = input.nextLine();
            administratorMode();
            return;
        }
        System.out.println("Price?");
        String numberPriceAcceptor = input.nextLine();
        try{
            int priceNumber = Integer.parseInt(numberAcceptor);
        }catch(NumberFormatException e){
            System.out.println("It's not a number!\nEnter any word to retry...");
            rubbish = input.nextLine();
            if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                System.out.println("Exit the programme.Bye!");
                return;
            }
            administratorMode();
        }
        int price = Integer.parseInt(numberPriceAcceptor);
        store.products[number-1].price = price;
        store.products[number-1].priceHistory[store.products[number-1].priceHistoryNumber++] = price;
        System.out.println("Successfully change the costume's price!\nTurning back to administrator mode...");
        rubbish = input.nextLine();
        administratorMode();
        return;
    }

    //8） 改变商品状态
    public void changeProductState(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("Which Product would you like to change state?\nPlease enter the sequence number.");
        String numberAcceptor = input.nextLine();
        try{
            int number = Integer.parseInt(numberAcceptor);
        }catch(NumberFormatException e){
            System.out.println("It's not a number!\nEnter any word to retry...");
            rubbish = input.nextLine();
            if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                System.out.println("Exit the programme.Bye!");
                return;
            }
            administratorMode();
        }
        int number = Integer.parseInt(numberAcceptor);
        if(number > store.total){
            System.out.println("There is no product!\nTurning back to the administrator mode...");
            rubbish = input.nextLine();
            administratorMode();
            return;
        }
        System.out.println("State?(1/2/3,1 stands for in store, 2 stands for lending out,3 stands for purchased)\nPlease enter the sequence number.");
        String acceptor = input.nextLine();
        switch(acceptor){
            case "1" :
                store.products[number-1].status = 1;
                System.out.println("Successfully change the state!Turning back to administrator...");
                rubbish = input.nextLine();
                administratorMode();
                return;

            case "2":
                store.products[number-1].status = 2;
                System.out.println("Successfully change the state!Turning back to administrator...");
                rubbish = input.nextLine();
                administratorMode();
                return;
            case "3":
                store.products[number-1].status = 3;
                System.out.println("Successfully change the state!Turning back to administrator...");
                rubbish = input.nextLine();
                administratorMode();
                return;
            default:
                System.out.println("It's not a valid number!\nPlease enter any word to retry...");
                administratorMode();
        }
    }

    //5） 扩容商店库存上限
    public void expandStorage(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("Now the Store's capacity is " + store.capacity + "\nHow many products would you like to store?");
        String numberAcceptor = input.nextLine();
        try{
            int number = Integer.parseInt(numberAcceptor);
        }catch(NumberFormatException e){
            System.out.println("It's not a number!\nEnter any word to retry...");
            rubbish = input.nextLine();
            if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                System.out.println("Exit the programme.Bye!");
                return;
            }
            administratorMode();
        }
        int number = Integer.parseInt(numberAcceptor);
        if(number<store.capacity){
            System.out.println("You are entering a smaller number.Our store only allow to expand its capacity.\nTurning back to administrator mode...");
            rubbish = input.nextLine();
            administratorMode();
            return;
        }
        store.capacity = number;
        Arrays.copyOf(store.products,number);
        System.out.println("Successfully expansion!The store's capacity reaches " + number +" !\nTurning back to administrator mode...");
        rubbish = input.nextLine();
        administratorMode();

    }

    //7） 删除商品
    public void deleteProduct(){
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("Which Product would you like to delete?\nPlease enter the sequence number.");
        String numberAcceptor = input.nextLine();
        try{
            int number = Integer.parseInt(numberAcceptor);
        }catch(NumberFormatException e){
            System.out.println("It's not a number!\nEnter any word to retry...");
            rubbish = input.nextLine();
            if(Objects.equals(rubbish,"exit")||Objects.equals(rubbish,"Exit")){
                System.out.println("Exit the programme.Bye!");
                return;
            }
            administratorMode();
        }
        int number = Integer.parseInt(numberAcceptor);
        if(number > store.total){
            System.out.println("There is no product!\nTurning back to the administrator mode...");
            rubbish = input.nextLine();
            administratorMode();
            return;
        }
        for(int i = number;i<store.total;i++){
            store.products[i-1] = store.products[i];
            store.products[i-1].SNumber--;
            store.products[i] = null;

        }
        store.total--;
        System.out.println("Successfully delete!Turning back to administrator mode...");
        rubbish = input.nextLine();
        administratorMode();

    }

    //9） 检查请求
    public void checkRequest(){
        int flag = 1;
        int count = 0;
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println("Request Interface\nYou have " + store.getNewRequest() + " new requests,and totally you have " + store.getRequest() + " requests to deal with!");
        System.out.println("""
                Let's start to inspect all the requests need to be solved.
                The "wanted state" = 2 means custom want to borrow it,and 3 means they want to buy it.
                You can enter any word to get next,and you can enter "exit" to exit or enter "settle" if you have settled this request.
                """);
        rubbish = input.nextLine();
        if(Objects.equals(rubbish,"exit")){
            System.out.println("Exit the programme.Bye!");
            administratorMode();
            return;
        }
        while(flag == 1){
            System.out.print("\u001b[H\u001b[2J");
            System.out.flush();
            if(store.getRequest() == 0){
                System.out.println("There is no request remain! Allyes!!\nTurning back to administrator mode...");
                rubbish = input.nextLine();

                administratorMode();
                return;
            }
            if(count >= store.requestNumber){

                count = 0;
            }
            if(store.requestList[count].getNewOrReadOrSettled() == 3){
                //System.out.println(count);
                count++;
                continue;

            }
           // System.out.println(store.getRequest());


            if(store.requestList[count].getNewOrReadOrSettled() == 1){
                store.requestList[count].setNewOrReadOrSettled(2);
            }
            System.out.println(store.getRequestInformation(count));
            String acceptor = input.nextLine();
            if(Objects.equals(acceptor,"exit")){
                System.out.println("Exit the programme.Bye!");
                administratorMode();
                return;
            }else if(Objects.equals(acceptor,"settle")){
                System.out.println("Successfully settled!Enter any word to continue...");
                rubbish = input.nextLine();
                store.requestList[count].setNewOrReadOrSettled(3);
                if(Objects.equals(rubbish,"exit")){
                    System.out.println("Exit the programme.Bye!");
                    administratorMode();
                    return;
                }
            }


            count++;

        }
    }

    public void returnCustomInterface(String acceptor){

        if(Objects.equals(acceptor,"exit")||Objects.equals(acceptor,"Exit")){
            System.out.println("Exit the programme.Bye!");
            return;
        }else{
            customMode();
        }
    }

    public void returnAdministratorInterface(String acceptor){

        if(Objects.equals(acceptor,"exit")||Objects.equals(acceptor,"Exit")){
            System.out.println("Exit the programme.Bye!");
            return;
        }else{
            administratorMode();
        }

    }

    // 因为不能从内部函数退出外部函数，意义不大
//    public void Exit(String exit){
//        if(Objects.equals(exit,"exit")||Objects.equals(exit,"Exit")){
//            System.out.println("Exit the programme.Bye!");
//
//        }
//    }



    public static void main(String[] args){
        Driver driver = new Driver();
        driver.set();


    }



}
