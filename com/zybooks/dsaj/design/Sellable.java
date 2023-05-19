package com.zybooks.dsaj.design;

/** Interface for objects that can be sold. */
public interface Sellable {

    /**
     * Returns a description of the object. 
     * @return a description of the object
     */
    public String description();

    /**
     * Returns the list price of the item in cents.
     * @return the list price of the item in cents
     */
    public int listPrice();

    /**
     * Returns the lowest price, in cents, we will accept.
     * @return the lowest price, in cents, we will accept
     */
    public int lowestPrice();
}
