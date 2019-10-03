package ru.avalon.java.dev.ocpjp.labs.models;

public class CommodityImpl implements Commodity, Cloneable {

    private String code;
    private String vendorCode;
    private String name;
    private double price;
    private int residue;
    
    protected CommodityImpl() {}

    public void setCode(String code) {this.code = code;}
    public void setVendorCode(String vendorCode) {this.vendorCode = vendorCode;}
    public void setName(String name) {this.name = name;}
    public void setPrice(double price) {this.price = price;}
    public void setResidue(int residue) {this.residue = residue;}

    @Override
    public String getCode() {return code;}
    
    @Override
    public String getVendorCode() {return vendorCode;}

    @Override
    public String getName() {return name;}

    @Override
    public double getPrice() {return price;}

    @Override
    public int getResidue() {return residue;}
    
    @Override
    protected CommodityImpl clone() {
        try {
            return (CommodityImpl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException (e);
        }
    }
    
    static CommodityImplBuilder builder() {
        return new CommodityImplBuilder();
    }
    
    static class CommodityImplBuilder implements CommodityBuilder {

        private CommodityImpl dummy = new CommodityImpl();
        
        private CommodityImplBuilder() {}
        
        @Override
        public CommodityBuilder code(String code) {
            dummy.code = code;
            return this;
        }

        @Override
        public CommodityBuilder vendorCode(String vendorCode) {
            dummy.vendorCode = vendorCode;
            return this;
        }

        @Override
        public CommodityBuilder name(String name) {
            dummy.name = name;
            return this;
        }

        @Override
        public CommodityBuilder price(double price) {
            dummy.price = price;
            return this;
        }

        @Override
        public CommodityBuilder residue(int residue) {
            dummy.residue = residue;
            return this;
        }

        @Override
        public Commodity build() {return dummy.clone();}
        
    }
    
}
