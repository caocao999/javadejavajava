package MyJavaUtil;

public class MyArrayList implements MyIterator{
    static final int unit_size = 10 ;
    int buffer_limit ;
    private  Object internal_array[] ;
    int  index ;

    //デバッグ用途専用
    public static void main(String[] argvs) {
        MyArrayList  tmp = new MyArrayList(100);
        for(int i = 0 ; i< 100; i++) {
            tmp.add(i+"1111");
        }
        tmp.printAll();
    }

   //非公開メソッド群
    private void  MyArrayCopy(Object[] src,Object[] dst, int size) {
        for(int i=0 ; i < size ; i++) {
            dst[i] = src[i] ;
        }
    }


    //公開メソッド群
    public MyArrayList() {
        this.buffer_limit = unit_size ;
        this.index = 0;
        this.internal_array = new Object[buffer_limit];
    }
    public MyArrayList(int buffer_size) {
        this.buffer_limit = buffer_size ;
        this.index = 0;
        this.internal_array = new Object[buffer_limit];
    }
    public void  add(Object obj) {
        if(this.index < this.buffer_limit) {
            this.internal_array[this.index] = obj ;
            this.index++ ;
            //System.out.println("index : "+ index+" obj : " + obj ) ;
        } else {
            this.buffer_limit += unit_size ;
            Object[] tmp  = new Object[this.buffer_limit] ;
            this.MyArrayCopy(this.internal_array, tmp, index);
            this.internal_array = tmp;
            this.internal_array[index] = obj ;
            index++;
        }
    }
    //still dummies to avoid warning
    public boolean hasNext() {
        return false;
    }
    public Object next(int i) {
        return null;
    }
    //デバッグ用メソッド群
    private void printAll() {
        for(int i = 0  ; i < index; i++) {
            System.out.println(i+ " "+ this.internal_array[i]) ;
        }
    }
}
