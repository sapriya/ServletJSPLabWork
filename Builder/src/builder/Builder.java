/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

class notValid extends Exception{
    notValid(){
        System.out.println("The fileds do not satisfy the integrity Rules set up");
    }
}

/**
 *
 * @author sapriya
 */
class Target {
    private int fieldA;//Rule: Should always be between 1-10
    private String fieldB;//Rule: Must not be null
    private String fieldC;//Rule: Must not be null
    private int fieldD;//Rule: should be greater than field E
    private int fieldE;

    Target(TargetBuilder builder){
    this.fieldA = builder.fieldA;
    this.fieldB = builder.fieldB;
    this.fieldC = builder.fieldC;
    this.fieldD = builder.fieldD;
    this.fieldE = builder.fieldE;
    }
    boolean isValid() throws notValid{
        try{
            if(fieldA>0&&fieldA<10&&fieldB!=null&&fieldC!=null&&fieldD>fieldE){
               System.out.println("Successfull creation of Target type class object");
               return true;}else{throw new notValid();}
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
       }
    public static class TargetBuilder{
    int fieldA;
    String fieldB;
    String fieldC;
    int fieldD;
    int fieldE;
    private Target t = new Target(this);
    public TargetBuilder A(int a){this.fieldA = a;return this;}
    public TargetBuilder B(String b){this.fieldB = b;return this;}
    public TargetBuilder C(String c){this.fieldC = c;return this;}
    public TargetBuilder D(int d){this.fieldD = d;return this;}
    public TargetBuilder E(int e){this.fieldE = e;return this;}
   
    //Create class only if build valid
    public Target build() throws notValid{
        t = new Target(this);
        if(t.isValid()){
            return t;
                    }else{
            return null;
        }
                }
    
    public static TargetBuilder factoryMethod(){
        return new TargetBuilder();
            }
    }
}

public class Builder {
   
    public static void main(String[] args) throws notValid {
        //Check
        Target.TargetBuilder objTarget = new Target.TargetBuilder().factoryMethod();
        objTarget.A(4).B("Hello to").C("builder pattern").D(3).E(2).build();
        objTarget.A(4).B("Hello to").C("builder pattern").D(1).E(2).build();
        objTarget.A(4).B("Hello to").C("builder pattern").D(5).E(2).build();
    }
    
}
