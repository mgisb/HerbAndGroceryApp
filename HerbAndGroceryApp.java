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

/* Home Page Class
void displayMainMenu() {
Display “Home Menu” over a popup;
Await User Input;
}

void displayProductsMenu() {
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

/* Products Class
void displayProductsMenu() {
Display “Products” over a popup;
Await User Input;
}

void displayCartMenu() {
Display “Cart” over a popup;
Await User Input;
}

void searchBar(user_input) {
	display<< selection;
}

void displayProduct1() {
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

/* Shopping Cart Class
void displayAddedProducts() {
	Display addedSelection over a popup;
	Await User Input;
}

void adjustProductAmount(user_input) {
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
