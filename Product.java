class Product{
    //attributes
    private String productType = "";
    private String brand = "";
    private String model = "";
    private double price = 0.0;
    private int traceNum = 0;
    private int countStock = 0;
    private String status = "";

    // constructor
    Product(){

    }
     Product(String productType, String brand, String model, 
     double price, int traceNum, int countStock, String status) {
        this.productType = productType;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.traceNum = traceNum;
        this.countStock = countStock;
        this.status = status;
    }

    // getters setters
    
    public void setProductType(String productType) { 
        this.productType = productType; 
    }
    public void setBrand(String brand) { 
        this.brand = brand; 
    }
    public void setModel(String model) { 
        this.model = model; 
    }
    public void setPrice(double price) {
         this.price = price; 
    }
    public void setTraceNum(int traceNum) {
         this.traceNum = traceNum;
    }
    public void setCountStock(int countStock) {
         this.countStock = countStock; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }

    public String getProductType() { 
        return productType; 
    }
    public String getBrand() { 
        return brand; 
    }
    public String getModel() { 
        return model;
    }
    public double getPrice() {
         return price; 
    }
    public int getTraceNum() { 
        return traceNum;
     }
    public int getCountStock() { 
        return countStock; 
    }
    public String getStatus() { 
        return status; 
    }
}