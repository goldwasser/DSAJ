package com.zybooks.dsaj.design;

/** Interface for objects that can be transported. */
public interface Transportable {
    /**
     * Returns the weight of the item.
     * @return the weight of the item
     */
    public int weight();
    
    /**
     * Returns whether the item is hazardous.
     * @return true if the item is hazardous, else false
     */
    public boolean isHazardous();
}
