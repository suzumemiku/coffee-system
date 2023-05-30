package Experiment1;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Coffee extends Product {
    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;

    public Coffee(String var1, String var2, double var3, String var5, String var6, String var7, String var8, String var9, String var10) {
        super(var1, var2, var3);
        this.origin = var5;
        this.roast = var6;
        this.flavor = var7;
        this.aroma = var8;
        this.acidity = var9;
        this.body = var10;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getRoast() {
        return this.roast;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public String getAroma() {
        return this.aroma;
    }

    public String getAcidity() {
        return this.acidity;
    }

    public String getBody() {
        return this.body;
    }

    public String toString() {
        return super.toString() + "_" + this.getOrigin() + "_" + this.getRoast() + "_" + this.getFlavor() + "_" + this.getAroma() + "_" + this.getAcidity() + "_" + this.getBody();
    }
}
