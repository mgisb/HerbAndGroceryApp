import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class HerbAndGroceryApp {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JTextField searchField;
    

    public HerbAndGroceryApp() {
        frame = new JFrame("Herb and Grocery App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        // user stuff for testing
        ArrayList<String> groceries = new ArrayList<>();
        groceries.add("Apples");
        groceries.add("Bananas");
        groceries.add("Milk");
        groceries.add("Bread");
        groceries.add("Eggs");
        groceries.add("Cheese");
        groceries.add("Tomatoes");
        groceries.add("Potatoes");
        groceries.add("Onions");
        UserClass user = new UserClass(243, "johndoetest", "john123", "605 Halifax Street Blackwood, NJ 08012","johndoe@gmail.com",groceries);

        // Creates tabs
        tabbedPane = new JTabbedPane();
        CardLayout tab1CardLayout = new CardLayout();
        JPanel tab1 = new JPanel(tab1CardLayout);
        JPanel tab2 = new JPanel();
        tab2.add(new JLabel("Products go here"));
        JPanel tab3 = new JPanel();
        tab3.add(new JLabel("Shopping Cart items go here"));
        tabbedPane.addTab("Home", tab1);
        tabbedPane.addTab("Products", tab2);
        tabbedPane.addTab("Shopping Cart", tab3);

        // Creates search panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Creates main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(searchPanel, BorderLayout.NORTH);

        frame.add(mainPanel);
        frame.setVisible(true);

        // handles all buttons
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                System.out.println("Button clicked: " + clickedButton.getText());
                if (clickedButton.getText() == "Back"){
                    tab1CardLayout.show(tab1, "buttonpanel");
                } else if (clickedButton.getText() == "Profile"){
                    tab1CardLayout.show(tab1, "profile");
                } else if (clickedButton.getText() == "Orders"){
                    tab1CardLayout.show(tab1, "orders");
                }
            }
        };

        // creating homepage layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,1));
        JButton profileButton = new JButton("Profile");
        JButton ordersButton = new JButton("Orders");
        JButton button3 = new JButton("Your List");
        JButton button4 = new JButton("Customer Service");
        Font buttonFont = new Font("Times", Font.BOLD, 25);
        profileButton.addActionListener(listener);
        ordersButton.addActionListener(listener);
        profileButton.setFont(buttonFont);
        ordersButton.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);
        buttonPanel.add(profileButton);
        buttonPanel.add(ordersButton);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        tab1.add(buttonPanel, "buttonpanel");
        tab1CardLayout.show(tab1, "buttonpanel");


        // creating profile frame
        JPanel profile = new JPanel();
        profile.setLayout(new GridLayout(4,1));
        Font labelFont = new Font("Times", Font.BOLD, 15);
        JLabel username = new JLabel("Username: "+user.getUsername());
        JLabel email = new JLabel("Email: "+user.getEmail());
        JLabel address = new JLabel("Address: "+user.getUserAddress());
        JButton back = new JButton("Back");
        back.addActionListener(listener);
        username.setFont(labelFont);
        email.setFont(labelFont);
        address.setFont(labelFont);
        back.setFont(labelFont);
        profile.add(username);
        profile.add(email);
        profile.add(address);
        profile.add(back);
        tab1.add(profile, "profile");

        // creating orders frame
        JPanel ordersFrame = new JPanel();
        ordersFrame.setLayout(new GridLayout(0,1));
        for (String item : user.getUserOrder()) {
            JButton button = new JButton(item);
            ordersFrame.add(button);
        }
        JScrollPane scrollPane = new JScrollPane(ordersFrame);
        JButton ordersBack = new JButton("Back");
        ordersBack.setFont(labelFont);
        ordersBack.addActionListener(listener);
        ordersFrame.add(ordersBack);
        tab1.add(scrollPane, "orders");

    }

    private void search() {
        String query = searchField.getText();
        // Perform search functionality here
        JOptionPane.showMessageDialog(frame, "Searching for: " + query);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HerbAndGroceryApp();
            }
        });
    }
}


// pseudocode is from assignment 3

/* User Interface Class
void pressEnter() {
Display “Press Enter to continue”;
Await User Input;
}

void clearScreen() {
Display “Clear Screen” over a popup;
Await User Input;
}

void displayUserLoginMenu() {
Display “User Login” over a popup;
Await User Input;
}

char getChar() {
Await user input for storing char data
return char;
}

char getString() {
Await user input for storing string data
return string;
}

char getInt() {
Await user input for storing int data
return int;
} */

/* void displayProductsMenu() {
Display “Products” over a popup;
Await User Input;
}

void displayCartMenu() {
Display “Cart” over a popup;
Await User Input;
}

void displayProfileMenu() {
Display “Profile” over a popup;
Await User Input;
}

void displayOrdersMenu() {
Display “Your Orders” over a popup;
Await User Input;
}

void displayListsMenu() {
Display “Your Lists” over a popup;
Await User Input;
}

void displayCustomerServiceMenu() {
Display “Customer Service” over a popup;
Await User Input;
} */

/* void displayProduct1() {
Display’s a product over a popup;
Await User Input;
}

void displayProduct2() {
Display’s a product over a popup;
Await User Input;
}

void displayProduct3() {
Display’s a product over a popup;
Await User Input;
} */


/* void adjustProductAmount(user_input) {
Display << “Enter (1) to add +1 quantity \n Enter (2) to remove -1 quantity”;
	Get >> selection;

	if(selection == 1)
update productQuantity(user_input);

else if (selection==2)
update productQuantity(user_input);

else ()
display<<”Please enter a valid response”;
}

void removeProduct(user_input) {
Display << “Enter (1) to remove the product from your shopping cart.”;
	Get >> selection;

	if(selection == 1)
update productInCart(user_input);

else ()
display<<”Please enter a valid response”;
}

void checkOut(user_input) {
Display << “Enter (1) to checkout”;
	Get >> selection;

	if(selection == 1)
display Checkout class in a popup;

else ()
display<<”Please enter a valid response”;
}

float getTotal() {
	Await user input for addedSelection;
	return cartTotal;
}

display cartTotal() {
	Display getTotal();
} */

/* Profile Class

  string set userName(user_input){
	ProfileClass.userName=user_input;
}
string getUserName constant() {
    return ProfileClass.userName;
}

string setUserAddress(user_input){
	ProfileClass.userAddress = user_input;
}

string getuserAddress() {
    return ProfileClass.address;
}
map<string, string> setContactInfo(user_input){
	ProfileClass.contactinfo = user_input;

}
map <string, string> getContactInfo(){
	return ProfileClass.contact;
}
vector<string> setSavedPayment(user_input){
	ProfileClass.savedpayment=user_input;
}
vector<string> getSavedPayment(){
	return ProfileClass.savedpayment;
} */

/* Orders Class
vector<map<string, any>> PastOrder(const string& customerID,string orderID, string orderDate, vector<pair<string,int>> items, float total) {
    vector<map<string, any>> order;
    return order;
}
vector<map<string, any>> CurrentOrder(const string& customerID,string orderID, string orderDate, vector<pair<string,int>> items, float total) {
    vector<map<string, any>> order;
    return order;
} */

/* Lists Class
void displayList(const string& listID) {
	Display list contents;
}
vector<pair<string,int>> createList(const &string listID){
	vector<pair<string,int>> newList;
	return newList;
}

vector<pair<string,int>> addItemToList(vector<pair<string,int>> &list, vector<pair<string,int>> items){
	vector<pair<string,int>> tempList;
	tempList.append(items);
	return tempList;
}

vector<pair<string,int>> removeItemFromList(vector<pair<string,int>> &list, vector<pair<string,int>> items){
	vector<pair<string,int>> tempList;
	tempList.remove(items);
	return tempList;
}

vector<pair<string,int>> editList(vector<pair<string,int>> &list){
	vector<pair<string,int> tempList;
	Display <<”Enter 1 to add items, 2 to remove items, 3 to update list”>>
	case:
	1:addItemToList(tempList);
	2: removeItemFromList(tempList);
	3: return tempList;
} */

/* Product Item Class
void() {
def getName(self):
        return self.name

    def setName(self, name):
        self.name = name

    def getPrice(self):
        return self.price

    def setPrice(self, price):
        self.price = price

    def getQuantity(self):
        return self.quantity

    def setQuantity(self, quantity):
        self.quantity = quantity

    def calculateTotalPrice(self, quantity):
        return self.price * quantity

    def updateQuantity(self, quantity_purchased):
        self.quantity -= quantity_purchased

    def addDiscount(self, discount):
        self.price -= self.price * (discount / 100)

    def checkAvailability(self, required_quantity):
        return self.quantity >= required_quantity

} */

/* Search Function Class
void() {
def searchByName(self, name):
        for item in self.productItems:
            if item.get_name() == name:
                return item
        return None


def searchByPrice(self, min, max):
        result = []
        for item in self.productItems:
            if min_price <= item.get_price() <= max_price:
                result.append(item)
        return result

def searchAvailability(self):
        result = []
        for item in self.productItems:
            if item.get_quantity() > 0:
                result.append(item)
        return result



} */

/* Checkout Class
void() {
def addItem(self, productItem):
        self.cart.append(productItem)

    def removeItem(self, productItem):
        if productItem in self.cart:
            self.cart.remove(productItem)
        else:

    def applyDiscount(self, discountCode):
        if discountCode in self.available_discounts:
            discount_percent = self.available_discounts[discountCode]
            total_price = productClass.calculateTotalPrice()
            discounted_price = total_price * (1 - discount_percent / 100)
            return discounted_price
        else:
            print("Invalid discount code.")
            return productClass.calculateTotalPrice()

    def generateReceipt(self):
        total_price = productClass.calculateTotalPrice()
        receipt = "Receipt:\n"
        for item in self.cart:
            receipt += f"{item.getName()}: ${item.getPrice()}\n"
        receipt += f"Total Price: ${total_price}\n"
        return receipt

} */

/* Account Info
void() {
def getUsername(self):
        return self.username

    def setUsername(self, username):
        self.username = username

    def getEmail(self):
        return self.email

    def setEmail(self, email):
        self.email = email

    def authenticate(self, username, password):
        return self.username == username and self.password == password

    def updatePassword(self, new_password):
        self.password = new_password

    def updateEmail(self, new_email):
        self.email = new_email

} */

/* Placed Orders Class
vector<map<string, any>> pastOrders(const string& customerID) {
    vector<map<string, any>> orders;
    // Database query and populate orders
    return orders;
}

string orderID(const string& orderID) {
    string id;
    // Database query to get order ID
    return id;
}

string orderDate(const string& orderID) {
    string date;
    // Database query to get order date
    return date;
}

vector<pair<string, int>> orderItemized(const string& orderID) {
    vector<pair<string, int>> items;
    // Database query to get itemized list of the order
    return items;
}

float orderTotal(const string& orderID) {
    float total = 0;
    // Database query to calculate order total
    return total;
} */

/* Saved For Later Class
vector<string> listID(const string& userID) {
    vector<string> listIDs;
    // Database query to get listIDs for userID
    return listIDs;
}

string listDate(const string& listID) {
    string date;
    // Database query to get listDate for listID
    return date;
}

vector<pair<string, int>> listDetails(const string& listID) {
    vector<pair<string, int>> details;
    // Database query to get list details for listID
    return details;
} */

/* Contact Support Class
string ticket(const string& userID, const string& details) {
    string newTicketID;
    // Generate newTicketID and save ticket with userID and details
    return newTicketID;
}

vector<string> ticketID(const string& userID) {
    vector<string> ticketIDs;
    // Database query to get ticketIDs for userID
    return ticketIDs;
}

string ticketDetails(const string& ticketID) {
    string details;
    // Database query to get details for ticketID
    return details;
}

string ticketStatus(const string& ticketID) {
    string status;
    // Database query to get status for ticketID
    return status;
} */

/* Payment Class
string orderReceipt(const string& orderID) {
    string receiptID;
    // Generate or retrieve receiptID for orderID
    return receiptID;
}

float orderPrice(const string& orderID) {
    float price;
    // Retrieve price for orderID
    return price;
}

float orderTax(const string& orderID) {
    float taxRate = 0.08; // Example tax rate
    float price;
    // Retrieve price for orderID to calculate tax
    float tax = price * taxRate;
    return tax;
}

float orderTotal(const string& orderID) {
    float price;
    float tax;
    // Calculate total for orderID
    float total = price + tax;
    return total;
} */

/* Update Account Info Class
string userName(const string& userID) {
    string name;
    // Retrieve userName for userID
    return name;
}

string userAddress(const string& userID) {
    string address;
    // Retrieve userAddress for userID
    return address;
}

map<string, string> userContactInfo(const string& userID) {
    map<string, string> contactInfo;
    // Retrieve userContactInfo for userID
    return contactInfo;
}

vector<string> savedPaymentMethods(const string& userID) {
    vector<string> paymentMethods;
    // Retrieve savedPaymentMethods for userID
    return paymentMethods;
}

vector<string> userLists(const string& userID) {
    vector<string> lists;
    // Retrieve userLists for userID
    return lists;
} */
