package com.zybooks.dsaj.design;

/** Class for objects that can be sold, packed, and shipped. */
public class BoxedItem implements Sellable, Transportable {
    private String descript;      // description of this item
    private int price;            // list price in cents
    private int weight;           // weight in grams
    private boolean haz;          // true if object is hazardous
    private int height=0;         // box height in centimeters
    private int width=0;          // box width in centimeters
    private int depth=0;          // box depth in centimeters

    /**
     * Constructor
     * @param desc   a description of the item
     * @param p      the price of the item in cents
     * @param w      the weight of the item in grams
     * @param h      true if object is hazardous
     */
    public BoxedItem(String desc, int p, int w, boolean h) {
        descript = desc;
        price = p;
        weight = w;
        haz = h;
    }

    /**
     * Returns a description of the item.
     * @return a description of the item
     */
    public String description() { return descript; }
    
    /**
     * Returns the list price of the item in cents.
     * @return the list price of the item in cents
     */
    public int listPrice() { return price; }
    
    /**
     * Returns the lowest price, in cents, we will accept.
     * @return the lowest price, in cents, we will accept
     */
    public int lowestPrice() { return price/2;  }
    
    /**
     * Returns the weight of the item.
     * @return the weight of the item
     */
    public int weight() { return weight; }
    
    /**
     * Returns whether the item is hazardous.
     * @return true if the item is hazardous, else false
     */
    public boolean isHazardous() { return haz; }
    
    /**
     * Returns the insured value of the item.
     * @return the insured value of the item
     */
    public int insuredValue() { return price*2; }
    
    /**
     * Sets the dimensions of the item's box.
     * @param h   the height of the box
     * @param w   the width of the box
     * @param d   the depth of the box
     */
    public void setBox(int h, int w, int d) {
        height = h;
        width = w;
        depth = d;
    }
}
