# E-Commerce System (Java)

A simple, clear OOP-based E-Commerce simulation in Java. This system allows definition of various products (some expirable, some shippable), maintains a shopping cart per customer, handles order checkout (including balance checks), and prints clear shipping and checkout receipts.

---

## 🚀 Features

- **Product Definition:** Name, price, available quantity, shippable (with weight), expirable (with expiry date).
- **Expiry and Shipping:** Supports checking for expired products and grouping shippable items by type and weight.
- **Cart Management:** Add products with check on available stock, remove or clear items.
- **Checkout Process:** Verifies cart is not empty, validates all products (stock & expiry), confirms customer balance.
- **Shipping Service:** Generates shipment notice, groups identical shippable products, calculates total package weight.
- **Receipt Printing:** Shows order breakdown, shipping fees, customer’s remaining balance.
- **Error Handling:** Cart empty, insufficient balance, out-of-stock or expired products.
- **OOP Design:** Easily extendable for future modifications.

---

## 📂 System Components

| Class/File          | Description                                                  |
|---------------------|-------------------------------------------------------------|
| `Products`          | Product attributes, expiry/shipping logic, stock deduction. |
| `Cart`              | Shopping cart, add/remove items, subtotal computation.      |
| `Customer`          | Customer with name and account balance.                     |
| `ShippingService`   | Shipping logic, aggregates shippable products.              |
| `CheckoutManager`   | Performs all validations and prints receipts.               |
| `Main`              | Example usage of the system (sample integration).           |

---

## 🏁 Quick Start

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/e-commerce-system-java.git
   cd e-commerce-system-java
