public class Info {
    int product;

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public Info(int product) {
        this.product = product;
    }

    public void produce(){
        product++;
        System.out.println("生产了一个产品，目前库存为："+product);
    }
    public void consumption(){
        product--;
        System.out.println("消费了一个产品，目前库存为："+product);

    }

}
