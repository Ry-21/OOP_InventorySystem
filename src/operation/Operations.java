package operation;

import products.Product;

public class Operations{


    /* LINKEDLIST IN THE AREA */
    private Node head; // Head node

    // innerNode
    private class Node {
        Product data;
        Node next;

        Node(Product data) {
            this.data = data;
            this.next = null;
        }
    }

        // adjust product status based on countStock
        // 10 stock set change if you want
    public void adjustProductStatus() {
        Node current = head;
        while (current != null) {
            if (current.data.getCountStock() == 0) {
                current.data.setStatus("Sold Out");
            } else if (current.data.getCountStock() < 10) {
                current.data.setStatus("Low Stock");
            } else {
                current.data.setStatus("Available");
            }
            current = current.next;
        }
    }
//  set the status of a product
    public void setProductStatus(Product product) {
        if (product.getCountStock() == 0) {
            product.setStatus("Sold Out");
        } else if (product.getCountStock() < 10) {
            product.setStatus("Low Stock");
        } else {
            product.setStatus("Available");
        }
    }

    //when stock is nearing the sold-out threshol
    public void notifyLowStock() {
        Node current = head;
        while (current != null) {
            if (current.data.getCountStock() <= 10) {
                System.out.println("Alert: Product " + 
                    current.data.getModel() + 
                    " is nearing sold out! (" + current.data.getCountStock() 
                    + " remaining)");
            }
            current = current.next;
        }
    }

    //total quantity and price of products
    public void totalProduct() {
        int totalQty = 0;
        double totalPrice = 0.0;

        Node current = head;
        while (current != null) {
            totalQty += current.data.getCountStock();
            totalPrice += current.data.getCountStock() * current.data.getPrice();
            current = current.next;
        }

        System.out.println("Total Qty: " + totalQty);
        System.out.println("Total Price: " + totalPrice);
    }

    // total sales
    public void totalSales() {
        int totalQtySold = 0;
        double totalSales = 0.0;

        Node current = head;
        while (current != null) {
            int soldQty = current.data.getCountStock(); // Assuming countStock is decremented after sale
            if (soldQty < 10) {
                totalQtySold += soldQty;
                totalSales += soldQty * current.data.getPrice();
            }
            current = current.next;
        }

        System.out.println("Total Sales Qty: " + totalQtySold);
        System.out.println("Total Sales Amount: " + totalSales);
    }

//________________________________________________________//
    // Add
    public void add(Product product) {
        Node newNode = new Node(product);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Edit
    public boolean edit(int traceNum, Product updatedProduct) {
        Node current = head;
        while (current != null) {
            if (current.data.getTraceNum() == traceNum) {
                current.data = updatedProduct;
                return true;
            }
            current = current.next;
        }
        return false; // trace number not found
    }
    public boolean edit(String model, Product updatedProduct) {
        Node current = head;
        while (current != null) {
            if ((current.data.getModel()).compareTo(model) == 0) {
                current.data = updatedProduct;
                return true;
            }
            current = current.next;
        }
        return false; // trace number not found
    }

    // Search 
    public Product search(int traceNum) { //via tracenum
        Node current = head;
        while (current != null) {
            if (current.data.getTraceNum() == traceNum) {
                return current.data;
            }
            current = current.next;
        }
        return null; // Not found
    }
    public Product search(String model) { //via model
        Node current = head;
        while (current != null) {
            if ((current.data.getModel()).compareTo(model) == 0) {
                return current.data;
            }
            current = current.next;
        }
        return null; // Not found
    }

    // Remove
    public boolean remove(int traceNum) { //tracenum
        if (head == null) {
            return false; // List is empty
        }

        if (head.data.getTraceNum() == traceNum) {
            head = head.next; // Remove head node
            return true;
        }

        Node current = head;
        while (current.next != null && 
            current.next.data.getTraceNum() != traceNum) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next; // Bypass the node to be removed
            return true;
        } else {
            return false; // Trace number not found
        }
    }
    public boolean remove(String model) { //model
        if (head == null) {
            return false; // List is empty
        }

        if ((head.data.getModel()).compareTo(model) == 0) {
            head = head.next; // Remove head node
            return true;
        }

        Node current = head;
        while (current.next != null && 
            (current.next.data.getModel()),compareTo(model) != 0) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next; // Bypass the node to be removed
            return true;
        } else {
            return false; // Trace number not found
        }
    }

    // Print inventory
    public void printAll() {
        if (head == null) {
            System.out.println("No products in the list.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    public void clear() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            if (os.contains("win")) {
                // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Unix-based systems (Linux/macOS)
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}